package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GenericMenuClickListener implements IGCUserPeer, OnMenuItemClickListener {
    public static final String __md_methods = "n_onMenuItemClick:(Landroid/view/MenuItem;)Z:GetOnMenuItemClick_Landroid_view_MenuItem_Handler:Android.Views.IMenuItemOnMenuItemClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onMenuItemClick(MenuItem menuItem);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.GenericMenuClickListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", GenericMenuClickListener.class, __md_methods);
    }

    public GenericMenuClickListener() throws Throwable {
        if (getClass() == GenericMenuClickListener.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.GenericMenuClickListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
