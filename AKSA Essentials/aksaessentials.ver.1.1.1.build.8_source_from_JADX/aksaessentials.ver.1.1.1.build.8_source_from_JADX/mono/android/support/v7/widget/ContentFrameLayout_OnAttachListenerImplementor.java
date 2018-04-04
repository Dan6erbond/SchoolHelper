package mono.android.support.v7.widget;

import android.support.v7.widget.ContentFrameLayout.OnAttachListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ContentFrameLayout_OnAttachListenerImplementor implements IGCUserPeer, OnAttachListener {
    public static final String __md_methods = "n_onAttachedFromWindow:()V:GetOnAttachedFromWindowHandler:Android.Support.V7.Widget.ContentFrameLayout/IOnAttachListenerInvoker, Xamarin.Android.Support.v7.AppCompat\nn_onDetachedFromWindow:()V:GetOnDetachedFromWindowHandler:Android.Support.V7.Widget.ContentFrameLayout/IOnAttachListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native void n_onAttachedFromWindow();

    private native void n_onDetachedFromWindow();

    static {
        Runtime.register("Android.Support.V7.Widget.ContentFrameLayout+IOnAttachListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ContentFrameLayout_OnAttachListenerImplementor.class, __md_methods);
    }

    public ContentFrameLayout_OnAttachListenerImplementor() throws Throwable {
        if (getClass() == ContentFrameLayout_OnAttachListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.Widget.ContentFrameLayout+IOnAttachListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onAttachedFromWindow() {
        n_onAttachedFromWindow();
    }

    public void onDetachedFromWindow() {
        n_onDetachedFromWindow();
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
