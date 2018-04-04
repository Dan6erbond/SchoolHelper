package mono.android.widget;

import android.view.MenuItem;
import android.widget.Toolbar.OnMenuItemClickListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Toolbar_OnMenuItemClickListenerImplementor implements IGCUserPeer, OnMenuItemClickListener {
    public static final String __md_methods = "n_onMenuItemClick:(Landroid/view/MenuItem;)Z:GetOnMenuItemClick_Landroid_view_MenuItem_Handler:Android.Widget.Toolbar/IOnMenuItemClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onMenuItemClick(MenuItem menuItem);

    static {
        Runtime.register("Android.Widget.Toolbar+IOnMenuItemClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Toolbar_OnMenuItemClickListenerImplementor.class, __md_methods);
    }

    public Toolbar_OnMenuItemClickListenerImplementor() throws Throwable {
        if (getClass() == Toolbar_OnMenuItemClickListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.Toolbar+IOnMenuItemClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
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
