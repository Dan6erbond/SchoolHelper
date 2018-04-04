package mono.android.support.design.widget;

import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.view.MenuItem;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NavigationView_OnNavigationItemSelectedListenerImplementor implements IGCUserPeer, OnNavigationItemSelectedListener {
    public static final String __md_methods = "n_onNavigationItemSelected:(Landroid/view/MenuItem;)Z:GetOnNavigationItemSelected_Landroid_view_MenuItem_Handler:Android.Support.Design.Widget.NavigationView/IOnNavigationItemSelectedListenerInvoker, Xamarin.Android.Support.Design\n";
    private ArrayList refList;

    private native boolean n_onNavigationItemSelected(MenuItem menuItem);

    static {
        Runtime.register("Android.Support.Design.Widget.NavigationView+IOnNavigationItemSelectedListenerImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", NavigationView_OnNavigationItemSelectedListenerImplementor.class, __md_methods);
    }

    public NavigationView_OnNavigationItemSelectedListenerImplementor() throws Throwable {
        if (getClass() == NavigationView_OnNavigationItemSelectedListenerImplementor.class) {
            TypeManager.Activate("Android.Support.Design.Widget.NavigationView+IOnNavigationItemSelectedListenerImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return n_onNavigationItemSelected(menuItem);
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
