package android.support.v7.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AlertDialog_IDialogInterfaceOnCancelListenerImplementor implements IGCUserPeer, OnCancelListener {
    public static final String __md_methods = "n_onCancel:(Landroid/content/DialogInterface;)V:GetOnCancel_Landroid_content_DialogInterface_Handler:Android.Content.IDialogInterfaceOnCancelListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onCancel(DialogInterface dialogInterface);

    static {
        Runtime.register("Android.Support.V7.App.AlertDialog+IDialogInterfaceOnCancelListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", AlertDialog_IDialogInterfaceOnCancelListenerImplementor.class, __md_methods);
    }

    public AlertDialog_IDialogInterfaceOnCancelListenerImplementor() throws Throwable {
        if (getClass() == AlertDialog_IDialogInterfaceOnCancelListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.App.AlertDialog+IDialogInterfaceOnCancelListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        n_onCancel(dialogInterface);
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
