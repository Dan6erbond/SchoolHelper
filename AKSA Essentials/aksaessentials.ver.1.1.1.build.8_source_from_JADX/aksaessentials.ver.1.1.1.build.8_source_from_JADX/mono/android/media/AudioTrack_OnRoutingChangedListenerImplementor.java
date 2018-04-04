package mono.android.media;

import android.media.AudioTrack;
import android.media.AudioTrack.OnRoutingChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AudioTrack_OnRoutingChangedListenerImplementor implements IGCUserPeer, OnRoutingChangedListener {
    public static final String __md_methods = "n_onRoutingChanged:(Landroid/media/AudioTrack;)V:GetOnRoutingChanged_Landroid_media_AudioTrack_Handler:Android.Media.AudioTrack/IOnRoutingChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onRoutingChanged(AudioTrack audioTrack);

    static {
        Runtime.register("Android.Media.AudioTrack+IOnRoutingChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AudioTrack_OnRoutingChangedListenerImplementor.class, __md_methods);
    }

    public AudioTrack_OnRoutingChangedListenerImplementor() throws Throwable {
        if (getClass() == AudioTrack_OnRoutingChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Media.AudioTrack+IOnRoutingChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onRoutingChanged(AudioTrack audioTrack) {
        n_onRoutingChanged(audioTrack);
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
