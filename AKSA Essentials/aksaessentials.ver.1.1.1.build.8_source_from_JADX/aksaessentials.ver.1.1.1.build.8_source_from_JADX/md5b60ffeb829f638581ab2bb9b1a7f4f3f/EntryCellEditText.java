package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class EntryCellEditText extends EditText implements IGCUserPeer {
    public static final String __md_methods = "n_onKeyPreIme:(ILandroid/view/KeyEvent;)Z:GetOnKeyPreIme_ILandroid_view_KeyEvent_Handler\nn_onFocusChanged:(ZILandroid/graphics/Rect;)V:GetOnFocusChanged_ZILandroid_graphics_Rect_Handler\n";
    private ArrayList refList;

    private native void n_onFocusChanged(boolean z, int i, Rect rect);

    private native boolean n_onKeyPreIme(int i, KeyEvent keyEvent);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.EntryCellEditText, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", EntryCellEditText.class, __md_methods);
    }

    public EntryCellEditText(Context context) throws Throwable {
        super(context);
        if (getClass() == EntryCellEditText.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.EntryCellEditText, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public EntryCellEditText(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == EntryCellEditText.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.EntryCellEditText, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public EntryCellEditText(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == EntryCellEditText.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.EntryCellEditText, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return n_onKeyPreIme(i, keyEvent);
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        n_onFocusChanged(z, i, rect);
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
