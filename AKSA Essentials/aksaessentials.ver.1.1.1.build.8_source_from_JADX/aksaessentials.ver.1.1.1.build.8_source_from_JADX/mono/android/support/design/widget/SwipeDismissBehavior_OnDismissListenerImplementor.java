package mono.android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior.OnDismissListener;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SwipeDismissBehavior_OnDismissListenerImplementor implements IGCUserPeer, OnDismissListener {
    public static final String __md_methods = "n_onDismiss:(Landroid/view/View;)V:GetOnDismiss_Landroid_view_View_Handler:Android.Support.Design.Widget.SwipeDismissBehavior/IOnDismissListenerInvoker, Xamarin.Android.Support.Design\nn_onDragStateChanged:(I)V:GetOnDragStateChanged_IHandler:Android.Support.Design.Widget.SwipeDismissBehavior/IOnDismissListenerInvoker, Xamarin.Android.Support.Design\n";
    private ArrayList refList;

    private native void n_onDismiss(View view);

    private native void n_onDragStateChanged(int i);

    static {
        Runtime.register("Android.Support.Design.Widget.SwipeDismissBehavior+IOnDismissListenerImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", SwipeDismissBehavior_OnDismissListenerImplementor.class, __md_methods);
    }

    public SwipeDismissBehavior_OnDismissListenerImplementor() throws Throwable {
        if (getClass() == SwipeDismissBehavior_OnDismissListenerImplementor.class) {
            TypeManager.Activate("Android.Support.Design.Widget.SwipeDismissBehavior+IOnDismissListenerImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onDismiss(View view) {
        n_onDismiss(view);
    }

    public void onDragStateChanged(int i) {
        n_onDragStateChanged(i);
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
