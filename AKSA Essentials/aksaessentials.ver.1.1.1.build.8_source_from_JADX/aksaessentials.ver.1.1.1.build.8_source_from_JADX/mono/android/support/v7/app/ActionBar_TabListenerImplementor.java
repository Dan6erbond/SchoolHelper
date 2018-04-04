package mono.android.support.v7.app;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionBar_TabListenerImplementor implements IGCUserPeer, TabListener {
    public static final String __md_methods = "n_onTabReselected:(Landroid/support/v7/app/ActionBar$Tab;Landroid/support/v4/app/FragmentTransaction;)V:GetOnTabReselected_Landroid_support_v7_app_ActionBar_Tab_Landroid_support_v4_app_FragmentTransaction_Handler:Android.Support.V7.App.ActionBar/ITabListenerInvoker, Xamarin.Android.Support.v7.AppCompat\nn_onTabSelected:(Landroid/support/v7/app/ActionBar$Tab;Landroid/support/v4/app/FragmentTransaction;)V:GetOnTabSelected_Landroid_support_v7_app_ActionBar_Tab_Landroid_support_v4_app_FragmentTransaction_Handler:Android.Support.V7.App.ActionBar/ITabListenerInvoker, Xamarin.Android.Support.v7.AppCompat\nn_onTabUnselected:(Landroid/support/v7/app/ActionBar$Tab;Landroid/support/v4/app/FragmentTransaction;)V:GetOnTabUnselected_Landroid_support_v7_app_ActionBar_Tab_Landroid_support_v4_app_FragmentTransaction_Handler:Android.Support.V7.App.ActionBar/ITabListenerInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native void n_onTabReselected(Tab tab, FragmentTransaction fragmentTransaction);

    private native void n_onTabSelected(Tab tab, FragmentTransaction fragmentTransaction);

    private native void n_onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction);

    static {
        Runtime.register("Android.Support.V7.App.ActionBar+ITabListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ActionBar_TabListenerImplementor.class, __md_methods);
    }

    public ActionBar_TabListenerImplementor() throws Throwable {
        if (getClass() == ActionBar_TabListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V7.App.ActionBar+ITabListenerImplementor, Xamarin.Android.Support.v7.AppCompat, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
        n_onTabReselected(tab, fragmentTransaction);
    }

    public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
        n_onTabSelected(tab, fragmentTransaction);
    }

    public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
        n_onTabUnselected(tab, fragmentTransaction);
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
