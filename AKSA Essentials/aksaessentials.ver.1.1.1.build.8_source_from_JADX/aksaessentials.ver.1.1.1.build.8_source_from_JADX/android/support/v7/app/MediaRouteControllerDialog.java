package android.support.v7.app;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompat.Callback;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.OverlayListView.OverlayObject;
import android.support.v7.app.OverlayListView.OverlayObject.OnAnimationEndListener;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.Builder;
import android.support.v7.graphics.Palette.Swatch;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.RouteGroup;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.mediarouter.C0280R;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MediaRouteControllerDialog extends AlertDialog {
    private static final int BUTTON_DISCONNECT_RES_ID = 16908314;
    private static final int BUTTON_NEUTRAL_RES_ID = 16908315;
    private static final int BUTTON_STOP_RES_ID = 16908313;
    private static final int CONNECTION_TIMEOUT_MILLIS = ((int) TimeUnit.SECONDS.toMillis(30));
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final String TAG = "MediaRouteCtrlDialog";
    private static final int VOLUME_UPDATE_DELAY_MILLIS = 500;
    private Interpolator mAccelerateDecelerateInterpolator;
    private final AccessibilityManager mAccessibilityManager;
    private Bitmap mArtIconBitmap;
    private Uri mArtIconUri;
    private ImageView mArtView;
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private ImageButton mCloseButton;
    private Context mContext;
    private MediaControllerCallback mControllerCallback;
    private boolean mCreated;
    private FrameLayout mCustomControlLayout;
    private View mCustomControlView;
    private FrameLayout mDefaultControlLayout;
    private MediaDescriptionCompat mDescription;
    private LinearLayout mDialogAreaLayout;
    private int mDialogContentWidth;
    private Button mDisconnectButton;
    private View mDividerView;
    private FrameLayout mExpandableAreaLayout;
    private Interpolator mFastOutSlowInInterpolator;
    private FetchArtTask mFetchArtTask;
    private MediaRouteExpandCollapseButton mGroupExpandCollapseButton;
    private int mGroupListAnimationDurationMs;
    private Runnable mGroupListFadeInAnimation;
    private int mGroupListFadeInDurationMs;
    private int mGroupListFadeOutDurationMs;
    private List<RouteInfo> mGroupMemberRoutes;
    private Set<RouteInfo> mGroupMemberRoutesAdded;
    private Set<RouteInfo> mGroupMemberRoutesAnimatingWithBitmap;
    private Set<RouteInfo> mGroupMemberRoutesRemoved;
    private Interpolator mInterpolator;
    private boolean mIsGroupExpanded;
    private boolean mIsGroupListAnimating;
    private boolean mIsGroupListAnimationPending;
    private Interpolator mLinearOutSlowInInterpolator;
    private MediaControllerCompat mMediaController;
    private LinearLayout mMediaMainControlLayout;
    private ImageButton mPlayPauseButton;
    private RelativeLayout mPlaybackControlLayout;
    private final RouteInfo mRoute;
    private RouteInfo mRouteInVolumeSliderTouched;
    private TextView mRouteNameTextView;
    private final MediaRouter mRouter;
    private PlaybackStateCompat mState;
    private Button mStopCastingButton;
    private TextView mSubtitleView;
    private TextView mTitleView;
    private VolumeChangeListener mVolumeChangeListener;
    private boolean mVolumeControlEnabled;
    private LinearLayout mVolumeControlLayout;
    private VolumeGroupAdapter mVolumeGroupAdapter;
    private OverlayListView mVolumeGroupList;
    private int mVolumeGroupListItemHeight;
    private int mVolumeGroupListItemIconSize;
    private int mVolumeGroupListMaxHeight;
    private final int mVolumeGroupListPaddingTop;
    private SeekBar mVolumeSlider;
    private Map<RouteInfo, SeekBar> mVolumeSliderMap;

    class C02401 implements Runnable {
        C02401() {
        }

        public void run() {
            MediaRouteControllerDialog.this.startGroupListFadeInAnimation();
        }
    }

    class C02412 implements OnClickListener {
        C02412() {
        }

        public void onClick(View v) {
            MediaRouteControllerDialog.this.dismiss();
        }
    }

    class C02423 implements OnClickListener {
        C02423() {
        }

        public void onClick(View v) {
        }
    }

    class C02434 implements OnClickListener {
        C02434() {
        }

        public void onClick(View v) {
            if (MediaRouteControllerDialog.this.mMediaController != null) {
                PendingIntent pi = MediaRouteControllerDialog.this.mMediaController.getSessionActivity();
                if (pi != null) {
                    try {
                        pi.send();
                        MediaRouteControllerDialog.this.dismiss();
                    } catch (CanceledException e) {
                        Log.e(MediaRouteControllerDialog.TAG, pi + " was not sent, it had been canceled.");
                    }
                }
            }
        }
    }

    class C02445 implements OnClickListener {
        C02445() {
        }

        public void onClick(View v) {
            MediaRouteControllerDialog.this.mIsGroupExpanded = !MediaRouteControllerDialog.this.mIsGroupExpanded;
            if (MediaRouteControllerDialog.this.mIsGroupExpanded) {
                MediaRouteControllerDialog.this.mVolumeGroupList.setVisibility(0);
            }
            MediaRouteControllerDialog.this.loadInterpolator();
            MediaRouteControllerDialog.this.updateLayoutHeight(true);
        }
    }

    class C02489 implements AnimationListener {
        C02489() {
        }

        public void onAnimationStart(Animation animation) {
            MediaRouteControllerDialog.this.mVolumeGroupList.startAnimationAll();
            MediaRouteControllerDialog.this.mVolumeGroupList.postDelayed(MediaRouteControllerDialog.this.mGroupListFadeInAnimation, (long) MediaRouteControllerDialog.this.mGroupListAnimationDurationMs);
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    private final class ClickListener implements OnClickListener {
        private ClickListener() {
        }

        public void onClick(View v) {
            int i = 1;
            int id = v.getId();
            if (id == MediaRouteControllerDialog.BUTTON_STOP_RES_ID || id == MediaRouteControllerDialog.BUTTON_DISCONNECT_RES_ID) {
                if (MediaRouteControllerDialog.this.mRoute.isSelected()) {
                    MediaRouter access$3000 = MediaRouteControllerDialog.this.mRouter;
                    if (id == MediaRouteControllerDialog.BUTTON_STOP_RES_ID) {
                        i = 2;
                    }
                    access$3000.unselect(i);
                }
                MediaRouteControllerDialog.this.dismiss();
            } else if (id == C0280R.id.mr_control_play_pause) {
                if (MediaRouteControllerDialog.this.mMediaController != null && MediaRouteControllerDialog.this.mState != null) {
                    boolean isPlaying = MediaRouteControllerDialog.this.mState.getState() == 3;
                    if (isPlaying) {
                        MediaRouteControllerDialog.this.mMediaController.getTransportControls().pause();
                    } else {
                        MediaRouteControllerDialog.this.mMediaController.getTransportControls().play();
                    }
                    if (MediaRouteControllerDialog.this.mAccessibilityManager != null && MediaRouteControllerDialog.this.mAccessibilityManager.isEnabled()) {
                        AccessibilityEvent event = AccessibilityEvent.obtain(16384);
                        event.setPackageName(MediaRouteControllerDialog.this.mContext.getPackageName());
                        event.setClassName(getClass().getName());
                        event.getText().add(MediaRouteControllerDialog.this.mContext.getString(isPlaying ? C0280R.string.mr_controller_pause : C0280R.string.mr_controller_play));
                        MediaRouteControllerDialog.this.mAccessibilityManager.sendAccessibilityEvent(event);
                    }
                }
            } else if (id == C0280R.id.mr_close) {
                MediaRouteControllerDialog.this.dismiss();
            }
        }
    }

    private class FetchArtTask extends AsyncTask<Void, Void, Bitmap> {
        int mBackgroundColor;
        final Bitmap mIconBitmap;
        final Uri mIconUri;
        final /* synthetic */ MediaRouteControllerDialog this$0;

        FetchArtTask(MediaRouteControllerDialog mediaRouteControllerDialog) {
            Uri uri = null;
            this.this$0 = mediaRouteControllerDialog;
            this.mIconBitmap = mediaRouteControllerDialog.mDescription == null ? null : mediaRouteControllerDialog.mDescription.getIconBitmap();
            if (mediaRouteControllerDialog.mDescription != null) {
                uri = mediaRouteControllerDialog.mDescription.getIconUri();
            }
            this.mIconUri = uri;
        }

        protected void onPreExecute() {
            if (!isIconChanged()) {
                cancel(true);
            }
        }

        protected Bitmap doInBackground(Void... arg) {
            int i = 0;
            Bitmap art = null;
            if (this.mIconBitmap != null) {
                art = this.mIconBitmap;
            } else if (this.mIconUri != null) {
                InputStream stream = null;
                try {
                    stream = openInputStreamByScheme(this.mIconUri);
                    if (stream == null) {
                        Log.w(MediaRouteControllerDialog.TAG, "Unable to open: " + this.mIconUri);
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (IOException e) {
                            }
                        }
                        return null;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(stream, null, options);
                    if (options.outWidth == 0 || options.outHeight == 0) {
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (IOException e2) {
                            }
                        }
                        return null;
                    }
                    try {
                        stream.reset();
                    } catch (IOException e3) {
                        stream.close();
                        stream = openInputStreamByScheme(this.mIconUri);
                        if (stream == null) {
                            Log.w(MediaRouteControllerDialog.TAG, "Unable to open: " + this.mIconUri);
                            if (stream != null) {
                                try {
                                    stream.close();
                                } catch (IOException e4) {
                                }
                            }
                            return null;
                        }
                    }
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = Math.max(1, Integer.highestOneBit(options.outHeight / this.this$0.getDesiredArtHeight(options.outWidth, options.outHeight)));
                    if (isCancelled()) {
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (IOException e5) {
                            }
                        }
                        return null;
                    }
                    art = BitmapFactory.decodeStream(stream, null, options);
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (IOException e7) {
                    Log.w(MediaRouteControllerDialog.TAG, "Unable to open: " + this.mIconUri, e7);
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (IOException e8) {
                        }
                    }
                } catch (Throwable th) {
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (IOException e9) {
                        }
                    }
                }
            }
            if (art != null && art.getWidth() < art.getHeight()) {
                Palette palette = new Builder(art).maximumColorCount(1).generate();
                if (!palette.getSwatches().isEmpty()) {
                    i = ((Swatch) palette.getSwatches().get(0)).getRgb();
                }
                this.mBackgroundColor = i;
            }
            return art;
        }

        protected void onCancelled() {
            this.this$0.mFetchArtTask = null;
        }

        protected void onPostExecute(Bitmap art) {
            this.this$0.mFetchArtTask = null;
            if (this.this$0.mArtIconBitmap != this.mIconBitmap || this.this$0.mArtIconUri != this.mIconUri) {
                this.this$0.mArtIconBitmap = this.mIconBitmap;
                this.this$0.mArtIconUri = this.mIconUri;
                this.this$0.mArtView.setImageBitmap(art);
                this.this$0.mArtView.setBackgroundColor(this.mBackgroundColor);
                this.this$0.updateLayoutHeight(true);
            }
        }

        private boolean isIconChanged() {
            if (this.mIconBitmap != this.this$0.mArtIconBitmap) {
                return true;
            }
            if (this.mIconBitmap != null || MediaRouteControllerDialog.uriEquals(this.mIconUri, this.this$0.mArtIconUri)) {
                return false;
            }
            return true;
        }

        private InputStream openInputStreamByScheme(Uri uri) throws IOException {
            InputStream stream;
            String scheme = uri.getScheme().toLowerCase();
            if ("android.resource".equals(scheme) || "content".equals(scheme) || "file".equals(scheme)) {
                stream = this.this$0.mContext.getContentResolver().openInputStream(uri);
            } else {
                URLConnection conn = new URL(uri.toString()).openConnection();
                conn.setConnectTimeout(MediaRouteControllerDialog.CONNECTION_TIMEOUT_MILLIS);
                conn.setReadTimeout(MediaRouteControllerDialog.CONNECTION_TIMEOUT_MILLIS);
                stream = conn.getInputStream();
            }
            if (stream == null) {
                return null;
            }
            return new BufferedInputStream(stream);
        }
    }

    private final class MediaControllerCallback extends Callback {
        private MediaControllerCallback() {
        }

        public void onSessionDestroyed() {
            if (MediaRouteControllerDialog.this.mMediaController != null) {
                MediaRouteControllerDialog.this.mMediaController.unregisterCallback(MediaRouteControllerDialog.this.mControllerCallback);
                MediaRouteControllerDialog.this.mMediaController = null;
            }
        }

        public void onPlaybackStateChanged(PlaybackStateCompat state) {
            MediaRouteControllerDialog.this.mState = state;
            MediaRouteControllerDialog.this.update(false);
        }

        public void onMetadataChanged(MediaMetadataCompat metadata) {
            MediaRouteControllerDialog.this.mDescription = metadata == null ? null : metadata.getDescription();
            MediaRouteControllerDialog.this.update(false);
        }
    }

    private final class MediaRouterCallback extends MediaRouter.Callback {
        private MediaRouterCallback() {
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo route) {
            MediaRouteControllerDialog.this.update(false);
        }

        public void onRouteChanged(MediaRouter router, RouteInfo route) {
            MediaRouteControllerDialog.this.update(true);
        }

        public void onRouteVolumeChanged(MediaRouter router, RouteInfo route) {
            SeekBar volumeSlider = (SeekBar) MediaRouteControllerDialog.this.mVolumeSliderMap.get(route);
            int volume = route.getVolume();
            if (MediaRouteControllerDialog.DEBUG) {
                Log.d(MediaRouteControllerDialog.TAG, "onRouteVolumeChanged(), route.getVolume:" + volume);
            }
            if (volumeSlider != null && MediaRouteControllerDialog.this.mRouteInVolumeSliderTouched != route) {
                volumeSlider.setProgress(volume);
            }
        }
    }

    private class VolumeChangeListener implements OnSeekBarChangeListener {
        private final Runnable mStopTrackingTouch;

        class C02491 implements Runnable {
            C02491() {
            }

            public void run() {
                if (MediaRouteControllerDialog.this.mRouteInVolumeSliderTouched != null) {
                    MediaRouteControllerDialog.this.mRouteInVolumeSliderTouched = null;
                }
            }
        }

        private VolumeChangeListener() {
            this.mStopTrackingTouch = new C02491();
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (MediaRouteControllerDialog.this.mRouteInVolumeSliderTouched != null) {
                MediaRouteControllerDialog.this.mVolumeSlider.removeCallbacks(this.mStopTrackingTouch);
            }
            MediaRouteControllerDialog.this.mRouteInVolumeSliderTouched = (RouteInfo) seekBar.getTag();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            MediaRouteControllerDialog.this.mVolumeSlider.postDelayed(this.mStopTrackingTouch, 500);
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                RouteInfo route = (RouteInfo) seekBar.getTag();
                if (MediaRouteControllerDialog.DEBUG) {
                    Log.d(MediaRouteControllerDialog.TAG, "onProgressChanged(): calling MediaRouter.RouteInfo.requestSetVolume(" + progress + ")");
                }
                route.requestSetVolume(progress);
            }
        }
    }

    private class VolumeGroupAdapter extends ArrayAdapter<RouteInfo> {
        final float mDisabledAlpha;

        public VolumeGroupAdapter(Context context, List<RouteInfo> objects) {
            super(context, 0, objects);
            this.mDisabledAlpha = MediaRouterThemeHelper.getDisabledAlpha(context);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                v = LayoutInflater.from(MediaRouteControllerDialog.this.mContext).inflate(C0280R.layout.mr_controller_volume_item, parent, false);
            } else {
                MediaRouteControllerDialog.this.updateVolumeGroupItemHeight(v);
            }
            RouteInfo route = (RouteInfo) getItem(position);
            if (route != null) {
                boolean isEnabled = route.isEnabled();
                TextView routeName = (TextView) v.findViewById(C0280R.id.mr_name);
                routeName.setEnabled(isEnabled);
                routeName.setText(route.getName());
                MediaRouteVolumeSlider volumeSlider = (MediaRouteVolumeSlider) v.findViewById(C0280R.id.mr_volume_slider);
                MediaRouterThemeHelper.setVolumeSliderColor(MediaRouteControllerDialog.this.mContext, volumeSlider, MediaRouteControllerDialog.this.mVolumeGroupList);
                volumeSlider.setTag(route);
                MediaRouteControllerDialog.this.mVolumeSliderMap.put(route, volumeSlider);
                volumeSlider.setHideThumb(!isEnabled);
                volumeSlider.setEnabled(isEnabled);
                if (isEnabled) {
                    if (MediaRouteControllerDialog.this.isVolumeControlAvailable(route)) {
                        volumeSlider.setMax(route.getVolumeMax());
                        volumeSlider.setProgress(route.getVolume());
                        volumeSlider.setOnSeekBarChangeListener(MediaRouteControllerDialog.this.mVolumeChangeListener);
                    } else {
                        volumeSlider.setMax(100);
                        volumeSlider.setProgress(100);
                        volumeSlider.setEnabled(false);
                    }
                }
                ((ImageView) v.findViewById(C0280R.id.mr_volume_item_icon)).setAlpha(isEnabled ? 255 : (int) (255.0f * this.mDisabledAlpha));
                ((LinearLayout) v.findViewById(C0280R.id.volume_item_container)).setVisibility(MediaRouteControllerDialog.this.mGroupMemberRoutesAnimatingWithBitmap.contains(route) ? 4 : 0);
                if (MediaRouteControllerDialog.this.mGroupMemberRoutesAdded != null && MediaRouteControllerDialog.this.mGroupMemberRoutesAdded.contains(route)) {
                    Animation alphaAnim = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnim.setDuration(0);
                    alphaAnim.setFillEnabled(true);
                    alphaAnim.setFillAfter(true);
                    v.clearAnimation();
                    v.startAnimation(alphaAnim);
                }
            }
            return v;
        }
    }

    public MediaRouteControllerDialog(Context context) {
        this(context, 0);
    }

    public MediaRouteControllerDialog(Context context, int theme) {
        super(MediaRouterThemeHelper.createThemedContext(context, theme), theme);
        this.mVolumeControlEnabled = true;
        this.mGroupListFadeInAnimation = new C02401();
        this.mContext = getContext();
        this.mControllerCallback = new MediaControllerCallback();
        this.mRouter = MediaRouter.getInstance(this.mContext);
        this.mCallback = new MediaRouterCallback();
        this.mRoute = this.mRouter.getSelectedRoute();
        setMediaSession(this.mRouter.getMediaSessionToken());
        this.mVolumeGroupListPaddingTop = this.mContext.getResources().getDimensionPixelSize(C0280R.dimen.mr_controller_volume_group_list_padding_top);
        this.mAccessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        if (VERSION.SDK_INT >= 21) {
            this.mLinearOutSlowInInterpolator = AnimationUtils.loadInterpolator(context, C0280R.interpolator.mr_linear_out_slow_in);
            this.mFastOutSlowInInterpolator = AnimationUtils.loadInterpolator(context, C0280R.interpolator.mr_fast_out_slow_in);
        }
        this.mAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    }

    public RouteInfo getRoute() {
        return this.mRoute;
    }

    private RouteGroup getGroup() {
        if (this.mRoute instanceof RouteGroup) {
            return (RouteGroup) this.mRoute;
        }
        return null;
    }

    public View onCreateMediaControlView(Bundle savedInstanceState) {
        return null;
    }

    public View getMediaControlView() {
        return this.mCustomControlView;
    }

    public void setVolumeControlEnabled(boolean enable) {
        if (this.mVolumeControlEnabled != enable) {
            this.mVolumeControlEnabled = enable;
            if (this.mCreated) {
                updateVolumeControlLayout();
                updateLayoutHeight(false);
            }
        }
    }

    public boolean isVolumeControlEnabled() {
        return this.mVolumeControlEnabled;
    }

    private void setMediaSession(Token sessionToken) {
        PlaybackStateCompat playbackStateCompat = null;
        if (this.mMediaController != null) {
            this.mMediaController.unregisterCallback(this.mControllerCallback);
            this.mMediaController = null;
        }
        if (sessionToken != null && this.mAttachedToWindow) {
            try {
                this.mMediaController = new MediaControllerCompat(this.mContext, sessionToken);
            } catch (RemoteException e) {
                Log.e(TAG, "Error creating media controller in setMediaSession.", e);
            }
            if (this.mMediaController != null) {
                this.mMediaController.registerCallback(this.mControllerCallback);
            }
            MediaMetadataCompat metadata = this.mMediaController == null ? null : this.mMediaController.getMetadata();
            this.mDescription = metadata == null ? null : metadata.getDescription();
            if (this.mMediaController != null) {
                playbackStateCompat = this.mMediaController.getPlaybackState();
            }
            this.mState = playbackStateCompat;
            update(false);
        }
    }

    public Token getMediaSession() {
        return this.mMediaController == null ? null : this.mMediaController.getSessionToken();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(17170445);
        setContentView(C0280R.layout.mr_controller_material_dialog_b);
        findViewById(BUTTON_NEUTRAL_RES_ID).setVisibility(8);
        ClickListener listener = new ClickListener();
        this.mExpandableAreaLayout = (FrameLayout) findViewById(C0280R.id.mr_expandable_area);
        this.mExpandableAreaLayout.setOnClickListener(new C02412());
        this.mDialogAreaLayout = (LinearLayout) findViewById(C0280R.id.mr_dialog_area);
        this.mDialogAreaLayout.setOnClickListener(new C02423());
        int color = MediaRouterThemeHelper.getButtonTextColor(this.mContext);
        this.mDisconnectButton = (Button) findViewById(BUTTON_DISCONNECT_RES_ID);
        this.mDisconnectButton.setText(C0280R.string.mr_controller_disconnect);
        this.mDisconnectButton.setTextColor(color);
        this.mDisconnectButton.setOnClickListener(listener);
        this.mStopCastingButton = (Button) findViewById(BUTTON_STOP_RES_ID);
        this.mStopCastingButton.setText(C0280R.string.mr_controller_stop);
        this.mStopCastingButton.setTextColor(color);
        this.mStopCastingButton.setOnClickListener(listener);
        this.mRouteNameTextView = (TextView) findViewById(C0280R.id.mr_name);
        this.mCloseButton = (ImageButton) findViewById(C0280R.id.mr_close);
        this.mCloseButton.setOnClickListener(listener);
        this.mCustomControlLayout = (FrameLayout) findViewById(C0280R.id.mr_custom_control);
        this.mDefaultControlLayout = (FrameLayout) findViewById(C0280R.id.mr_default_control);
        OnClickListener onClickListener = new C02434();
        this.mArtView = (ImageView) findViewById(C0280R.id.mr_art);
        this.mArtView.setOnClickListener(onClickListener);
        findViewById(C0280R.id.mr_control_title_container).setOnClickListener(onClickListener);
        this.mMediaMainControlLayout = (LinearLayout) findViewById(C0280R.id.mr_media_main_control);
        this.mDividerView = findViewById(C0280R.id.mr_control_divider);
        this.mPlaybackControlLayout = (RelativeLayout) findViewById(C0280R.id.mr_playback_control);
        this.mTitleView = (TextView) findViewById(C0280R.id.mr_control_title);
        this.mSubtitleView = (TextView) findViewById(C0280R.id.mr_control_subtitle);
        this.mPlayPauseButton = (ImageButton) findViewById(C0280R.id.mr_control_play_pause);
        this.mPlayPauseButton.setOnClickListener(listener);
        this.mVolumeControlLayout = (LinearLayout) findViewById(C0280R.id.mr_volume_control);
        this.mVolumeControlLayout.setVisibility(8);
        this.mVolumeSlider = (SeekBar) findViewById(C0280R.id.mr_volume_slider);
        this.mVolumeSlider.setTag(this.mRoute);
        this.mVolumeChangeListener = new VolumeChangeListener();
        this.mVolumeSlider.setOnSeekBarChangeListener(this.mVolumeChangeListener);
        this.mVolumeGroupList = (OverlayListView) findViewById(C0280R.id.mr_volume_group_list);
        this.mGroupMemberRoutes = new ArrayList();
        this.mVolumeGroupAdapter = new VolumeGroupAdapter(this.mContext, this.mGroupMemberRoutes);
        this.mVolumeGroupList.setAdapter(this.mVolumeGroupAdapter);
        this.mGroupMemberRoutesAnimatingWithBitmap = new HashSet();
        MediaRouterThemeHelper.setMediaControlsBackgroundColor(this.mContext, this.mMediaMainControlLayout, this.mVolumeGroupList, getGroup() != null);
        MediaRouterThemeHelper.setVolumeSliderColor(this.mContext, (MediaRouteVolumeSlider) this.mVolumeSlider, this.mMediaMainControlLayout);
        this.mVolumeSliderMap = new HashMap();
        this.mVolumeSliderMap.put(this.mRoute, this.mVolumeSlider);
        this.mGroupExpandCollapseButton = (MediaRouteExpandCollapseButton) findViewById(C0280R.id.mr_group_expand_collapse);
        this.mGroupExpandCollapseButton.setOnClickListener(new C02445());
        loadInterpolator();
        this.mGroupListAnimationDurationMs = this.mContext.getResources().getInteger(C0280R.integer.mr_controller_volume_group_list_animation_duration_ms);
        this.mGroupListFadeInDurationMs = this.mContext.getResources().getInteger(C0280R.integer.mr_controller_volume_group_list_fade_in_duration_ms);
        this.mGroupListFadeOutDurationMs = this.mContext.getResources().getInteger(C0280R.integer.mr_controller_volume_group_list_fade_out_duration_ms);
        this.mCustomControlView = onCreateMediaControlView(savedInstanceState);
        if (this.mCustomControlView != null) {
            this.mCustomControlLayout.addView(this.mCustomControlView);
            this.mCustomControlLayout.setVisibility(0);
        }
        this.mCreated = true;
        updateLayout();
    }

    void updateLayout() {
        int width = MediaRouteDialogHelper.getDialogWidth(this.mContext);
        getWindow().setLayout(width, -2);
        View decorView = getWindow().getDecorView();
        this.mDialogContentWidth = (width - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources res = this.mContext.getResources();
        this.mVolumeGroupListItemIconSize = res.getDimensionPixelSize(C0280R.dimen.mr_controller_volume_group_list_item_icon_size);
        this.mVolumeGroupListItemHeight = res.getDimensionPixelSize(C0280R.dimen.mr_controller_volume_group_list_item_height);
        this.mVolumeGroupListMaxHeight = res.getDimensionPixelSize(C0280R.dimen.mr_controller_volume_group_list_max_height);
        this.mArtIconBitmap = null;
        this.mArtIconUri = null;
        update(false);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.addCallback(MediaRouteSelector.EMPTY, this.mCallback, 2);
        setMediaSession(this.mRouter.getMediaSessionToken());
    }

    public void onDetachedFromWindow() {
        this.mRouter.removeCallback(this.mCallback);
        setMediaSession(null);
        this.mAttachedToWindow = false;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 25 && keyCode != 24) {
            return super.onKeyDown(keyCode, event);
        }
        int i;
        RouteInfo routeInfo = this.mRoute;
        if (keyCode == 25) {
            i = -1;
        } else {
            i = 1;
        }
        routeInfo.requestUpdateVolume(i);
        return true;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 25 || keyCode == 24) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    private void update(boolean animate) {
        if (!this.mRoute.isSelected() || this.mRoute.isDefault()) {
            dismiss();
        } else if (this.mCreated) {
            this.mRouteNameTextView.setText(this.mRoute.getName());
            this.mDisconnectButton.setVisibility(this.mRoute.canDisconnect() ? 0 : 8);
            if (this.mCustomControlView == null) {
                if (this.mFetchArtTask != null) {
                    this.mFetchArtTask.cancel(true);
                }
                this.mFetchArtTask = new FetchArtTask(this);
                this.mFetchArtTask.execute(new Void[0]);
            }
            updateVolumeControlLayout();
            updatePlaybackControlLayout();
            updateLayoutHeight(animate);
        }
    }

    private boolean canShowPlaybackControlLayout() {
        return this.mCustomControlView == null && !(this.mDescription == null && this.mState == null);
    }

    private int getMainControllerHeight(boolean showPlaybackControl) {
        if (!showPlaybackControl && this.mVolumeControlLayout.getVisibility() != 0) {
            return 0;
        }
        int height = 0 + (this.mMediaMainControlLayout.getPaddingTop() + this.mMediaMainControlLayout.getPaddingBottom());
        if (showPlaybackControl) {
            height += this.mPlaybackControlLayout.getMeasuredHeight();
        }
        if (this.mVolumeControlLayout.getVisibility() == 0) {
            height += this.mVolumeControlLayout.getMeasuredHeight();
        }
        if (showPlaybackControl && this.mVolumeControlLayout.getVisibility() == 0) {
            return height + this.mDividerView.getMeasuredHeight();
        }
        return height;
    }

    private void updateMediaControlVisibility(boolean canShowPlaybackControlLayout) {
        int i;
        int i2 = 8;
        View view = this.mDividerView;
        if (this.mVolumeControlLayout.getVisibility() == 0 && canShowPlaybackControlLayout) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        LinearLayout linearLayout = this.mMediaMainControlLayout;
        if (this.mVolumeControlLayout.getVisibility() != 8 || canShowPlaybackControlLayout) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
    }

    private void updateLayoutHeight(final boolean animate) {
        this.mDefaultControlLayout.requestLayout();
        this.mDefaultControlLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                MediaRouteControllerDialog.this.mDefaultControlLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (MediaRouteControllerDialog.this.mIsGroupListAnimating) {
                    MediaRouteControllerDialog.this.mIsGroupListAnimationPending = true;
                } else {
                    MediaRouteControllerDialog.this.updateLayoutHeightInternal(animate);
                }
            }
        });
    }

    private void updateLayoutHeightInternal(boolean animate) {
        int oldHeight = getLayoutHeight(this.mMediaMainControlLayout);
        setLayoutHeight(this.mMediaMainControlLayout, -1);
        updateMediaControlVisibility(canShowPlaybackControlLayout());
        View decorView = getWindow().getDecorView();
        decorView.measure(MeasureSpec.makeMeasureSpec(getWindow().getAttributes().width, 1073741824), 0);
        setLayoutHeight(this.mMediaMainControlLayout, oldHeight);
        int artViewHeight = 0;
        if (this.mCustomControlView == null && (this.mArtView.getDrawable() instanceof BitmapDrawable)) {
            Bitmap art = ((BitmapDrawable) this.mArtView.getDrawable()).getBitmap();
            if (art != null) {
                artViewHeight = getDesiredArtHeight(art.getWidth(), art.getHeight());
                this.mArtView.setScaleType(art.getWidth() >= art.getHeight() ? ScaleType.FIT_XY : ScaleType.FIT_CENTER);
            }
        }
        int mainControllerHeight = getMainControllerHeight(canShowPlaybackControlLayout());
        int volumeGroupListCount = this.mGroupMemberRoutes.size();
        int expandedGroupListHeight = getGroup() == null ? 0 : this.mVolumeGroupListItemHeight * getGroup().getRoutes().size();
        if (volumeGroupListCount > 0) {
            expandedGroupListHeight += this.mVolumeGroupListPaddingTop;
        }
        int visibleGroupListHeight = this.mIsGroupExpanded ? Math.min(expandedGroupListHeight, this.mVolumeGroupListMaxHeight) : 0;
        int desiredControlLayoutHeight = Math.max(artViewHeight, visibleGroupListHeight) + mainControllerHeight;
        Rect visibleRect = new Rect();
        decorView.getWindowVisibleDisplayFrame(visibleRect);
        int maximumControlViewHeight = visibleRect.height() - (this.mDialogAreaLayout.getMeasuredHeight() - this.mDefaultControlLayout.getMeasuredHeight());
        if (this.mCustomControlView != null || artViewHeight <= 0 || desiredControlLayoutHeight > maximumControlViewHeight) {
            if (getLayoutHeight(this.mVolumeGroupList) + this.mMediaMainControlLayout.getMeasuredHeight() >= this.mDefaultControlLayout.getMeasuredHeight()) {
                this.mArtView.setVisibility(8);
            }
            artViewHeight = 0;
            desiredControlLayoutHeight = visibleGroupListHeight + mainControllerHeight;
        } else {
            this.mArtView.setVisibility(0);
            setLayoutHeight(this.mArtView, artViewHeight);
        }
        if (!canShowPlaybackControlLayout() || desiredControlLayoutHeight > maximumControlViewHeight) {
            this.mPlaybackControlLayout.setVisibility(8);
        } else {
            this.mPlaybackControlLayout.setVisibility(0);
        }
        updateMediaControlVisibility(this.mPlaybackControlLayout.getVisibility() == 0);
        mainControllerHeight = getMainControllerHeight(this.mPlaybackControlLayout.getVisibility() == 0);
        desiredControlLayoutHeight = Math.max(artViewHeight, visibleGroupListHeight) + mainControllerHeight;
        if (desiredControlLayoutHeight > maximumControlViewHeight) {
            visibleGroupListHeight -= desiredControlLayoutHeight - maximumControlViewHeight;
            desiredControlLayoutHeight = maximumControlViewHeight;
        }
        this.mMediaMainControlLayout.clearAnimation();
        this.mVolumeGroupList.clearAnimation();
        this.mDefaultControlLayout.clearAnimation();
        if (animate) {
            animateLayoutHeight(this.mMediaMainControlLayout, mainControllerHeight);
            animateLayoutHeight(this.mVolumeGroupList, visibleGroupListHeight);
            animateLayoutHeight(this.mDefaultControlLayout, desiredControlLayoutHeight);
        } else {
            setLayoutHeight(this.mMediaMainControlLayout, mainControllerHeight);
            setLayoutHeight(this.mVolumeGroupList, visibleGroupListHeight);
            setLayoutHeight(this.mDefaultControlLayout, desiredControlLayoutHeight);
        }
        setLayoutHeight(this.mExpandableAreaLayout, visibleRect.height());
        rebuildVolumeGroupList(animate);
    }

    private void updateVolumeGroupItemHeight(View item) {
        setLayoutHeight((LinearLayout) item.findViewById(C0280R.id.volume_item_container), this.mVolumeGroupListItemHeight);
        View icon = item.findViewById(C0280R.id.mr_volume_item_icon);
        LayoutParams lp = icon.getLayoutParams();
        lp.width = this.mVolumeGroupListItemIconSize;
        lp.height = this.mVolumeGroupListItemIconSize;
        icon.setLayoutParams(lp);
    }

    private void animateLayoutHeight(final View view, int targetHeight) {
        final int startValue = getLayoutHeight(view);
        final int endValue = targetHeight;
        Animation anim = new Animation() {
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                MediaRouteControllerDialog.setLayoutHeight(view, startValue - ((int) (((float) (startValue - endValue)) * interpolatedTime)));
            }
        };
        anim.setDuration((long) this.mGroupListAnimationDurationMs);
        if (VERSION.SDK_INT >= 21) {
            anim.setInterpolator(this.mInterpolator);
        }
        view.startAnimation(anim);
    }

    private void loadInterpolator() {
        if (VERSION.SDK_INT >= 21) {
            this.mInterpolator = this.mIsGroupExpanded ? this.mLinearOutSlowInInterpolator : this.mFastOutSlowInInterpolator;
        } else {
            this.mInterpolator = this.mAccelerateDecelerateInterpolator;
        }
    }

    private void updateVolumeControlLayout() {
        int i = 8;
        if (!isVolumeControlAvailable(this.mRoute)) {
            this.mVolumeControlLayout.setVisibility(8);
        } else if (this.mVolumeControlLayout.getVisibility() == 8) {
            this.mVolumeControlLayout.setVisibility(0);
            this.mVolumeSlider.setMax(this.mRoute.getVolumeMax());
            this.mVolumeSlider.setProgress(this.mRoute.getVolume());
            MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = this.mGroupExpandCollapseButton;
            if (getGroup() != null) {
                i = 0;
            }
            mediaRouteExpandCollapseButton.setVisibility(i);
        }
    }

    private void rebuildVolumeGroupList(boolean animate) {
        List<RouteInfo> routes = getGroup() == null ? null : getGroup().getRoutes();
        if (routes == null) {
            this.mGroupMemberRoutes.clear();
            this.mVolumeGroupAdapter.notifyDataSetChanged();
        } else if (MediaRouteDialogHelper.listUnorderedEquals(this.mGroupMemberRoutes, routes)) {
            this.mVolumeGroupAdapter.notifyDataSetChanged();
        } else {
            HashMap<RouteInfo, Rect> previousRouteBoundMap;
            HashMap<RouteInfo, BitmapDrawable> previousRouteBitmapMap;
            if (animate) {
                previousRouteBoundMap = MediaRouteDialogHelper.getItemBoundMap(this.mVolumeGroupList, this.mVolumeGroupAdapter);
            } else {
                previousRouteBoundMap = null;
            }
            if (animate) {
                previousRouteBitmapMap = MediaRouteDialogHelper.getItemBitmapMap(this.mContext, this.mVolumeGroupList, this.mVolumeGroupAdapter);
            } else {
                previousRouteBitmapMap = null;
            }
            this.mGroupMemberRoutesAdded = MediaRouteDialogHelper.getItemsAdded(this.mGroupMemberRoutes, routes);
            this.mGroupMemberRoutesRemoved = MediaRouteDialogHelper.getItemsRemoved(this.mGroupMemberRoutes, routes);
            this.mGroupMemberRoutes.addAll(0, this.mGroupMemberRoutesAdded);
            this.mGroupMemberRoutes.removeAll(this.mGroupMemberRoutesRemoved);
            this.mVolumeGroupAdapter.notifyDataSetChanged();
            if (animate && this.mIsGroupExpanded && this.mGroupMemberRoutesAdded.size() + this.mGroupMemberRoutesRemoved.size() > 0) {
                animateGroupListItems(previousRouteBoundMap, previousRouteBitmapMap);
                return;
            }
            this.mGroupMemberRoutesAdded = null;
            this.mGroupMemberRoutesRemoved = null;
        }
    }

    private void animateGroupListItems(final Map<RouteInfo, Rect> previousRouteBoundMap, final Map<RouteInfo, BitmapDrawable> previousRouteBitmapMap) {
        this.mVolumeGroupList.setEnabled(false);
        this.mVolumeGroupList.requestLayout();
        this.mIsGroupListAnimating = true;
        this.mVolumeGroupList.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                MediaRouteControllerDialog.this.mVolumeGroupList.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                MediaRouteControllerDialog.this.animateGroupListItemsInternal(previousRouteBoundMap, previousRouteBitmapMap);
            }
        });
    }

    private void animateGroupListItemsInternal(Map<RouteInfo, Rect> previousRouteBoundMap, Map<RouteInfo, BitmapDrawable> previousRouteBitmapMap) {
        if (this.mGroupMemberRoutesAdded != null && this.mGroupMemberRoutesRemoved != null) {
            RouteInfo route;
            int groupSizeDelta = this.mGroupMemberRoutesAdded.size() - this.mGroupMemberRoutesRemoved.size();
            boolean listenerRegistered = false;
            AnimationListener c02489 = new C02489();
            int first = this.mVolumeGroupList.getFirstVisiblePosition();
            for (int i = 0; i < this.mVolumeGroupList.getChildCount(); i++) {
                int previousTop;
                View view = this.mVolumeGroupList.getChildAt(i);
                route = (RouteInfo) this.mVolumeGroupAdapter.getItem(first + i);
                Rect previousBounds = (Rect) previousRouteBoundMap.get(route);
                int currentTop = view.getTop();
                if (previousBounds != null) {
                    previousTop = previousBounds.top;
                } else {
                    previousTop = currentTop + (this.mVolumeGroupListItemHeight * groupSizeDelta);
                }
                AnimationSet animSet = new AnimationSet(true);
                if (this.mGroupMemberRoutesAdded != null && this.mGroupMemberRoutesAdded.contains(route)) {
                    previousTop = currentTop;
                    Animation alphaAnim = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnim.setDuration((long) this.mGroupListFadeInDurationMs);
                    animSet.addAnimation(alphaAnim);
                }
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (previousTop - currentTop), 0.0f);
                translateAnimation.setDuration((long) this.mGroupListAnimationDurationMs);
                animSet.addAnimation(translateAnimation);
                animSet.setFillAfter(true);
                animSet.setFillEnabled(true);
                animSet.setInterpolator(this.mInterpolator);
                if (!listenerRegistered) {
                    listenerRegistered = true;
                    animSet.setAnimationListener(c02489);
                }
                view.clearAnimation();
                view.startAnimation(animSet);
                previousRouteBoundMap.remove(route);
                previousRouteBitmapMap.remove(route);
            }
            for (Entry<RouteInfo, BitmapDrawable> item : previousRouteBitmapMap.entrySet()) {
                OverlayObject object;
                route = (RouteInfo) item.getKey();
                BitmapDrawable bitmap = (BitmapDrawable) item.getValue();
                Rect bounds = (Rect) previousRouteBoundMap.get(route);
                if (this.mGroupMemberRoutesRemoved.contains(route)) {
                    object = new OverlayObject(bitmap, bounds).setAlphaAnimation(1.0f, 0.0f).setDuration((long) this.mGroupListFadeOutDurationMs).setInterpolator(this.mInterpolator);
                } else {
                    final RouteInfo routeInfo = route;
                    object = new OverlayObject(bitmap, bounds).setTranslateYAnimation(groupSizeDelta * this.mVolumeGroupListItemHeight).setDuration((long) this.mGroupListAnimationDurationMs).setInterpolator(this.mInterpolator).setAnimationEndListener(new OnAnimationEndListener() {
                        public void onAnimationEnd() {
                            MediaRouteControllerDialog.this.mGroupMemberRoutesAnimatingWithBitmap.remove(routeInfo);
                            MediaRouteControllerDialog.this.mVolumeGroupAdapter.notifyDataSetChanged();
                        }
                    });
                    this.mGroupMemberRoutesAnimatingWithBitmap.add(route);
                }
                this.mVolumeGroupList.addOverlayObject(object);
            }
        }
    }

    private void startGroupListFadeInAnimation() {
        clearGroupListAnimation(true);
        this.mVolumeGroupList.requestLayout();
        this.mVolumeGroupList.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                MediaRouteControllerDialog.this.mVolumeGroupList.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                MediaRouteControllerDialog.this.startGroupListFadeInAnimationInternal();
            }
        });
    }

    private void startGroupListFadeInAnimationInternal() {
        if (this.mGroupMemberRoutesAdded == null || this.mGroupMemberRoutesAdded.size() == 0) {
            finishAnimation(true);
        } else {
            fadeInAddedRoutes();
        }
    }

    private void finishAnimation(boolean animate) {
        this.mGroupMemberRoutesAdded = null;
        this.mGroupMemberRoutesRemoved = null;
        this.mIsGroupListAnimating = false;
        if (this.mIsGroupListAnimationPending) {
            this.mIsGroupListAnimationPending = false;
            updateLayoutHeight(animate);
        }
        this.mVolumeGroupList.setEnabled(true);
    }

    private void fadeInAddedRoutes() {
        AnimationListener listener = new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                MediaRouteControllerDialog.this.finishAnimation(true);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        };
        boolean listenerRegistered = false;
        int first = this.mVolumeGroupList.getFirstVisiblePosition();
        for (int i = 0; i < this.mVolumeGroupList.getChildCount(); i++) {
            View view = this.mVolumeGroupList.getChildAt(i);
            if (this.mGroupMemberRoutesAdded.contains((RouteInfo) this.mVolumeGroupAdapter.getItem(first + i))) {
                Animation alphaAnim = new AlphaAnimation(0.0f, 1.0f);
                alphaAnim.setDuration((long) this.mGroupListFadeInDurationMs);
                alphaAnim.setFillEnabled(true);
                alphaAnim.setFillAfter(true);
                if (!listenerRegistered) {
                    listenerRegistered = true;
                    alphaAnim.setAnimationListener(listener);
                }
                view.clearAnimation();
                view.startAnimation(alphaAnim);
            }
        }
    }

    void clearGroupListAnimation(boolean exceptAddedRoutes) {
        int first = this.mVolumeGroupList.getFirstVisiblePosition();
        for (int i = 0; i < this.mVolumeGroupList.getChildCount(); i++) {
            View view = this.mVolumeGroupList.getChildAt(i);
            RouteInfo route = (RouteInfo) this.mVolumeGroupAdapter.getItem(first + i);
            if (!exceptAddedRoutes || this.mGroupMemberRoutesAdded == null || !this.mGroupMemberRoutesAdded.contains(route)) {
                ((LinearLayout) view.findViewById(C0280R.id.volume_item_container)).setVisibility(0);
                AnimationSet animSet = new AnimationSet(true);
                Animation alphaAnim = new AlphaAnimation(1.0f, 1.0f);
                alphaAnim.setDuration(0);
                animSet.addAnimation(alphaAnim);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0);
                animSet.setFillAfter(true);
                animSet.setFillEnabled(true);
                view.clearAnimation();
                view.startAnimation(animSet);
            }
        }
        this.mVolumeGroupList.stopAnimationAll();
        if (!exceptAddedRoutes) {
            finishAnimation(false);
        }
    }

    private void updatePlaybackControlLayout() {
        if (canShowPlaybackControlLayout()) {
            CharSequence title = this.mDescription == null ? null : this.mDescription.getTitle();
            boolean hasTitle = !TextUtils.isEmpty(title);
            CharSequence subtitle = this.mDescription == null ? null : this.mDescription.getSubtitle();
            boolean hasSubtitle = !TextUtils.isEmpty(subtitle);
            boolean showTitle = false;
            boolean showSubtitle = false;
            if (this.mRoute.getPresentationDisplayId() != -1) {
                this.mTitleView.setText(C0280R.string.mr_controller_casting_screen);
                showTitle = true;
            } else if (this.mState == null || this.mState.getState() == 0) {
                if (!this.mRoute.isDeviceTypeBluetooth()) {
                    this.mTitleView.setText(C0280R.string.mr_controller_no_media_selected);
                    showTitle = true;
                }
            } else if (hasTitle || hasSubtitle) {
                if (hasTitle) {
                    this.mTitleView.setText(title);
                    showTitle = true;
                }
                if (hasSubtitle) {
                    this.mSubtitleView.setText(subtitle);
                    showSubtitle = true;
                }
            } else {
                this.mTitleView.setText(C0280R.string.mr_controller_no_info_available);
                showTitle = true;
            }
            this.mTitleView.setVisibility(showTitle ? 0 : 8);
            this.mSubtitleView.setVisibility(showSubtitle ? 0 : 8);
            if (this.mState != null) {
                boolean isPlaying = this.mState.getState() == 6 || this.mState.getState() == 3;
                boolean supportsPlay = (this.mState.getActions() & 516) != 0;
                boolean supportsPause = (this.mState.getActions() & 514) != 0;
                if (isPlaying && supportsPause) {
                    this.mPlayPauseButton.setVisibility(0);
                    this.mPlayPauseButton.setImageResource(MediaRouterThemeHelper.getThemeResource(this.mContext, C0280R.attr.mediaRoutePauseDrawable));
                    this.mPlayPauseButton.setContentDescription(this.mContext.getResources().getText(C0280R.string.mr_controller_pause));
                } else if (isPlaying || !supportsPlay) {
                    this.mPlayPauseButton.setVisibility(8);
                } else {
                    this.mPlayPauseButton.setVisibility(0);
                    this.mPlayPauseButton.setImageResource(MediaRouterThemeHelper.getThemeResource(this.mContext, C0280R.attr.mediaRoutePlayDrawable));
                    this.mPlayPauseButton.setContentDescription(this.mContext.getResources().getText(C0280R.string.mr_controller_play));
                }
            }
        }
    }

    private boolean isVolumeControlAvailable(RouteInfo route) {
        return this.mVolumeControlEnabled && route.getVolumeHandling() == 1;
    }

    private static int getLayoutHeight(View view) {
        return view.getLayoutParams().height;
    }

    private static void setLayoutHeight(View view, int height) {
        LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
    }

    private static boolean uriEquals(Uri uri1, Uri uri2) {
        if (uri1 != null && uri1.equals(uri2)) {
            return true;
        }
        if (uri1 == null && uri2 == null) {
            return true;
        }
        return false;
    }

    private int getDesiredArtHeight(int originalWidth, int originalHeight) {
        if (originalWidth >= originalHeight) {
            return (int) (((((float) this.mDialogContentWidth) * ((float) originalHeight)) / ((float) originalWidth)) + 0.5f);
        }
        return (int) (((((float) this.mDialogContentWidth) * 9.0f) / 16.0f) + 0.5f);
    }
}
