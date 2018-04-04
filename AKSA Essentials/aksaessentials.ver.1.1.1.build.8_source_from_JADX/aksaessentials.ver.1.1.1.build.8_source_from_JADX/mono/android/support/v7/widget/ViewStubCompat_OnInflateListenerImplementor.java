package mono.android.support.v7.widget;

import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ViewStubCompat.OnInflateListener;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewStubCompat_OnInflateListenerImplementor implements IGCUserPeer, OnInflateListener {
    public static final String __md_methods = "n_onInflate:(Landroid/support/v7/widget/ViewStubCompat;Landroid/view/View;)V:GetOnInflate_Landroid_support_v7_widget_ViewStubCompat_Landroid_view_View_Handler:Android.Support.V7.Widget.ViewStubCompat/IOnInflateListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native void n_onInflate(ViewStubCompat viewStubCompat, View view);

    static {
        Runtime.register("Android.Support.V7.Widget.ViewStubCompat+IOnInflateListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ViewStubCompat_OnInflateListenerImplementor.class, __md_methods);
    }

    public ViewStubCompat_OnInflateListenerImplementor() throws Throwable {
        if (getClass() == ViewStubCompat_OnInflateListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.ViewStubCompat+IOnInflateListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onInflate(ViewStubCompat viewStubCompat, View view) {
        n_onInflate(viewStubCompat, view);
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
