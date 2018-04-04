package mono.android.media;

import android.media.MediaSync;
import android.media.MediaSync.OnErrorListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaSync_OnErrorListenerImplementor implements IGCUserPeer, OnErrorListener {
    public static final String __md_methods = "n_onError:(Landroid/media/MediaSync;II)V:GetOnError_Landroid_media_MediaSync_IIHandler:Android.Media.MediaSync/IOnErrorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onError(MediaSync mediaSync, int i, int i2);

    static {
        Runtime.register("Android.Media.MediaSync+IOnErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaSync_OnErrorListenerImplementor.class, __md_methods);
    }

    public MediaSync_OnErrorListenerImplementor() throws Throwable {
        if (getClass() == MediaSync_OnErrorListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaSync+IOnErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onError(MediaSync mediaSync, int i, int i2) {
        n_onError(mediaSync, i, i2);
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
