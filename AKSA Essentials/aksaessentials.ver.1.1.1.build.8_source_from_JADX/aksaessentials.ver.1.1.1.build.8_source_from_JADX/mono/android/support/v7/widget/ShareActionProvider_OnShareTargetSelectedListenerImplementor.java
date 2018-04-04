package mono.android.support.v7.widget;

import android.content.Intent;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.ShareActionProvider.OnShareTargetSelectedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ShareActionProvider_OnShareTargetSelectedListenerImplementor implements IGCUserPeer, OnShareTargetSelectedListener {
    public static final String __md_methods = "n_onShareTargetSelected:(Landroid/support/v7/widget/ShareActionProvider;Landroid/content/Intent;)Z:GetOnShareTargetSelected_Landroid_support_v7_widget_ShareActionProvider_Landroid_content_Intent_Handler:Android.Support.V7.Widget.ShareActionProvider/IOnShareTargetSelectedListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native boolean n_onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);

    static {
        Runtime.register("Android.Support.V7.Widget.ShareActionProvider+IOnShareTargetSelectedListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ShareActionProvider_OnShareTargetSelectedListenerImplementor.class, __md_methods);
    }

    public ShareActionProvider_OnShareTargetSelectedListenerImplementor() throws Throwable {
        if (getClass() == ShareActionProvider_OnShareTargetSelectedListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.ShareActionProvider+IOnShareTargetSelectedListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent) {
        return n_onShareTargetSelected(shareActionProvider, intent);
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
