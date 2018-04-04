package mono.android.media;

import android.media.MediaDrm;
import android.media.MediaDrm.OnKeyStatusChangeListener;
import java.util.ArrayList;
import java.util.List;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaDrm_OnKeyStatusChangeListenerImplementor implements IGCUserPeer, OnKeyStatusChangeListener {
    public static final String __md_methods = "n_onKeyStatusChange:(Landroid/media/MediaDrm;[BLjava/util/List;Z)V:GetOnKeyStatusChange_Landroid_media_MediaDrm_arrayBLjava_util_List_ZHandler:Android.Media.MediaDrm/IOnKeyStatusChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z);

    static {
        Runtime.register("Android.Media.MediaDrm+IOnKeyStatusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaDrm_OnKeyStatusChangeListenerImplementor.class, __md_methods);
    }

    public MediaDrm_OnKeyStatusChangeListenerImplementor() throws Throwable {
        if (getClass() == MediaDrm_OnKeyStatusChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaDrm+IOnKeyStatusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
        n_onKeyStatusChange(mediaDrm, bArr, list, z);
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
