package mono.android.support.v7.app;

import android.support.v7.app.ActionBar.OnNavigationListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionBar_OnNavigationListenerImplementor implements IGCUserPeer, OnNavigationListener {
    public static final String __md_methods = "n_onNavigationItemSelected:(IJ)Z:GetOnNavigationItemSelected_IJHandler:Android.Support.V7.App.ActionBar/IOnNavigationListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native boolean n_onNavigationItemSelected(int i, long j);

    static {
        Runtime.register("Android.Support.V7.App.ActionBar+IOnNavigationListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ActionBar_OnNavigationListenerImplementor.class, __md_methods);
    }

    public ActionBar_OnNavigationListenerImplementor() throws Throwable {
        if (getClass() == ActionBar_OnNavigationListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.App.ActionBar+IOnNavigationListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onNavigationItemSelected(int i, long j) {
        return n_onNavigationItemSelected(i, j);
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
