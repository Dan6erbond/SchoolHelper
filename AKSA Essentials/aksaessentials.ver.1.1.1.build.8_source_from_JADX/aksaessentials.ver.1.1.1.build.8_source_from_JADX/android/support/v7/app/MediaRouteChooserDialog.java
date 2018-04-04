package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteGroup;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.mediarouter.C0280R;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MediaRouteChooserDialog extends Dialog {
    private static final String TAG = "MediaRouteChooserDialog";
    private RouteAdapter mAdapter;
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private ListView mListView;
    private AsyncTask<Void, Void, Void> mOnItemClickTask;
    private AsyncTask<Void, Void, Void> mRefreshRoutesTask;
    private final MediaRouter mRouter;
    private ArrayList<RouteInfo> mRoutes;
    private MediaRouteSelector mSelector;

    class C02381 extends AsyncTask<Void, Void, Void> {
        private ArrayList<RouteInfo> mNewRoutes;

        C02381() {
        }

        protected void onPreExecute() {
            this.mNewRoutes = new ArrayList(MediaRouteChooserDialog.this.mRouter.getRoutes());
            MediaRouteChooserDialog.this.onFilterRoutes(this.mNewRoutes);
        }

        protected Void doInBackground(Void... params) {
            synchronized (MediaRouteChooserDialog.this) {
                if (!isCancelled()) {
                    RouteComparator.loadRouteUsageScores(MediaRouteChooserDialog.this.getContext(), this.mNewRoutes);
                }
            }
            return null;
        }

        protected void onPostExecute(Void params) {
            MediaRouteChooserDialog.this.mRoutes.clear();
            MediaRouteChooserDialog.this.mRoutes.addAll(this.mNewRoutes);
            Collections.sort(MediaRouteChooserDialog.this.mRoutes, RouteComparator.sInstance);
            MediaRouteChooserDialog.this.mAdapter.notifyDataSetChanged();
            MediaRouteChooserDialog.this.mRefreshRoutesTask = null;
        }
    }

    private final class MediaRouterCallback extends Callback {
        private MediaRouterCallback() {
        }

        public void onRouteAdded(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteRemoved(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteChanged(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteSelected(MediaRouter router, RouteInfo route) {
            MediaRouteChooserDialog.this.dismiss();
        }
    }

    private final class RouteAdapter extends ArrayAdapter<RouteInfo> implements OnItemClickListener {
        private final Drawable mBluetoothIcon;
        private final Drawable mDefaultIcon;
        private final LayoutInflater mInflater;
        private final Drawable mSpeakerGroupIcon;
        private final Drawable mSpeakerIcon;
        private final Drawable mTvIcon;

        public RouteAdapter(Context context, List<RouteInfo> routes) {
            super(context, 0, routes);
            this.mInflater = LayoutInflater.from(context);
            TypedArray styledAttributes = getContext().obtainStyledAttributes(new int[]{C0280R.attr.mediaRouteDefaultIconDrawable, C0280R.attr.mediaRouteBluetoothIconDrawable, C0280R.attr.mediaRouteTvIconDrawable, C0280R.attr.mediaRouteSpeakerIconDrawable, C0280R.attr.mediaRouteSpeakerGroupIconDrawable});
            this.mDefaultIcon = styledAttributes.getDrawable(0);
            this.mBluetoothIcon = styledAttributes.getDrawable(1);
            this.mTvIcon = styledAttributes.getDrawable(2);
            this.mSpeakerIcon = styledAttributes.getDrawable(3);
            this.mSpeakerGroupIcon = styledAttributes.getDrawable(4);
            styledAttributes.recycle();
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int position) {
            return ((RouteInfo) getItem(position)).isEnabled();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            boolean isConnectedOrConnecting = true;
            View view = convertView;
            if (view == null) {
                view = this.mInflater.inflate(C0280R.layout.mr_chooser_list_item, parent, false);
            }
            RouteInfo route = (RouteInfo) getItem(position);
            TextView text1 = (TextView) view.findViewById(C0280R.id.mr_chooser_route_name);
            TextView text2 = (TextView) view.findViewById(C0280R.id.mr_chooser_route_desc);
            text1.setText(route.getName());
            String description = route.getDescription();
            if (!(route.getConnectionState() == 2 || route.getConnectionState() == 1)) {
                isConnectedOrConnecting = false;
            }
            if (!isConnectedOrConnecting || TextUtils.isEmpty(description)) {
                text1.setGravity(16);
                text2.setVisibility(8);
                text2.setText("");
            } else {
                text1.setGravity(80);
                text2.setVisibility(0);
                text2.setText(description);
            }
            view.setEnabled(route.isEnabled());
            ImageView iconView = (ImageView) view.findViewById(C0280R.id.mr_chooser_route_icon);
            if (iconView != null) {
                iconView.setImageDrawable(getIconDrawable(route));
            }
            return view;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            final RouteInfo route = (RouteInfo) getItem(position);
            if (route.isEnabled() && MediaRouteChooserDialog.this.mOnItemClickTask == null) {
                MediaRouteChooserDialog.this.mOnItemClickTask = new AsyncTask<Void, Void, Void>() {
                    protected void onPreExecute() {
                        route.select();
                    }

                    protected Void doInBackground(Void... params) {
                        RouteComparator.storeRouteUsageScores(RouteAdapter.this.getContext(), route.getId());
                        return null;
                    }

                    protected void onPostExecute(Void params) {
                        MediaRouteChooserDialog.this.dismiss();
                        MediaRouteChooserDialog.this.mOnItemClickTask = null;
                    }
                }.execute(new Void[0]);
            }
        }

        private Drawable getIconDrawable(RouteInfo route) {
            Uri iconUri = route.getIconUri();
            if (iconUri != null) {
                try {
                    Drawable drawable = Drawable.createFromStream(getContext().getContentResolver().openInputStream(iconUri), null);
                    if (drawable != null) {
                        return drawable;
                    }
                } catch (IOException e) {
                    Log.w(MediaRouteChooserDialog.TAG, "Failed to load " + iconUri, e);
                }
            }
            return getDefaultIconDrawable(route);
        }

        private Drawable getDefaultIconDrawable(RouteInfo route) {
            switch (route.getDeviceType()) {
                case 1:
                    return this.mTvIcon;
                case 2:
                    return this.mSpeakerIcon;
                case 3:
                    return this.mBluetoothIcon;
                default:
                    if (route instanceof RouteGroup) {
                        return this.mSpeakerGroupIcon;
                    }
                    if (route.isDeviceTypeBluetooth()) {
                        return this.mBluetoothIcon;
                    }
                    return this.mDefaultIcon;
            }
        }
    }

    private static final class RouteComparator implements Comparator<RouteInfo> {
        private static final float MIN_USAGE_SCORE = 0.1f;
        private static final String PREF_ROUTE_IDS = "android.support.v7.app.MediaRouteChooserDialog_route_ids";
        private static final String PREF_USAGE_SCORE_PREFIX = "android.support.v7.app.MediaRouteChooserDialog_route_usage_score_";
        private static final float USAGE_SCORE_DECAY_FACTOR = 0.95f;
        public static final RouteComparator sInstance = new RouteComparator();
        public static final HashMap<String, Float> sRouteUsageScoreMap = new HashMap();

        private RouteComparator() {
        }

        public int compare(RouteInfo lhs, RouteInfo rhs) {
            if (lhs == null) {
                if (rhs == null) {
                    return 0;
                }
                return -1;
            } else if (rhs == null) {
                return 1;
            } else {
                if (lhs.isDeviceTypeBluetooth()) {
                    if (!rhs.isDeviceTypeBluetooth()) {
                        return 1;
                    }
                } else if (rhs.isDeviceTypeBluetooth()) {
                    return -1;
                }
                Float lhsUsageScore = (Float) sRouteUsageScoreMap.get(lhs.getId());
                if (lhsUsageScore == null) {
                    lhsUsageScore = Float.valueOf(0.0f);
                }
                Float rhsUsageScore = (Float) sRouteUsageScoreMap.get(rhs.getId());
                if (rhsUsageScore == null) {
                    rhsUsageScore = Float.valueOf(0.0f);
                }
                if (lhsUsageScore.equals(rhsUsageScore)) {
                    return lhs.getName().compareTo(rhs.getName());
                }
                if (lhsUsageScore.floatValue() <= rhsUsageScore.floatValue()) {
                    return 1;
                }
                return -1;
            }
        }

        private static void loadRouteUsageScores(Context context, List<RouteInfo> routes) {
            sRouteUsageScoreMap.clear();
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            for (RouteInfo route : routes) {
                sRouteUsageScoreMap.put(route.getId(), Float.valueOf(preferences.getFloat(PREF_USAGE_SCORE_PREFIX + route.getId(), 0.0f)));
            }
        }

        private static void storeRouteUsageScores(Context context, String selectedRouteId) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            Editor prefEditor = preferences.edit();
            List<String> routeIds = new ArrayList(Arrays.asList(preferences.getString(PREF_ROUTE_IDS, "").split(",")));
            if (!routeIds.contains(selectedRouteId)) {
                routeIds.add(selectedRouteId);
            }
            StringBuilder routeIdsBuilder = new StringBuilder();
            for (String routeId : routeIds) {
                String routeUsageScoreKey = PREF_USAGE_SCORE_PREFIX + routeId;
                float newUsageScore = preferences.getFloat(routeUsageScoreKey, 0.0f) * USAGE_SCORE_DECAY_FACTOR;
                if (selectedRouteId.equals(routeId)) {
                    newUsageScore += 1.0f;
                }
                if (newUsageScore < MIN_USAGE_SCORE) {
                    prefEditor.remove(routeId);
                } else {
                    prefEditor.putFloat(routeUsageScoreKey, newUsageScore);
                    if (routeIdsBuilder.length() > 0) {
                        routeIdsBuilder.append(',');
                    }
                    routeIdsBuilder.append(routeId);
                }
            }
            prefEditor.putString(PREF_ROUTE_IDS, routeIdsBuilder.toString());
            prefEditor.commit();
        }
    }

    public MediaRouteChooserDialog(Context context) {
        this(context, 0);
    }

    public MediaRouteChooserDialog(Context context, int theme) {
        super(MediaRouterThemeHelper.createThemedContext(context, theme), theme);
        this.mSelector = MediaRouteSelector.EMPTY;
        this.mRouter = MediaRouter.getInstance(getContext());
        this.mCallback = new MediaRouterCallback();
    }

    @NonNull
    public MediaRouteSelector getRouteSelector() {
        return this.mSelector;
    }

    public void setRouteSelector(@NonNull MediaRouteSelector selector) {
        if (selector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.mSelector.equals(selector)) {
            this.mSelector = selector;
            if (this.mAttachedToWindow) {
                this.mRouter.removeCallback(this.mCallback);
                this.mRouter.addCallback(selector, this.mCallback, 1);
            }
            refreshRoutes();
        }
    }

    public void onFilterRoutes(@NonNull List<RouteInfo> routes) {
        int i = routes.size();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            if (onFilterRoute((RouteInfo) routes.get(i2))) {
                i = i2;
            } else {
                routes.remove(i2);
                i = i2;
            }
        }
    }

    public boolean onFilterRoute(@NonNull RouteInfo route) {
        return !route.isDefault() && route.isEnabled() && route.matchesSelector(this.mSelector);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0280R.layout.mr_chooser_dialog);
        setTitle(C0280R.string.mr_chooser_title);
        this.mRoutes = new ArrayList();
        this.mAdapter = new RouteAdapter(getContext(), this.mRoutes);
        this.mListView = (ListView) findViewById(C0280R.id.mr_chooser_list);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this.mAdapter);
        this.mListView.setEmptyView(findViewById(16908292));
        updateLayout();
    }

    void updateLayout() {
        getWindow().setLayout(MediaRouteDialogHelper.getDialogWidth(getContext()), -2);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.addCallback(this.mSelector, this.mCallback, 1);
        refreshRoutes();
    }

    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        this.mRouter.removeCallback(this.mCallback);
        super.onDetachedFromWindow();
    }

    public void refreshRoutes() {
        if (this.mAttachedToWindow) {
            if (this.mRefreshRoutesTask != null) {
                this.mRefreshRoutesTask.cancel(true);
                this.mRefreshRoutesTask = null;
            }
            this.mRefreshRoutesTask = new C02381().execute(new Void[0]);
        }
    }
}
