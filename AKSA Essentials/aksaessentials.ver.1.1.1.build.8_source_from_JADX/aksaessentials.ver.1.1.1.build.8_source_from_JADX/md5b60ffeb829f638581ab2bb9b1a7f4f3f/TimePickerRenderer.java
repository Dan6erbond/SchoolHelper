package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TimePicker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TimePickerRenderer extends ViewRenderer_2 implements IGCUserPeer, OnTimeSetListener {
    public static final String __md_methods = "n_onTimeSet:(Landroid/widget/TimePicker;II)V:GetOnTimeSet_Landroid_widget_TimePicker_IIHandler:Android.App.TimePickerDialog/IOnTimeSetListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTimeSet(TimePicker timePicker, int i, int i2);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.TimePickerRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", TimePickerRenderer.class, __md_methods);
    }

    public TimePickerRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == TimePickerRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.TimePickerRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public TimePickerRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == TimePickerRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.TimePickerRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public TimePickerRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == TimePickerRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.TimePickerRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        n_onTimeSet(timePicker, i, i2);
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
