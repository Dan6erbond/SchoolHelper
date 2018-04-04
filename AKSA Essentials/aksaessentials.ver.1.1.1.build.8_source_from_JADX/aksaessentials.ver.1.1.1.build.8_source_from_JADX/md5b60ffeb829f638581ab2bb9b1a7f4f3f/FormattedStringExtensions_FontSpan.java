package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FormattedStringExtensions_FontSpan extends MetricAffectingSpan implements IGCUserPeer {
    public static final String __md_methods = "n_updateDrawState:(Landroid/text/TextPaint;)V:GetUpdateDrawState_Landroid_text_TextPaint_Handler\nn_updateMeasureState:(Landroid/text/TextPaint;)V:GetUpdateMeasureState_Landroid_text_TextPaint_Handler\n";
    private ArrayList refList;

    private native void n_updateDrawState(TextPaint textPaint);

    private native void n_updateMeasureState(TextPaint textPaint);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.FormattedStringExtensions+FontSpan, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FormattedStringExtensions_FontSpan.class, __md_methods);
    }

    public FormattedStringExtensions_FontSpan() throws Throwable {
        if (getClass() == FormattedStringExtensions_FontSpan.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormattedStringExtensions+FontSpan, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        n_updateDrawState(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        n_updateMeasureState(textPaint);
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
