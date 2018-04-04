package mono.android.support.v4.os;

import android.support.v4.os.CancellationSignal.OnCancelListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class CancellationSignal_OnCancelListenerImplementor implements IGCUserPeer, OnCancelListener {
    public static final String __md_methods = "n_onCancel:()V:GetOnCancelHandler:Android.Support.V4.OS.CancellationSignal/IOnCancelListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onCancel();

    static {
        Runtime.register("Android.Support.V4.OS.CancellationSignal+IOnCancelListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", CancellationSignal_OnCancelListenerImplementor.class, __md_methods);
    }

    public CancellationSignal_OnCancelListenerImplementor() throws Throwable {
        if (getClass() == CancellationSignal_OnCancelListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.OS.CancellationSignal+IOnCancelListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCancel() {
        n_onCancel();
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
