package mono.android.media;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnTimedMetaDataAvailableListener;
import android.media.TimedMetaData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaPlayer_OnTimedMetaDataAvailableListenerImplementor implements IGCUserPeer, OnTimedMetaDataAvailableListener {
    public static final String __md_methods = "n_onTimedMetaDataAvailable:(Landroid/media/MediaPlayer;Landroid/media/TimedMetaData;)V:GetOnTimedMetaDataAvailable_Landroid_media_MediaPlayer_Landroid_media_TimedMetaData_Handler:Android.Media.MediaPlayer/IOnTimedMetaDataAvailableListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTimedMetaDataAvailable(MediaPlayer mediaPlayer, TimedMetaData timedMetaData);

    static {
        Runtime.register("Android.Media.MediaPlayer+IOnTimedMetaDataAvailableListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaPlayer_OnTimedMetaDataAvailableListenerImplementor.class, __md_methods);
    }

    public MediaPlayer_OnTimedMetaDataAvailableListenerImplementor() throws Throwable {
        if (getClass() == MediaPlayer_OnTimedMetaDataAvailableListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaPlayer+IOnTimedMetaDataAvailableListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTimedMetaDataAvailable(MediaPlayer mediaPlayer, TimedMetaData timedMetaData) {
        n_onTimedMetaDataAvailable(mediaPlayer, timedMetaData);
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
