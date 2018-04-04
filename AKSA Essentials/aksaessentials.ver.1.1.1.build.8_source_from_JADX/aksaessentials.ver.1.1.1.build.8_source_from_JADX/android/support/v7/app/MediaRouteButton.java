package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.ProviderInfo;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.mediarouter.C0280R;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Toast;

public class MediaRouteButton extends View {
    private static final int[] CHECKABLE_STATE_SET = new int[]{16842911};
    private static final int[] CHECKED_STATE_SET = new int[]{16842912};
    private static final String CHOOSER_FRAGMENT_TAG = "android.support.v7.mediarouter:MediaRouteChooserDialogFragment";
    private static final String CONTROLLER_FRAGMENT_TAG = "android.support.v7.mediarouter:MediaRouteControllerDialogFragment";
    private static final String TAG = "MediaRouteButton";
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private boolean mCheatSheetEnabled;
    private MediaRouteDialogFactory mDialogFactory;
    private boolean mIsConnecting;
    private int mMinHeight;
    private int mMinWidth;
    private boolean mRemoteActive;
    private Drawable mRemoteIndicator;
    private final MediaRouter mRouter;
    private MediaRouteSelector mSelector;

    private final class MediaRouterCallback extends Callback {
        private MediaRouterCallback() {
        }

        public void onRouteAdded(MediaRouter router, RouteInfo info) {
            MediaRouteButton.this.refreshRoute();
        }

        public void onRouteRemoved(MediaRouter router, RouteInfo info) {
            MediaRouteButton.this.refreshRoute();
        }

        public void onRouteChanged(MediaRouter router, RouteInfo info) {
            MediaRouteButton.this.refreshRoute();
        }

        public void onRouteSelected(MediaRouter router, RouteInfo info) {
            MediaRouteButton.this.refreshRoute();
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo info) {
            MediaRouteButton.this.refreshRoute();
        }

        public void onProviderAdded(MediaRouter router, ProviderInfo provider) {
            MediaRouteButton.this.refreshRoute();
        }

        public void onProviderRemoved(MediaRouter router, ProviderInfo provider) {
            MediaRouteButton.this.refreshRoute();
        }

        public void onProviderChanged(MediaRouter router, ProviderInfo provider) {
            MediaRouteButton.this.refreshRoute();
        }
    }

    public MediaRouteButton(Context context) {
        this(context, null);
    }

    public MediaRouteButton(Context context, AttributeSet attrs) {
        this(context, attrs, C0280R.attr.mediaRouteButtonStyle);
    }

    public MediaRouteButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(MediaRouterThemeHelper.createThemedContext(context, defStyleAttr), attrs, defStyleAttr);
        this.mSelector = MediaRouteSelector.EMPTY;
        this.mDialogFactory = MediaRouteDialogFactory.getDefault();
        context = getContext();
        this.mRouter = MediaRouter.getInstance(context);
        this.mCallback = new MediaRouterCallback();
        TypedArray a = context.obtainStyledAttributes(attrs, C0280R.styleable.MediaRouteButton, defStyleAttr, 0);
        setRemoteIndicatorDrawable(a.getDrawable(C0280R.styleable.MediaRouteButton_externalRouteEnabledDrawable));
        this.mMinWidth = a.getDimensionPixelSize(C0280R.styleable.MediaRouteButton_android_minWidth, 0);
        this.mMinHeight = a.getDimensionPixelSize(C0280R.styleable.MediaRouteButton_android_minHeight, 0);
        a.recycle();
        setClickable(true);
        setLongClickable(true);
    }

    @NonNull
    public MediaRouteSelector getRouteSelector() {
        return this.mSelector;
    }

    public void setRouteSelector(MediaRouteSelector selector) {
        if (selector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.mSelector.equals(selector)) {
            if (this.mAttachedToWindow) {
                if (!this.mSelector.isEmpty()) {
                    this.mRouter.removeCallback(this.mCallback);
                }
                if (!selector.isEmpty()) {
                    this.mRouter.addCallback(selector, this.mCallback);
                }
            }
            this.mSelector = selector;
            refreshRoute();
        }
    }

    @NonNull
    public MediaRouteDialogFactory getDialogFactory() {
        return this.mDialogFactory;
    }

    public void setDialogFactory(@NonNull MediaRouteDialogFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.mDialogFactory = factory;
    }

    public boolean showDialog() {
        if (!this.mAttachedToWindow) {
            return false;
        }
        FragmentManager fm = getFragmentManager();
        if (fm == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        RouteInfo route = this.mRouter.getSelectedRoute();
        if (route.isDefault() || !route.matchesSelector(this.mSelector)) {
            if (fm.findFragmentByTag(CHOOSER_FRAGMENT_TAG) != null) {
                Log.w(TAG, "showDialog(): Route chooser dialog already showing!");
                return false;
            }
            MediaRouteChooserDialogFragment f = this.mDialogFactory.onCreateChooserDialogFragment();
            f.setRouteSelector(this.mSelector);
            f.show(fm, CHOOSER_FRAGMENT_TAG);
        } else if (fm.findFragmentByTag(CONTROLLER_FRAGMENT_TAG) != null) {
            Log.w(TAG, "showDialog(): Route controller dialog already showing!");
            return false;
        } else {
            this.mDialogFactory.onCreateControllerDialogFragment().show(fm, CONTROLLER_FRAGMENT_TAG);
        }
        return true;
    }

    private FragmentManager getFragmentManager() {
        Activity activity = getActivity();
        if (activity instanceof FragmentActivity) {
            return ((FragmentActivity) activity).getSupportFragmentManager();
        }
        return null;
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    void setCheatSheetEnabled(boolean enable) {
        this.mCheatSheetEnabled = enable;
    }

    public boolean performClick() {
        boolean handled = super.performClick();
        if (!handled) {
            playSoundEffect(0);
        }
        if (showDialog() || handled) {
            return true;
        }
        return false;
    }

    public boolean performLongClick() {
        if (super.performLongClick()) {
            return true;
        }
        if (!this.mCheatSheetEnabled) {
            return false;
        }
        CharSequence contentDesc = getContentDescription();
        if (TextUtils.isEmpty(contentDesc)) {
            return false;
        }
        int[] screenPos = new int[2];
        Rect displayFrame = new Rect();
        getLocationOnScreen(screenPos);
        getWindowVisibleDisplayFrame(displayFrame);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int midy = screenPos[1] + (height / 2);
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        Toast cheatSheet = Toast.makeText(context, contentDesc, 0);
        if (midy < displayFrame.height()) {
            cheatSheet.setGravity(8388661, (screenWidth - screenPos[0]) - (width / 2), height);
        } else {
            cheatSheet.setGravity(81, 0, height);
        }
        cheatSheet.show();
        performHapticFeedback(0);
        return true;
    }

    protected int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (this.mIsConnecting) {
            mergeDrawableStates(drawableState, CHECKABLE_STATE_SET);
        } else if (this.mRemoteActive) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mRemoteIndicator != null) {
            this.mRemoteIndicator.setState(getDrawableState());
            invalidate();
        }
    }

    public void setRemoteIndicatorDrawable(Drawable d) {
        if (this.mRemoteIndicator != null) {
            this.mRemoteIndicator.setCallback(null);
            unscheduleDrawable(this.mRemoteIndicator);
        }
        this.mRemoteIndicator = d;
        if (d != null) {
            boolean z;
            d.setCallback(this);
            d.setState(getDrawableState());
            if (getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            d.setVisible(z, false);
        }
        refreshDrawableState();
    }

    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.mRemoteIndicator;
    }

    public void jumpDrawablesToCurrentState() {
        if (getBackground() != null) {
            DrawableCompat.jumpToCurrentState(getBackground());
        }
        if (this.mRemoteIndicator != null) {
            DrawableCompat.jumpToCurrentState(this.mRemoteIndicator);
        }
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (this.mRemoteIndicator != null) {
            boolean z;
            Drawable drawable = this.mRemoteIndicator;
            if (getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            drawable.setVisible(z, false);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        if (!this.mSelector.isEmpty()) {
            this.mRouter.addCallback(this.mSelector, this.mCallback);
        }
        refreshRoute();
    }

    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        if (!this.mSelector.isEmpty()) {
            this.mRouter.removeCallback(this.mCallback);
        }
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int intrinsicWidth;
        int measuredWidth;
        int measuredHeight;
        int i = 0;
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int i2 = this.mMinWidth;
        if (this.mRemoteIndicator != null) {
            intrinsicWidth = (this.mRemoteIndicator.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight();
        } else {
            intrinsicWidth = 0;
        }
        int width = Math.max(i2, intrinsicWidth);
        intrinsicWidth = this.mMinHeight;
        if (this.mRemoteIndicator != null) {
            i = (this.mRemoteIndicator.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom();
        }
        int height = Math.max(intrinsicWidth, i);
        switch (widthMode) {
            case Integer.MIN_VALUE:
                measuredWidth = Math.min(widthSize, width);
                break;
            case 1073741824:
                measuredWidth = widthSize;
                break;
            default:
                measuredWidth = width;
                break;
        }
        switch (heightMode) {
            case Integer.MIN_VALUE:
                measuredHeight = Math.min(heightSize, height);
                break;
            case 1073741824:
                measuredHeight = heightSize;
                break;
            default:
                measuredHeight = height;
                break;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mRemoteIndicator != null) {
            int left = getPaddingLeft();
            int right = getWidth() - getPaddingRight();
            int top = getPaddingTop();
            int bottom = getHeight() - getPaddingBottom();
            int drawWidth = this.mRemoteIndicator.getIntrinsicWidth();
            int drawHeight = this.mRemoteIndicator.getIntrinsicHeight();
            int drawLeft = left + (((right - left) - drawWidth) / 2);
            int drawTop = top + (((bottom - top) - drawHeight) / 2);
            this.mRemoteIndicator.setBounds(drawLeft, drawTop, drawLeft + drawWidth, drawTop + drawHeight);
            this.mRemoteIndicator.draw(canvas);
        }
    }

    private void refreshRoute() {
        boolean isConnecting = false;
        if (this.mAttachedToWindow) {
            boolean isRemote;
            RouteInfo route = this.mRouter.getSelectedRoute();
            if (route.isDefault() || !route.matchesSelector(this.mSelector)) {
                isRemote = false;
            } else {
                isRemote = true;
            }
            if (isRemote && route.isConnecting()) {
                isConnecting = true;
            }
            boolean needsRefresh = false;
            if (this.mRemoteActive != isRemote) {
                this.mRemoteActive = isRemote;
                needsRefresh = true;
            }
            if (this.mIsConnecting != isConnecting) {
                this.mIsConnecting = isConnecting;
                needsRefresh = true;
            }
            if (needsRefresh) {
                refreshDrawableState();
                if (this.mIsConnecting && (this.mRemoteIndicator.getCurrent() instanceof AnimationDrawable)) {
                    AnimationDrawable curDrawable = (AnimationDrawable) this.mRemoteIndicator.getCurrent();
                    if (!curDrawable.isRunning()) {
                        curDrawable.start();
                    }
                }
            }
            setEnabled(this.mRouter.isRouteAvailable(this.mSelector, 1));
        }
    }
}
