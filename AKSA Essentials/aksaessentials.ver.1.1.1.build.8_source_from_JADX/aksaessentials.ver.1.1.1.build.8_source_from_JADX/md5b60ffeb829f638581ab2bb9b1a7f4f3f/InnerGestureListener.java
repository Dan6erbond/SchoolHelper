package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class InnerGestureListener implements IGCUserPeer, OnGestureListener, OnDoubleTapListener {
    public static final String __md_methods = "n_onDown:(Landroid/view/MotionEvent;)Z:GetOnDown_Landroid_view_MotionEvent_Handler:Android.Views.GestureDetector/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onFling:(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z:GetOnFling_Landroid_view_MotionEvent_Landroid_view_MotionEvent_FFHandler:Android.Views.GestureDetector/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onLongPress:(Landroid/view/MotionEvent;)V:GetOnLongPress_Landroid_view_MotionEvent_Handler:Android.Views.GestureDetector/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onScroll:(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z:GetOnScroll_Landroid_view_MotionEvent_Landroid_view_MotionEvent_FFHandler:Android.Views.GestureDetector/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onShowPress:(Landroid/view/MotionEvent;)V:GetOnShowPress_Landroid_view_MotionEvent_Handler:Android.Views.GestureDetector/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSingleTapUp:(Landroid/view/MotionEvent;)Z:GetOnSingleTapUp_Landroid_view_MotionEvent_Handler:Android.Views.GestureDetector/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onDoubleTap:(Landroid/view/MotionEvent;)Z:GetOnDoubleTap_Landroid_view_MotionEvent_Handler:Android.Views.GestureDetector/IOnDoubleTapListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onDoubleTapEvent:(Landroid/view/MotionEvent;)Z:GetOnDoubleTapEvent_Landroid_view_MotionEvent_Handler:Android.Views.GestureDetector/IOnDoubleTapListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSingleTapConfirmed:(Landroid/view/MotionEvent;)Z:GetOnSingleTapConfirmed_Landroid_view_MotionEvent_Handler:Android.Views.GestureDetector/IOnDoubleTapListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onDoubleTap(MotionEvent motionEvent);

    private native boolean n_onDoubleTapEvent(MotionEvent motionEvent);

    private native boolean n_onDown(MotionEvent motionEvent);

    private native boolean n_onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    private native void n_onLongPress(MotionEvent motionEvent);

    private native boolean n_onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

    private native void n_onShowPress(MotionEvent motionEvent);

    private native boolean n_onSingleTapConfirmed(MotionEvent motionEvent);

    private native boolean n_onSingleTapUp(MotionEvent motionEvent);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.InnerGestureListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", InnerGestureListener.class, __md_methods);
    }

    public InnerGestureListener() throws Throwable {
        if (getClass() == InnerGestureListener.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.InnerGestureListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        return n_onDown(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return n_onFling(motionEvent, motionEvent2, f, f2);
    }

    public void onLongPress(MotionEvent motionEvent) {
        n_onLongPress(motionEvent);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return n_onScroll(motionEvent, motionEvent2, f, f2);
    }

    public void onShowPress(MotionEvent motionEvent) {
        n_onShowPress(motionEvent);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return n_onSingleTapUp(motionEvent);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        return n_onDoubleTap(motionEvent);
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return n_onDoubleTapEvent(motionEvent);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return n_onSingleTapConfirmed(motionEvent);
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
