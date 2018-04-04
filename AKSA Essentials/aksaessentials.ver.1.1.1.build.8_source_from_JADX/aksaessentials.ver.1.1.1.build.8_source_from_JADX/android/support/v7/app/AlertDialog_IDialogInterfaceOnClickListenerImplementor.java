package android.support.v7.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AlertDialog_IDialogInterfaceOnClickListenerImplementor implements IGCUserPeer, OnClickListener {
    public static final String __md_methods = "n_onClick:(Landroid/content/DialogInterface;I)V:GetOnClick_Landroid_content_DialogInterface_IHandler:Android.Content.IDialogInterfaceOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onClick(DialogInterface dialogInterface, int i);

    static {
        Runtime.register("Android.Support.V7.App.AlertDialog+IDialogInterfaceOnClickListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", AlertDialog_IDialogInterfaceOnClickListenerImplementor.class, __md_methods);
    }

    public AlertDialog_IDialogInterfaceOnClickListenerImplementor() throws Throwable {
        if (getClass() == AlertDialog_IDialogInterfaceOnClickListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.App.AlertDialog+IDialogInterfaceOnClickListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        n_onClick(dialogInterface, i);
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
