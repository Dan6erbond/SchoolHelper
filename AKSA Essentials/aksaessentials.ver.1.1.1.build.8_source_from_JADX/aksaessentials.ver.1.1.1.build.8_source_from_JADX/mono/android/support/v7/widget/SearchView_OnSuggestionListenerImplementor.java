package mono.android.support.v7.widget;

import android.support.v7.widget.SearchView.OnSuggestionListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SearchView_OnSuggestionListenerImplementor implements IGCUserPeer, OnSuggestionListener {
    public static final String __md_methods = "n_onSuggestionClick:(I)Z:GetOnSuggestionClick_IHandler:Android.Support.V7.Widget.SearchView/IOnSuggestionListenerInvoker, Xamarin.Android.Support.v7.AppCompat\nn_onSuggestionSelect:(I)Z:GetOnSuggestionSelect_IHandler:Android.Support.V7.Widget.SearchView/IOnSuggestionListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native boolean n_onSuggestionClick(int i);

    private native boolean n_onSuggestionSelect(int i);

    static {
        Runtime.register("Android.Support.V7.Widget.SearchView+IOnSuggestionListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", SearchView_OnSuggestionListenerImplementor.class, __md_methods);
    }

    public SearchView_OnSuggestionListenerImplementor() throws Throwable {
        if (getClass() == SearchView_OnSuggestionListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.SearchView+IOnSuggestionListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onSuggestionClick(int i) {
        return n_onSuggestionClick(i);
    }

    public boolean onSuggestionSelect(int i) {
        return n_onSuggestionSelect(i);
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
