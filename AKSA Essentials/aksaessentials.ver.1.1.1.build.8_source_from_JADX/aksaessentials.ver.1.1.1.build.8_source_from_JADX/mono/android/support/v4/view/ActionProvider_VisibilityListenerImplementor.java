package mono.android.support.v4.view;

import android.support.v4.view.ActionProvider.VisibilityListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionProvider_VisibilityListenerImplementor implements IGCUserPeer, VisibilityListener {
    public static final String __md_methods = "n_onActionProviderVisibilityChanged:(Z)V:GetOnActionProviderVisibilityChanged_ZHandler:Android.Support.V4.View.ActionProvider/IVisibilityListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onActionProviderVisibilityChanged(boolean z);

    static {
        Runtime.register("Android.Support.V4.View.ActionProvider+IVisibilityListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ActionProvider_VisibilityListenerImplementor.class, __md_methods);
    }

    public ActionProvider_VisibilityListenerImplementor() throws Throwable {
        if (getClass() == ActionProvider_VisibilityListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.View.ActionProvider+IVisibilityListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        n_onActionProviderVisibilityChanged(z);
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
