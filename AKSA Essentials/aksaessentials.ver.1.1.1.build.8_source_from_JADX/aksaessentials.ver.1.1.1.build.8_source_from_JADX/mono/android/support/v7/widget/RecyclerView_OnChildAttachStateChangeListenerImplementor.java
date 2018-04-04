package mono.android.support.v7.widget;

import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class RecyclerView_OnChildAttachStateChangeListenerImplementor implements IGCUserPeer, OnChildAttachStateChangeListener {
    public static final String __md_methods = "n_onChildViewAttachedToWindow:(Landroid/view/View;)V:GetOnChildViewAttachedToWindow_Landroid_view_View_Handler:Android.Support.V7.Widget.RecyclerView/IOnChildAttachStateChangeListenerInvoker, Xamarin.Android.Support.v7.RecyclerView\nn_onChildViewDetachedFromWindow:(Landroid/view/View;)V:GetOnChildViewDetachedFromWindow_Landroid_view_View_Handler:Android.Support.V7.Widget.RecyclerView/IOnChildAttachStateChangeListenerInvoker, Xamarin.Android.Support.v7.RecyclerView\n";
    private ArrayList refList;

    private native void n_onChildViewAttachedToWindow(View view);

    private native void n_onChildViewDetachedFromWindow(View view);

    static {
        Runtime.register("Android.Support.V7.Widget.RecyclerView+IOnChildAttachStateChangeListenerImplementor, Xamarin.Android.Support.v7.RecyclerView, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", RecyclerView_OnChildAttachStateChangeListenerImplementor.class, __md_methods);
    }

    public RecyclerView_OnChildAttachStateChangeListenerImplementor() throws Throwable {
        if (getClass() == RecyclerView_OnChildAttachStateChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.RecyclerView+IOnChildAttachStateChangeListenerImplementor, Xamarin.Android.Support.v7.RecyclerView, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onChildViewAttachedToWindow(View view) {
        n_onChildViewAttachedToWindow(view);
    }

    public void onChildViewDetachedFromWindow(View view) {
        n_onChildViewDetachedFromWindow(view);
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
