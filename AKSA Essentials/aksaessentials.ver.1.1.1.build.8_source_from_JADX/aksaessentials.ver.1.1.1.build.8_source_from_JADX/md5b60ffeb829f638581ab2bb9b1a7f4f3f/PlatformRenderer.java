package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PlatformRenderer extends ViewGroup implements IGCUserPeer {
    public static final String __md_methods = "n_dispatchTouchEvent:(Landroid/view/MotionEvent;)Z:GetDispatchTouchEvent_Landroid_view_MotionEvent_Handler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onMeasure:(II)V:GetOnMeasure_IIHandler\n";
    private ArrayList refList;

    private native boolean n_dispatchTouchEvent(MotionEvent motionEvent);

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onMeasure(int i, int i2);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.PlatformRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", PlatformRenderer.class, __md_methods);
    }

    public PlatformRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == PlatformRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.PlatformRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public PlatformRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == PlatformRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.PlatformRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public PlatformRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == PlatformRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.PlatformRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return n_dispatchTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    public void onMeasure(int i, int i2) {
        n_onMeasure(i, i2);
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
