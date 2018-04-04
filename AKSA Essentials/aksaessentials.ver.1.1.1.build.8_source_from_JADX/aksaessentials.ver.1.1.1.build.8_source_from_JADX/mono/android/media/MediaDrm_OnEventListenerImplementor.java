package mono.android.media;

import android.media.MediaDrm;
import android.media.MediaDrm.OnEventListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaDrm_OnEventListenerImplementor implements IGCUserPeer, OnEventListener {
    public static final String __md_methods = "n_onEvent:(Landroid/media/MediaDrm;[BII[B)V:GetOnEvent_Landroid_media_MediaDrm_arrayBIIarrayBHandler:Android.Media.MediaDrm/IOnEventListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2);

    static {
        Runtime.register("Android.Media.MediaDrm+IOnEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaDrm_OnEventListenerImplementor.class, __md_methods);
    }

    public MediaDrm_OnEventListenerImplementor() throws Throwable {
        if (getClass() == MediaDrm_OnEventListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaDrm+IOnEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        n_onEvent(mediaDrm, bArr, i, i2, bArr2);
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
