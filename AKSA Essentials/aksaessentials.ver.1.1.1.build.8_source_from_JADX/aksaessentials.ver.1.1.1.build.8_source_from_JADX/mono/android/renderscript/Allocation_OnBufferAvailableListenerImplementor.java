package mono.android.renderscript;

import android.renderscript.Allocation;
import android.renderscript.Allocation.OnBufferAvailableListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Allocation_OnBufferAvailableListenerImplementor implements IGCUserPeer, OnBufferAvailableListener {
    public static final String __md_methods = "n_onBufferAvailable:(Landroid/renderscript/Allocation;)V:GetOnBufferAvailable_Landroid_renderscript_Allocation_Handler:Android.Renderscripts.Allocation/IOnBufferAvailableListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onBufferAvailable(Allocation allocation);

    static {
        Runtime.register("Android.Renderscripts.Allocation+IOnBufferAvailableListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Allocation_OnBufferAvailableListenerImplementor.class, __md_methods);
    }

    public Allocation_OnBufferAvailableListenerImplementor() throws Throwable {
        if (getClass() == Allocation_OnBufferAvailableListenerImplementor.class) {
            TypeManager.Activate("Android.Renderscripts.Allocation+IOnBufferAvailableListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onBufferAvailable(Allocation allocation) {
        n_onBufferAvailable(allocation);
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
