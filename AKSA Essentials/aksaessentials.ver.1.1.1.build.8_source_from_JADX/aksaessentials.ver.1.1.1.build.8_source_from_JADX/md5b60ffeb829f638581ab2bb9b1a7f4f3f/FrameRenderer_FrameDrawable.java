package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FrameRenderer_FrameDrawable extends Drawable implements IGCUserPeer {
    public static final String __md_methods = "n_isStateful:()Z:GetIsStatefulHandler\nn_getOpacity:()I:GetGetOpacityHandler\nn_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\nn_setAlpha:(I)V:GetSetAlpha_IHandler\nn_setColorFilter:(Landroid/graphics/ColorFilter;)V:GetSetColorFilter_Landroid_graphics_ColorFilter_Handler\nn_onStateChange:([I)Z:GetOnStateChange_arrayIHandler\n";
    private ArrayList refList;

    private native void n_draw(Canvas canvas);

    private native int n_getOpacity();

    private native boolean n_isStateful();

    private native boolean n_onStateChange(int[] iArr);

    private native void n_setAlpha(int i);

    private native void n_setColorFilter(ColorFilter colorFilter);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.FrameRenderer+FrameDrawable, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FrameRenderer_FrameDrawable.class, __md_methods);
    }

    public FrameRenderer_FrameDrawable() throws Throwable {
        if (getClass() == FrameRenderer_FrameDrawable.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FrameRenderer+FrameDrawable, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean isStateful() {
        return n_isStateful();
    }

    public int getOpacity() {
        return n_getOpacity();
    }

    public void draw(Canvas canvas) {
        n_draw(canvas);
    }

    public void setAlpha(int i) {
        n_setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        n_setColorFilter(colorFilter);
    }

    public boolean onStateChange(int[] iArr) {
        return n_onStateChange(iArr);
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
