package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NavigationMenuRenderer extends ViewRenderer implements IGCUserPeer {
    public static final String __md_methods = "n_onSizeChanged:(IIII)V:GetOnSizeChanged_IIIIHandler\n";
    private ArrayList refList;

    private native void n_onSizeChanged(int i, int i2, int i3, int i4);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.NavigationMenuRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", NavigationMenuRenderer.class, __md_methods);
    }

    public NavigationMenuRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == NavigationMenuRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.NavigationMenuRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public NavigationMenuRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == NavigationMenuRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.NavigationMenuRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public NavigationMenuRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == NavigationMenuRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.NavigationMenuRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        n_onSizeChanged(i, i2, i3, i4);
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
