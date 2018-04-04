package mono.android.media;

import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ImageReader_OnImageAvailableListenerImplementor implements IGCUserPeer, OnImageAvailableListener {
    public static final String __md_methods = "n_onImageAvailable:(Landroid/media/ImageReader;)V:GetOnImageAvailable_Landroid_media_ImageReader_Handler:Android.Media.ImageReader/IOnImageAvailableListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onImageAvailable(ImageReader imageReader);

    static {
        Runtime.register("Android.Media.ImageReader+IOnImageAvailableListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ImageReader_OnImageAvailableListenerImplementor.class, __md_methods);
    }

    public ImageReader_OnImageAvailableListenerImplementor() throws Throwable {
        if (getClass() == ImageReader_OnImageAvailableListenerImplementor.class) {
            TypeManager.Activate("Android.Media.ImageReader+IOnImageAvailableListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onImageAvailable(ImageReader imageReader) {
        n_onImageAvailable(imageReader);
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
