package mono.android.support.design.widget;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AppBarLayout_OnOffsetChangedListenerImplementor implements IGCUserPeer, OnOffsetChangedListener {
    public static final String __md_methods = "n_onOffsetChanged:(Landroid/support/design/widget/AppBarLayout;I)V:GetOnOffsetChanged_Landroid_support_design_widget_AppBarLayout_IHandler:Android.Support.Design.Widget.AppBarLayout/IOnOffsetChangedListenerInvoker, Xamarin.Android.Support.Design\n";
    private ArrayList refList;

    private native void n_onOffsetChanged(AppBarLayout appBarLayout, int i);

    static {
        Runtime.register("Android.Support.Design.Widget.AppBarLayout+IOnOffsetChangedListenerImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", AppBarLayout_OnOffsetChangedListenerImplementor.class, __md_methods);
    }

    public AppBarLayout_OnOffsetChangedListenerImplementor() throws Throwable {
        if (getClass() == AppBarLayout_OnOffsetChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Support.Design.Widget.AppBarLayout+IOnOffsetChangedListenerImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        n_onOffsetChanged(appBarLayout, i);
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
