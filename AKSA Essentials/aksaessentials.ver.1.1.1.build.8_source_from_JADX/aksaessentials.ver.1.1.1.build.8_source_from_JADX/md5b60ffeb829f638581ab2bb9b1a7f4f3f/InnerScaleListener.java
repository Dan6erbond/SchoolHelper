package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class InnerScaleListener extends SimpleOnScaleGestureListener implements IGCUserPeer {
    public static final String __md_methods = "n_onScale:(Landroid/view/ScaleGestureDetector;)Z:GetOnScale_Landroid_view_ScaleGestureDetector_Handler\nn_onScaleBegin:(Landroid/view/ScaleGestureDetector;)Z:GetOnScaleBegin_Landroid_view_ScaleGestureDetector_Handler\nn_onScaleEnd:(Landroid/view/ScaleGestureDetector;)V:GetOnScaleEnd_Landroid_view_ScaleGestureDetector_Handler\n";
    private ArrayList refList;

    private native boolean n_onScale(ScaleGestureDetector scaleGestureDetector);

    private native boolean n_onScaleBegin(ScaleGestureDetector scaleGestureDetector);

    private native void n_onScaleEnd(ScaleGestureDetector scaleGestureDetector);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.InnerScaleListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", InnerScaleListener.class, __md_methods);
    }

    public InnerScaleListener() throws Throwable {
        if (getClass() == InnerScaleListener.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.InnerScaleListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return n_onScale(scaleGestureDetector);
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return n_onScaleBegin(scaleGestureDetector);
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        n_onScaleEnd(scaleGestureDetector);
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
