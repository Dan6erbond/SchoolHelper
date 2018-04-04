package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ScrollViewRenderer extends ScrollView implements IGCUserPeer {
    public static final String __md_methods = "n_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\nn_onInterceptTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnInterceptTouchEvent_Landroid_view_MotionEvent_Handler\nn_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\nn_onAttachedToWindow:()V:GetOnAttachedToWindowHandler\nn_onDetachedFromWindow:()V:GetOnDetachedFromWindowHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onScrollChanged:(IIII)V:GetOnScrollChanged_IIIIHandler\n";
    private ArrayList refList;

    private native void n_draw(Canvas canvas);

    private native void n_onAttachedToWindow();

    private native void n_onDetachedFromWindow();

    private native boolean n_onInterceptTouchEvent(MotionEvent motionEvent);

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onScrollChanged(int i, int i2, int i3, int i4);

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.ScrollViewRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", ScrollViewRenderer.class, __md_methods);
    }

    public ScrollViewRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == ScrollViewRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.ScrollViewRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public ScrollViewRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == ScrollViewRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.ScrollViewRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public ScrollViewRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == ScrollViewRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.ScrollViewRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public void draw(Canvas canvas) {
        n_draw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return n_onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
    }

    public void onAttachedToWindow() {
        n_onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        n_onDetachedFromWindow();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        n_onScrollChanged(i, i2, i3, i4);
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        if (this.refList != null) {
            this.refList.clear();
        }
    }
}
