package mono.android.support.v7.widget;

import android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class C0370xc23ccd3c implements IGCUserPeer, ItemAnimatorFinishedListener {
    public static final String __md_methods = "n_onAnimationsFinished:()V:GetOnAnimationsFinishedHandler:Android.Support.V7.Widget.RecyclerView/ItemAnimator/IItemAnimatorFinishedListenerInvoker, Xamarin.Android.Support.v7.RecyclerView\n";
    private ArrayList refList;

    private native void n_onAnimationsFinished();

    static {
        Runtime.register("Android.Support.V7.Widget.RecyclerView+ItemAnimator+IItemAnimatorFinishedListenerImplementor, Xamarin.Android.Support.v7.RecyclerView, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", C0370xc23ccd3c.class, __md_methods);
    }

    public C0370xc23ccd3c() throws Throwable {
        if (getClass() == C0370xc23ccd3c.class) {
            TypeManager.Activate("Android.Support.V7.Widget.RecyclerView+ItemAnimator+IItemAnimatorFinishedListenerImplementor, Xamarin.Android.Support.v7.RecyclerView, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onAnimationsFinished() {
        n_onAnimationsFinished();
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
