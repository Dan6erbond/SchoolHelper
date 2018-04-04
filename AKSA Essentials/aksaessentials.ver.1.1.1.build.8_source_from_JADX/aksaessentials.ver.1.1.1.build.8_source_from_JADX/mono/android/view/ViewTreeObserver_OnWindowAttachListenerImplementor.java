package mono.android.view;

import android.view.ViewTreeObserver.OnWindowAttachListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewTreeObserver_OnWindowAttachListenerImplementor implements IGCUserPeer, OnWindowAttachListener {
    public static final String __md_methods = "n_onWindowAttached:()V:GetOnWindowAttachedHandler:Android.Views.ViewTreeObserver/IOnWindowAttachListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onWindowDetached:()V:GetOnWindowDetachedHandler:Android.Views.ViewTreeObserver/IOnWindowAttachListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onWindowAttached();

    private native void n_onWindowDetached();

    static {
        Runtime.register("Android.Views.ViewTreeObserver+IOnWindowAttachListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ViewTreeObserver_OnWindowAttachListenerImplementor.class, __md_methods);
    }

    public ViewTreeObserver_OnWindowAttachListenerImplementor() throws Throwable {
        if (getClass() == ViewTreeObserver_OnWindowAttachListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ViewTreeObserver+IOnWindowAttachListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onWindowAttached() {
        n_onWindowAttached();
    }

    public void onWindowDetached() {
        n_onWindowDetached();
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
