package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TabbedRenderer extends VisualElementRenderer_1 implements IGCUserPeer {
    public static final String __md_methods = "n_onAttachedToWindow:()V:GetOnAttachedToWindowHandler\nn_onDetachedFromWindow:()V:GetOnDetachedFromWindowHandler\n";
    private ArrayList refList;

    private native void n_onAttachedToWindow();

    private native void n_onDetachedFromWindow();

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.TabbedRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", TabbedRenderer.class, __md_methods);
    }

    public TabbedRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == TabbedRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.TabbedRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public TabbedRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == TabbedRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.TabbedRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public TabbedRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == TabbedRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.TabbedRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public void onAttachedToWindow() {
        n_onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        n_onDetachedFromWindow();
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
