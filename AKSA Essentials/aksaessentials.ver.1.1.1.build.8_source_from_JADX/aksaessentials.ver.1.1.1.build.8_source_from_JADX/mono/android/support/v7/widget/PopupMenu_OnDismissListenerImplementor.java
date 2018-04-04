package mono.android.support.v7.widget;

import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnDismissListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PopupMenu_OnDismissListenerImplementor implements IGCUserPeer, OnDismissListener {
    public static final String __md_methods = "n_onDismiss:(Landroid/support/v7/widget/PopupMenu;)V:GetOnDismiss_Landroid_support_v7_widget_PopupMenu_Handler:Android.Support.V7.Widget.PopupMenu/IOnDismissListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native void n_onDismiss(PopupMenu popupMenu);

    static {
        Runtime.register("Android.Support.V7.Widget.PopupMenu+IOnDismissListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", PopupMenu_OnDismissListenerImplementor.class, __md_methods);
    }

    public PopupMenu_OnDismissListenerImplementor() throws Throwable {
        if (getClass() == PopupMenu_OnDismissListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.PopupMenu+IOnDismissListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onDismiss(PopupMenu popupMenu) {
        n_onDismiss(popupMenu);
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
