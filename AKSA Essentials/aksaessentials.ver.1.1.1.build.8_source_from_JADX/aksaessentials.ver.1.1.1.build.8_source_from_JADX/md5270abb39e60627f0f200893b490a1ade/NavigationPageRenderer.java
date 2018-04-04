package md5270abb39e60627f0f200893b490a1ade;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import md5b60ffeb829f638581ab2bb9b1a7f4f3f.VisualElementRenderer_1;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NavigationPageRenderer extends VisualElementRenderer_1 implements IGCUserPeer {
    public static final String __md_methods = "n_onAttachedToWindow:()V:GetOnAttachedToWindowHandler\nn_onDetachedFromWindow:()V:GetOnDetachedFromWindowHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\n";
    private ArrayList refList;

    private native void n_onAttachedToWindow();

    private native void n_onDetachedFromWindow();

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AppCompat.NavigationPageRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", NavigationPageRenderer.class, __md_methods);
    }

    public NavigationPageRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == NavigationPageRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.NavigationPageRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public NavigationPageRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == NavigationPageRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.NavigationPageRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public NavigationPageRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == NavigationPageRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.NavigationPageRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
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
