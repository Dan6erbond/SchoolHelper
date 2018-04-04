package mono.android.os;

import android.os.MessageQueue.OnFileDescriptorEventListener;
import java.io.FileDescriptor;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MessageQueue_OnFileDescriptorEventListenerImplementor implements IGCUserPeer, OnFileDescriptorEventListener {
    public static final String __md_methods = "n_onFileDescriptorEvents:(Ljava/io/FileDescriptor;I)I:GetOnFileDescriptorEvents_Ljava_io_FileDescriptor_IHandler:Android.OS.MessageQueue/IOnFileDescriptorEventListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native int n_onFileDescriptorEvents(FileDescriptor fileDescriptor, int i);

    static {
        Runtime.register("Android.OS.MessageQueue+IOnFileDescriptorEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MessageQueue_OnFileDescriptorEventListenerImplementor.class, __md_methods);
    }

    public MessageQueue_OnFileDescriptorEventListenerImplementor() throws Throwable {
        if (getClass() == MessageQueue_OnFileDescriptorEventListenerImplementor.class) {
            TypeManager.Activate("Android.OS.MessageQueue+IOnFileDescriptorEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public int onFileDescriptorEvents(FileDescriptor fileDescriptor, int i) {
        return n_onFileDescriptorEvents(fileDescriptor, i);
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
