package mono.android.support.v7.widget;

import android.support.v7.widget.ActionMenuView.OnMenuItemClickListener;
import android.view.MenuItem;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionMenuView_OnMenuItemClickListenerImplementor implements IGCUserPeer, OnMenuItemClickListener {
    public static final String __md_methods = "n_onMenuItemClick:(Landroid/view/MenuItem;)Z:GetOnMenuItemClick_Landroid_view_MenuItem_Handler:Android.Support.V7.Widget.ActionMenuView/IOnMenuItemClickListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native boolean n_onMenuItemClick(MenuItem menuItem);

    static {
        Runtime.register("Android.Support.V7.Widget.ActionMenuView+IOnMenuItemClickListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ActionMenuView_OnMenuItemClickListenerImplementor.class, __md_methods);
    }

    public ActionMenuView_OnMenuItemClickListenerImplementor() throws Throwable {
        if (getClass() == ActionMenuView_OnMenuItemClickListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.ActionMenuView+IOnMenuItemClickListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return n_onMenuItemClick(menuItem);
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
