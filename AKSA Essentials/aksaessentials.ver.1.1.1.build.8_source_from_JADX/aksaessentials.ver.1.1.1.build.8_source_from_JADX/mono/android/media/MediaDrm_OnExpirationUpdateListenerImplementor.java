package mono.android.media;

import android.media.MediaDrm;
import android.media.MediaDrm.OnExpirationUpdateListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaDrm_OnExpirationUpdateListenerImplementor implements IGCUserPeer, OnExpirationUpdateListener {
    public static final String __md_methods = "n_onExpirationUpdate:(Landroid/media/MediaDrm;[BJ)V:GetOnExpirationUpdate_Landroid_media_MediaDrm_arrayBJHandler:Android.Media.MediaDrm/IOnExpirationUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j);

    static {
        Runtime.register("Android.Media.MediaDrm+IOnExpirationUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaDrm_OnExpirationUpdateListenerImplementor.class, __md_methods);
    }

    public MediaDrm_OnExpirationUpdateListenerImplementor() throws Throwable {
        if (getClass() == MediaDrm_OnExpirationUpdateListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaDrm+IOnExpirationUpdateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j) {
        n_onExpirationUpdate(mediaDrm, bArr, j);
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
