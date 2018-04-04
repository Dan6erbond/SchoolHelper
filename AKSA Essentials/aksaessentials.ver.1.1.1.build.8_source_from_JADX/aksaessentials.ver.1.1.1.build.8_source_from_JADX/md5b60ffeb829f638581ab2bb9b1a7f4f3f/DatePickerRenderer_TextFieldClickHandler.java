package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class DatePickerRenderer_TextFieldClickHandler implements IGCUserPeer, OnClickListener {
    public static final String __md_methods = "n_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler:Android.Views.View/IOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onClick(View view);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.DatePickerRenderer+TextFieldClickHandler, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", DatePickerRenderer_TextFieldClickHandler.class, __md_methods);
    }

    public DatePickerRenderer_TextFieldClickHandler() throws Throwable {
        if (getClass() == DatePickerRenderer_TextFieldClickHandler.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.DatePickerRenderer+TextFieldClickHandler, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onClick(View view) {
        n_onClick(view);
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
