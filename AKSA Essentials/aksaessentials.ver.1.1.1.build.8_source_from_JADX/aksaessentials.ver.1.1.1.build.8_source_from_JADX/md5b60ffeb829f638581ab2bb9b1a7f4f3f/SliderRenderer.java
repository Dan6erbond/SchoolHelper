package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SliderRenderer extends ViewRenderer_2 implements IGCUserPeer, OnSeekBarChangeListener {
    public static final String __md_methods = "n_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onProgressChanged:(Landroid/widget/SeekBar;IZ)V:GetOnProgressChanged_Landroid_widget_SeekBar_IZHandler:Android.Widget.SeekBar/IOnSeekBarChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onStartTrackingTouch:(Landroid/widget/SeekBar;)V:GetOnStartTrackingTouch_Landroid_widget_SeekBar_Handler:Android.Widget.SeekBar/IOnSeekBarChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onStopTrackingTouch:(Landroid/widget/SeekBar;)V:GetOnStopTrackingTouch_Landroid_widget_SeekBar_Handler:Android.Widget.SeekBar/IOnSeekBarChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onProgressChanged(SeekBar seekBar, int i, boolean z);

    private native void n_onStartTrackingTouch(SeekBar seekBar);

    private native void n_onStopTrackingTouch(SeekBar seekBar);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.SliderRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", SliderRenderer.class, __md_methods);
    }

    public SliderRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == SliderRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.SliderRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public SliderRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == SliderRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.SliderRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public SliderRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == SliderRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.SliderRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        n_onProgressChanged(seekBar, i, z);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        n_onStartTrackingTouch(seekBar);
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        n_onStopTrackingTouch(seekBar);
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
