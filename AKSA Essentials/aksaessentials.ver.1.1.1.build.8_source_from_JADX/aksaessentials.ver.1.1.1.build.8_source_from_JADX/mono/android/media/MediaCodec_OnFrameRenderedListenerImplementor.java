package mono.android.media;

import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MediaCodec_OnFrameRenderedListenerImplementor implements IGCUserPeer, OnFrameRenderedListener {
    public static final String __md_methods = "n_onFrameRendered:(Landroid/media/MediaCodec;JJ)V:GetOnFrameRendered_Landroid_media_MediaCodec_JJHandler:Android.Media.MediaCodec/IOnFrameRenderedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onFrameRendered(MediaCodec mediaCodec, long j, long j2);

    static {
        Runtime.register("Android.Media.MediaCodec+IOnFrameRenderedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MediaCodec_OnFrameRenderedListenerImplementor.class, __md_methods);
    }

    public MediaCodec_OnFrameRenderedListenerImplementor() throws Throwable {
        if (getClass() == MediaCodec_OnFrameRenderedListenerImplementor.class) {
            TypeManager.Activate("Android.Media.MediaCodec+IOnFrameRenderedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        n_onFrameRendered(mediaCodec, j, j2);
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
