package com.xamarin.forms.platform.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class FormsViewGroup extends ViewGroup {
    boolean inputTransparent;

    public FormsViewGroup(Context context) {
        super(context);
    }

    public FormsViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FormsViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void measureAndLayout(int widthMeasureSpec, int heightMeasureSpec, int l, int t, int r, int b) {
        measure(widthMeasureSpec, heightMeasureSpec);
        layout(l, t, r, b);
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    protected void setInputTransparent(boolean value) {
        this.inputTransparent = value;
    }

    protected boolean getInputTransparent() {
        return this.inputTransparent;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.inputTransparent) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (this.inputTransparent) {
            return false;
        }
        return super.onTouchEvent(ev);
    }

    public void sendBatchUpdate(float pivotX, float pivotY, int visibility, boolean enabled, float opacity, float rotation, float rotationX, float rotationY, float scale, float translationX, float translationY) {
        setPivotX(pivotX);
        setPivotY(pivotY);
        if (getVisibility() != visibility) {
            setVisibility(visibility);
        }
        if (isEnabled() != enabled) {
            setEnabled(enabled);
        }
        setAlpha(opacity);
        setRotation(rotation);
        setRotationX(rotationX);
        setRotationY(rotationY);
        setScaleX(scale);
        setScaleY(scale);
        setTranslationX(translationX);
        setTranslationY(translationY);
    }
}
