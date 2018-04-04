package mono.android.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon.OnDrawableLoadedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Icon_OnDrawableLoadedListenerImplementor implements IGCUserPeer, OnDrawableLoadedListener {
    public static final String __md_methods = "n_onDrawableLoaded:(Landroid/graphics/drawable/Drawable;)V:GetOnDrawableLoaded_Landroid_graphics_drawable_Drawable_Handler:Android.Graphics.Drawables.Icon/IOnDrawableLoadedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDrawableLoaded(Drawable drawable);

    static {
        Runtime.register("Android.Graphics.Drawables.Icon+IOnDrawableLoadedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Icon_OnDrawableLoadedListenerImplementor.class, __md_methods);
    }

    public Icon_OnDrawableLoadedListenerImplementor() throws Throwable {
        if (getClass() == Icon_OnDrawableLoadedListenerImplementor.class) {
            TypeManager.Activate("Android.Graphics.Drawables.Icon+IOnDrawableLoadedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDrawableLoaded(Drawable drawable) {
        n_onDrawableLoaded(drawable);
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
