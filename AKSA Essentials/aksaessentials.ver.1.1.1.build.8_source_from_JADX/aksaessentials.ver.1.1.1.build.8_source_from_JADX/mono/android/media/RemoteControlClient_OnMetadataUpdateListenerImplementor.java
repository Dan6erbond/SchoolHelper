package mono.android.media;

import android.media.RemoteControlClient.OnMetadataUpdateListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class RemoteControlClient_OnMetadataUpdateListenerImplementor implements IGCUserPeer, OnMetadataUpdateListener {
    public static final String __md_methods = "n_onMetadataUpdate:(ILjava/lang/Object;)V:GetOnMetadataUpdate_ILjava_lang_Object_Handler:Android.Media.RemoteControlClient/IOnMetadataUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onMetadataUpdate(int i, Object obj);

    static {
        Runtime.register("Android.Media.RemoteControlClient+IOnMetadataUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", RemoteControlClient_OnMetadataUpdateListenerImplementor.class, __md_methods);
    }

    public RemoteControlClient_OnMetadataUpdateListenerImplementor() throws Throwable {
        if (getClass() == RemoteControlClient_OnMetadataUpdateListenerImplementor.class) {
            TypeManager.Activate("Android.Media.RemoteControlClient+IOnMetadataUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onMetadataUpdate(int i, Object obj) {
        n_onMetadataUpdate(i, obj);
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
