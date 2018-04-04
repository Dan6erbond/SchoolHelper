package mono.android.support.v7.app;

import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionBar_OnMenuVisibilityListenerImplementor implements IGCUserPeer, OnMenuVisibilityListener {
    public static final String __md_methods = "n_onMenuVisibilityChanged:(Z)V:GetOnMenuVisibilityChanged_ZHandler:Android.Support.V7.App.ActionBar/IOnMenuVisibilityListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native void n_onMenuVisibilityChanged(boolean z);

    static {
        Runtime.register("Android.Support.V7.App.ActionBar+IOnMenuVisibilityListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ActionBar_OnMenuVisibilityListenerImplementor.class, __md_methods);
    }

    public ActionBar_OnMenuVisibilityListenerImplementor() throws Throwable {
        if (getClass() == ActionBar_OnMenuVisibilityListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.App.ActionBar+IOnMenuVisibilityListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onMenuVisibilityChanged(boolean z) {
        n_onMenuVisibilityChanged(z);
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
