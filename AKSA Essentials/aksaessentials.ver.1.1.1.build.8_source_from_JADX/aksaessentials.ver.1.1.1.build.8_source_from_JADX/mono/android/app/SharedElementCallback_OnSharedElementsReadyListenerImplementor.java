package mono.android.app;

import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SharedElementCallback_OnSharedElementsReadyListenerImplementor implements IGCUserPeer, OnSharedElementsReadyListener {
    public static final String __md_methods = "n_onSharedElementsReady:()V:GetOnSharedElementsReadyHandler:Android.App.SharedElementCallback/IOnSharedElementsReadyListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onSharedElementsReady();

    static {
        Runtime.register("Android.App.SharedElementCallback+IOnSharedElementsReadyListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SharedElementCallback_OnSharedElementsReadyListenerImplementor.class, __md_methods);
    }

    public SharedElementCallback_OnSharedElementsReadyListenerImplementor() throws Throwable {
        if (getClass() == SharedElementCallback_OnSharedElementsReadyListenerImplementor.class) {
            TypeManager.Activate("Android.App.SharedElementCallback+IOnSharedElementsReadyListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onSharedElementsReady() {
        n_onSharedElementsReady();
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
