package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GenericAnimatorListener extends AnimatorListenerAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_onAnimationCancel:(Landroid/animation/Animator;)V:GetOnAnimationCancel_Landroid_animation_Animator_Handler\nn_onAnimationEnd:(Landroid/animation/Animator;)V:GetOnAnimationEnd_Landroid_animation_Animator_Handler\nn_onAnimationRepeat:(Landroid/animation/Animator;)V:GetOnAnimationRepeat_Landroid_animation_Animator_Handler\nn_finalize:()V:GetJavaFinalizeHandler\n";
    private ArrayList refList;

    private native void n_finalize();

    private native void n_onAnimationCancel(Animator animator);

    private native void n_onAnimationEnd(Animator animator);

    private native void n_onAnimationRepeat(Animator animator);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.GenericAnimatorListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", GenericAnimatorListener.class, __md_methods);
    }

    public GenericAnimatorListener() throws Throwable {
        if (getClass() == GenericAnimatorListener.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.GenericAnimatorListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onAnimationCancel(Animator animator) {
        n_onAnimationCancel(animator);
    }

    public void onAnimationEnd(Animator animator) {
        n_onAnimationEnd(animator);
    }

    public void onAnimationRepeat(Animator animator) {
        n_onAnimationRepeat(animator);
    }

    public void finalize() {
        n_finalize();
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
