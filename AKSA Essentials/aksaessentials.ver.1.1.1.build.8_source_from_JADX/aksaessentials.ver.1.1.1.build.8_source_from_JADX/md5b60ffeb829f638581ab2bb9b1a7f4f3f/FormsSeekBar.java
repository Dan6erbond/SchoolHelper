package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FormsSeekBar extends SeekBar implements IGCUserPeer {
    public static final String __md_methods = "n_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\nn_isPressed:()Z:GetIsPressedHandler\nn_setPressed:(Z)V:GetSetPressed_ZHandler\n";
    private ArrayList refList;

    private native boolean n_isPressed();

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    private native void n_setPressed(boolean z);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.FormsSeekBar, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FormsSeekBar.class, __md_methods);
    }

    public FormsSeekBar(Context context) throws Throwable {
        super(context);
        if (getClass() == FormsSeekBar.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormsSeekBar, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public FormsSeekBar(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == FormsSeekBar.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormsSeekBar, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public FormsSeekBar(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == FormsSeekBar.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormsSeekBar, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
    }

    public boolean isPressed() {
        return n_isPressed();
    }

    public void setPressed(boolean z) {
        n_setPressed(z);
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
