package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class VisualElementTracker_AttachTracker implements IGCUserPeer, OnAttachStateChangeListener {
    public static final String __md_methods = "n_onViewAttachedToWindow:(Landroid/view/View;)V:GetOnViewAttachedToWindow_Landroid_view_View_Handler:Android.Views.View/IOnAttachStateChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onViewDetachedFromWindow:(Landroid/view/View;)V:GetOnViewDetachedFromWindow_Landroid_view_View_Handler:Android.Views.View/IOnAttachStateChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onViewAttachedToWindow(View view);

    private native void n_onViewDetachedFromWindow(View view);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.VisualElementTracker+AttachTracker, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", VisualElementTracker_AttachTracker.class, __md_methods);
    }

    public VisualElementTracker_AttachTracker() throws Throwable {
        if (getClass() == VisualElementTracker_AttachTracker.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.VisualElementTracker+AttachTracker, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onViewAttachedToWindow(View view) {
        n_onViewAttachedToWindow(view);
    }

    public void onViewDetachedFromWindow(View view) {
        n_onViewDetachedFromWindow(view);
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
