package mono.android.media;

import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class RemoteControlClient_OnPlaybackPositionUpdateListenerImplementor implements IGCUserPeer, OnPlaybackPositionUpdateListener {
    public static final String __md_methods = "n_onPlaybackPositionUpdate:(J)V:GetOnPlaybackPositionUpdate_JHandler:Android.Media.RemoteControlClient/IOnPlaybackPositionUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onPlaybackPositionUpdate(long j);

    static {
        Runtime.register("Android.Media.RemoteControlClient+IOnPlaybackPositionUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", RemoteControlClient_OnPlaybackPositionUpdateListenerImplementor.class, __md_methods);
    }

    public RemoteControlClient_OnPlaybackPositionUpdateListenerImplementor() throws Throwable {
        if (getClass() == RemoteControlClient_OnPlaybackPositionUpdateListenerImplementor.class) {
            TypeManager.Activate("Android.Media.RemoteControlClient+IOnPlaybackPositionUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onPlaybackPositionUpdate(long j) {
        n_onPlaybackPositionUpdate(j);
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
