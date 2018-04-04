package mono.android.view;

import android.view.ViewTreeObserver.OnWindowFocusChangeListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewTreeObserver_OnWindowFocusChangeListenerImplementor implements IGCUserPeer, OnWindowFocusChangeListener {
    public static final String __md_methods = "n_onWindowFocusChanged:(Z)V:GetOnWindowFocusChanged_ZHandler:Android.Views.ViewTreeObserver/IOnWindowFocusChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onWindowFocusChanged(boolean z);

    static {
        Runtime.register("Android.Views.ViewTreeObserver+IOnWindowFocusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ViewTreeObserver_OnWindowFocusChangeListenerImplementor.class, __md_methods);
    }

    public ViewTreeObserver_OnWindowFocusChangeListenerImplementor() throws Throwable {
        if (getClass() == ViewTreeObserver_OnWindowFocusChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ViewTreeObserver+IOnWindowFocusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        n_onWindowFocusChanged(z);
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
