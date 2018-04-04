package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionSheetRenderer extends Dialog implements IGCUserPeer, OnClickListener {
    public static final String __md_methods = "n_cancel:()V:GetCancelHandler\nn_onAttachedToWindow:()V:GetOnAttachedToWindowHandler\nn_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler:Android.Views.View/IOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_cancel();

    private native void n_onAttachedToWindow();

    private native void n_onClick(View view);

    private native void n_onCreate(Bundle bundle);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.ActionSheetRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", ActionSheetRenderer.class, __md_methods);
    }

    public ActionSheetRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == ActionSheetRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.ActionSheetRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public void cancel() {
        n_cancel();
    }

    public void onAttachedToWindow() {
        n_onAttachedToWindow();
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
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
