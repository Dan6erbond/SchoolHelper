package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AHorizontalScrollView extends HorizontalScrollView implements IGCUserPeer {
    public static final String __md_methods = "n_onInterceptTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnInterceptTouchEvent_Landroid_view_MotionEvent_Handler\nn_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\nn_onScrollChanged:(IIII)V:GetOnScrollChanged_IIIIHandler\n";
    private ArrayList refList;

    private native boolean n_onInterceptTouchEvent(MotionEvent motionEvent);

    private native void n_onScrollChanged(int i, int i2, int i3, int i4);

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AHorizontalScrollView, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", AHorizontalScrollView.class, __md_methods);
    }

    public AHorizontalScrollView(Context context) throws Throwable {
        super(context);
        if (getClass() == AHorizontalScrollView.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AHorizontalScrollView, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public AHorizontalScrollView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == AHorizontalScrollView.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AHorizontalScrollView, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public AHorizontalScrollView(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == AHorizontalScrollView.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AHorizontalScrollView, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return n_onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
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
