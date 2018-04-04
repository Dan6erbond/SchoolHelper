package mono.android.support.design.widget;

import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TabLayout_OnTabSelectedListenerImplementor implements IGCUserPeer, OnTabSelectedListener {
    public static final String __md_methods = "n_onTabReselected:(Landroid/support/design/widget/TabLayout$Tab;)V:GetOnTabReselected_Landroid_support_design_widget_TabLayout_Tab_Handler:Android.Support.Design.Widget.TabLayout/IOnTabSelectedListenerInvoker, Xamarin.Android.Support.Design\nn_onTabSelected:(Landroid/support/design/widget/TabLayout$Tab;)V:GetOnTabSelected_Landroid_support_design_widget_TabLayout_Tab_Handler:Android.Support.Design.Widget.TabLayout/IOnTabSelectedListenerInvoker, Xamarin.Android.Support.Design\nn_onTabUnselected:(Landroid/support/design/widget/TabLayout$Tab;)V:GetOnTabUnselected_Landroid_support_design_widget_TabLayout_Tab_Handler:Android.Support.Design.Widget.TabLayout/IOnTabSelectedListenerInvoker, Xamarin.Android.Support.Design\n";
    private ArrayList refList;

    private native void n_onTabReselected(Tab tab);

    private native void n_onTabSelected(Tab tab);

    private native void n_onTabUnselected(Tab tab);

    static {
        Runtime.register("Android.Support.Design.Widget.TabLayout+IOnTabSelectedListenerImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", TabLayout_OnTabSelectedListenerImplementor.class, __md_methods);
    }

    public TabLayout_OnTabSelectedListenerImplementor() throws Throwable {
        if (getClass() == TabLayout_OnTabSelectedListenerImplementor.class) {
            TypeManager.Activate("Android.Support.Design.Widget.TabLayout+IOnTabSelectedListenerImplementor, Xamarin.Android.Support.Design, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onTabReselected(Tab tab) {
        n_onTabReselected(tab);
    }

    public void onTabSelected(Tab tab) {
        n_onTabSelected(tab);
    }

    public void onTabUnselected(Tab tab) {
        n_onTabUnselected(tab);
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
