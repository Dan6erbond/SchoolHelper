package mono.android.media;

import android.media.RemoteController.MetadataEditor;
import android.media.RemoteController.OnClientUpdateListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class RemoteController_OnClientUpdateListenerImplementor implements IGCUserPeer, OnClientUpdateListener {
    public static final String __md_methods = "n_onClientChange:(Z)V:GetOnClientChange_ZHandler:Android.Media.RemoteController/IOnClientUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onClientMetadataUpdate:(Landroid/media/RemoteController$MetadataEditor;)V:GetOnClientMetadataUpdate_Landroid_media_RemoteController_MetadataEditor_Handler:Android.Media.RemoteController/IOnClientUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onClientPlaybackStateUpdate:(I)V:GetOnClientPlaybackStateUpdateSimple_IHandler:Android.Media.RemoteController/IOnClientUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onClientPlaybackStateUpdate:(IJJF)V:GetOnClientPlaybackStateUpdate_IJJFHandler:Android.Media.RemoteController/IOnClientUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onClientTransportControlUpdate:(I)V:GetOnClientTransportControlUpdate_IHandler:Android.Media.RemoteController/IOnClientUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onClientChange(boolean z);

    private native void n_onClientMetadataUpdate(MetadataEditor metadataEditor);

    private native void n_onClientPlaybackStateUpdate(int i);

    private native void n_onClientPlaybackStateUpdate(int i, long j, long j2, float f);

    private native void n_onClientTransportControlUpdate(int i);

    static {
        Runtime.register("Android.Media.RemoteController+IOnClientUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", RemoteController_OnClientUpdateListenerImplementor.class, __md_methods);
    }

    public RemoteController_OnClientUpdateListenerImplementor() throws Throwable {
        if (getClass() == RemoteController_OnClientUpdateListenerImplementor.class) {
            TypeManager.Activate("Android.Media.RemoteController+IOnClientUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onClientChange(boolean z) {
        n_onClientChange(z);
    }

    public void onClientMetadataUpdate(MetadataEditor metadataEditor) {
        n_onClientMetadataUpdate(metadataEditor);
    }

    public void onClientPlaybackStateUpdate(int i) {
        n_onClientPlaybackStateUpdate(i);
    }

    public void onClientPlaybackStateUpdate(int i, long j, long j2, float f) {
        n_onClientPlaybackStateUpdate(i, j, j2, f);
    }

    public void onClientTransportControlUpdate(int i) {
        n_onClientTransportControlUpdate(i);
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
