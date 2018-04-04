package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class EntryRenderer extends ViewRenderer_2 implements IGCUserPeer, TextWatcher, NoCopySpan, OnEditorActionListener {
    public static final String __md_methods = "n_afterTextChanged:(Landroid/text/Editable;)V:GetAfterTextChanged_Landroid_text_Editable_Handler:Android.Text.ITextWatcherInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_beforeTextChanged:(Ljava/lang/CharSequence;III)V:GetBeforeTextChanged_Ljava_lang_CharSequence_IIIHandler:Android.Text.ITextWatcherInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onTextChanged:(Ljava/lang/CharSequence;III)V:GetOnTextChanged_Ljava_lang_CharSequence_IIIHandler:Android.Text.ITextWatcherInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onEditorAction:(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z:GetOnEditorAction_Landroid_widget_TextView_ILandroid_view_KeyEvent_Handler:Android.Widget.TextView/IOnEditorActionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_afterTextChanged(Editable editable);

    private native void n_beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);

    private native boolean n_onEditorAction(TextView textView, int i, KeyEvent keyEvent);

    private native void n_onTextChanged(CharSequence charSequence, int i, int i2, int i3);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.EntryRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", EntryRenderer.class, __md_methods);
    }

    public EntryRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == EntryRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.EntryRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public EntryRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == EntryRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.EntryRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public EntryRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == EntryRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.EntryRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public void afterTextChanged(Editable editable) {
        n_afterTextChanged(editable);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        n_beforeTextChanged(charSequence, i, i2, i3);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        n_onTextChanged(charSequence, i, i2, i3);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return n_onEditorAction(textView, i, keyEvent);
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
