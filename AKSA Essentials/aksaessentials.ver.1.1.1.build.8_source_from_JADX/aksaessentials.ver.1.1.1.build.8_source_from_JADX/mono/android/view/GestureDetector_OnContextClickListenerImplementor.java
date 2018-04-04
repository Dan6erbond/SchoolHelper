package mono.android.view;

import android.view.GestureDetector.OnContextClickListener;
import android.view.MotionEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GestureDetector_OnContextClickListenerImplementor implements IGCUserPeer, OnContextClickListener {
    public static final String __md_methods = "n_onContextClick:(Landroid/view/MotionEvent;)Z:GetOnContextClick_Landroid_view_MotionEvent_Handler:Android.Views.GestureDetector/IOnContextClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onContextClick(MotionEvent motionEvent);

    static {
        Runtime.register("Android.Views.GestureDetector+IOnContextClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", GestureDetector_OnContextClickListenerImplementor.class, __md_methods);
    }

    public GestureDetector_OnContextClickListenerImplementor() throws Throwable {
        if (getClass() == GestureDetector_OnContextClickListenerImplementor.class) {
            TypeManager.Activate("Android.Views.GestureDetector+IOnContextClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onContextClick(MotionEvent motionEvent) {
        return n_onContextClick(motionEvent);
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
