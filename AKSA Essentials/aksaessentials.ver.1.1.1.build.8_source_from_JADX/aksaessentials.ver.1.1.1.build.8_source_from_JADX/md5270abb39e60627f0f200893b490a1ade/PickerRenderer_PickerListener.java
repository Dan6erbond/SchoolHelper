package md5270abb39e60627f0f200893b490a1ade;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PickerRenderer_PickerListener implements IGCUserPeer, OnClickListener {
    public static final String __md_methods = "n_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler:Android.Views.View/IOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onClick(View view);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AppCompat.PickerRenderer+PickerListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", PickerRenderer_PickerListener.class, __md_methods);
    }

    public PickerRenderer_PickerListener() throws Throwable {
        if (getClass() == PickerRenderer_PickerListener.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.PickerRenderer+PickerListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
