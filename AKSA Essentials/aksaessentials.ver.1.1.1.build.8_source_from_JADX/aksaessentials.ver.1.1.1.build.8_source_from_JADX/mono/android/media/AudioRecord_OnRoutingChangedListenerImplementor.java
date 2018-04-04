package mono.android.media;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRoutingChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AudioRecord_OnRoutingChangedListenerImplementor implements IGCUserPeer, OnRoutingChangedListener {
    public static final String __md_methods = "n_onRoutingChanged:(Landroid/media/AudioRecord;)V:GetOnRoutingChanged_Landroid_media_AudioRecord_Handler:Android.Media.AudioRecord/IOnRoutingChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onRoutingChanged(AudioRecord audioRecord);

    static {
        Runtime.register("Android.Media.AudioRecord+IOnRoutingChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AudioRecord_OnRoutingChangedListenerImplementor.class, __md_methods);
    }

    public AudioRecord_OnRoutingChangedListenerImplementor() throws Throwable {
        if (getClass() == AudioRecord_OnRoutingChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Media.AudioRecord+IOnRoutingChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onRoutingChanged(AudioRecord audioRecord) {
        n_onRoutingChanged(audioRecord);
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
