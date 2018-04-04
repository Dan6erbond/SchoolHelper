package mono.android.support.v4.app;

import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FragmentManager_OnBackStackChangedListenerImplementor implements IGCUserPeer, OnBackStackChangedListener {
    public static final String __md_methods = "n_onBackStackChanged:()V:GetOnBackStackChangedHandler:Android.Support.V4.App.FragmentManager/IOnBackStackChangedListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onBackStackChanged();

    static {
        Runtime.register("Android.Support.V4.App.FragmentManager+IOnBackStackChangedListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", FragmentManager_OnBackStackChangedListenerImplementor.class, __md_methods);
    }

    public FragmentManager_OnBackStackChangedListenerImplementor() throws Throwable {
        if (getClass() == FragmentManager_OnBackStackChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.App.FragmentManager+IOnBackStackChangedListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onBackStackChanged() {
        n_onBackStackChanged();
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
