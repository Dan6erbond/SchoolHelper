package mono.android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class RecyclerView_OnItemTouchListenerImplementor implements IGCUserPeer, OnItemTouchListener {
    public static final String __md_methods = "n_onInterceptTouchEvent:(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)Z:GetOnInterceptTouchEvent_Landroid_support_v7_widget_RecyclerView_Landroid_view_MotionEvent_Handler:Android.Support.V7.Widget.RecyclerView/IOnItemTouchListenerInvoker, Xamarin.Android.Support.v7.RecyclerView\nn_onRequestDisallowInterceptTouchEvent:(Z)V:GetOnRequestDisallowInterceptTouchEvent_ZHandler:Android.Support.V7.Widget.RecyclerView/IOnItemTouchListenerInvoker, Xamarin.Android.Support.v7.RecyclerView\nn_onTouchEvent:(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V:GetOnTouchEvent_Landroid_support_v7_widget_RecyclerView_Landroid_view_MotionEvent_Handler:Android.Support.V7.Widget.RecyclerView/IOnItemTouchListenerInvoker, Xamarin.Android.Support.v7.RecyclerView\n";
    private ArrayList refList;

    private native boolean n_onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

    private native void n_onRequestDisallowInterceptTouchEvent(boolean z);

    private native void n_onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

    static {
        Runtime.register("Android.Support.V7.Widget.RecyclerView+IOnItemTouchListenerImplementor, Xamarin.Android.Support.v7.RecyclerView, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", RecyclerView_OnItemTouchListenerImplementor.class, __md_methods);
    }

    public RecyclerView_OnItemTouchListenerImplementor() throws Throwable {
        if (getClass() == RecyclerView_OnItemTouchListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.RecyclerView+IOnItemTouchListenerImplementor, Xamarin.Android.Support.v7.RecyclerView, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        return n_onInterceptTouchEvent(recyclerView, motionEvent);
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        n_onRequestDisallowInterceptTouchEvent(z);
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        n_onTouchEvent(recyclerView, motionEvent);
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
