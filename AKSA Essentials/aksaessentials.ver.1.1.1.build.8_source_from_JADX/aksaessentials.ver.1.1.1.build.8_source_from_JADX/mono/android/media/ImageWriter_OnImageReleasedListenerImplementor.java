package mono.android.media;

import android.media.ImageWriter;
import android.media.ImageWriter.OnImageReleasedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ImageWriter_OnImageReleasedListenerImplementor implements IGCUserPeer, OnImageReleasedListener {
    public static final String __md_methods = "n_onImageReleased:(Landroid/media/ImageWriter;)V:GetOnImageReleased_Landroid_media_ImageWriter_Handler:Android.Media.ImageWriter/IOnImageReleasedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onImageReleased(ImageWriter imageWriter);

    static {
        Runtime.register("Android.Media.ImageWriter+IOnImageReleasedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ImageWriter_OnImageReleasedListenerImplementor.class, __md_methods);
    }

    public ImageWriter_OnImageReleasedListenerImplementor() throws Throwable {
        if (getClass() == ImageWriter_OnImageReleasedListenerImplementor.class) {
            TypeManager.Activate("Android.Media.ImageWriter+IOnImageReleasedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onImageReleased(ImageWriter imageWriter) {
        n_onImageReleased(imageWriter);
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
