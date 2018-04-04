package mono.android.support.v7.widget;

import android.support.v7.widget.SearchView.OnCloseListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SearchView_OnCloseListenerImplementor implements IGCUserPeer, OnCloseListener {
    public static final String __md_methods = "n_onClose:()Z:GetOnCloseHandler:Android.Support.V7.Widget.SearchView/IOnCloseListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native boolean n_onClose();

    static {
        Runtime.register("Android.Support.V7.Widget.SearchView+IOnCloseListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", SearchView_OnCloseListenerImplementor.class, __md_methods);
    }

    public SearchView_OnCloseListenerImplementor() throws Throwable {
        if (getClass() == SearchView_OnCloseListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.SearchView+IOnCloseListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onClose() {
        return n_onClose();
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
