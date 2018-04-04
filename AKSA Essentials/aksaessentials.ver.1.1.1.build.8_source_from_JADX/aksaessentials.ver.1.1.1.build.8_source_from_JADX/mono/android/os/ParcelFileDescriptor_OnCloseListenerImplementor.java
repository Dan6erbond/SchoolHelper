package mono.android.os;

import android.os.ParcelFileDescriptor.OnCloseListener;
import java.io.IOException;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ParcelFileDescriptor_OnCloseListenerImplementor implements IGCUserPeer, OnCloseListener {
    public static final String __md_methods = "n_onClose:(Ljava/io/IOException;)V:GetOnClose_Ljava_io_IOException_Handler:Android.OS.ParcelFileDescriptor/IOnCloseListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onClose(IOException iOException);

    static {
        Runtime.register("Android.OS.ParcelFileDescriptor+IOnCloseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ParcelFileDescriptor_OnCloseListenerImplementor.class, __md_methods);
    }

    public ParcelFileDescriptor_OnCloseListenerImplementor() throws Throwable {
        if (getClass() == ParcelFileDescriptor_OnCloseListenerImplementor.class) {
            TypeManager.Activate("Android.OS.ParcelFileDescriptor+IOnCloseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onClose(IOException iOException) {
        n_onClose(iOException);
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
