package mono.android.view;

import android.graphics.Rect;
import android.view.Window.OnRestrictedCaptionAreaChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Window_OnRestrictedCaptionAreaChangedListenerImplementor implements IGCUserPeer, OnRestrictedCaptionAreaChangedListener {
    public static final String __md_methods = "n_onRestrictedCaptionAreaChanged:(Landroid/graphics/Rect;)V:GetOnRestrictedCaptionAreaChanged_Landroid_graphics_Rect_Handler:Android.Views.Window/IOnRestrictedCaptionAreaChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onRestrictedCaptionAreaChanged(Rect rect);

    static {
        Runtime.register("Android.Views.Window+IOnRestrictedCaptionAreaChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Window_OnRestrictedCaptionAreaChangedListenerImplementor.class, __md_methods);
    }

    public Window_OnRestrictedCaptionAreaChangedListenerImplementor() throws Throwable {
        if (getClass() == Window_OnRestrictedCaptionAreaChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Views.Window+IOnRestrictedCaptionAreaChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onRestrictedCaptionAreaChanged(Rect rect) {
        n_onRestrictedCaptionAreaChanged(rect);
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
