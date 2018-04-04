package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Snackbar_SnackbarActionClickImplementor implements IGCUserPeer, OnClickListener {
    public static final String __md_methods = "n_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler:Android.Views.View/IOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onClick(View view);

    static {
        Runtime.register("Android.Support.Design.Widget.Snackbar+SnackbarActionClickImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", Snackbar_SnackbarActionClickImplementor.class, __md_methods);
    }

    public Snackbar_SnackbarActionClickImplementor() throws Throwable {
        if (getClass() == Snackbar_SnackbarActionClickImplementor.class) {
            TypeManager.Activate("Android.Support.Design.Widget.Snackbar+SnackbarActionClickImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
