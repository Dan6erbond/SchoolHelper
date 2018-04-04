package mono.android.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorPauseListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Animator_AnimatorPauseListenerImplementor implements IGCUserPeer, AnimatorPauseListener {
    public static final String __md_methods = "n_onAnimationPause:(Landroid/animation/Animator;)V:GetOnAnimationPause_Landroid_animation_Animator_Handler:Android.Animation.Animator/IAnimatorPauseListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onAnimationResume:(Landroid/animation/Animator;)V:GetOnAnimationResume_Landroid_animation_Animator_Handler:Android.Animation.Animator/IAnimatorPauseListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAnimationPause(Animator animator);

    private native void n_onAnimationResume(Animator animator);

    static {
        Runtime.register("Android.Animation.Animator+IAnimatorPauseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Animator_AnimatorPauseListenerImplementor.class, __md_methods);
    }

    public Animator_AnimatorPauseListenerImplementor() throws Throwable {
        if (getClass() == Animator_AnimatorPauseListenerImplementor.class) {
            TypeManager.Activate("Android.Animation.Animator+IAnimatorPauseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onAnimationPause(Animator animator) {
        n_onAnimationPause(animator);
    }

    public void onAnimationResume(Animator animator) {
        n_onAnimationResume(animator);
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
