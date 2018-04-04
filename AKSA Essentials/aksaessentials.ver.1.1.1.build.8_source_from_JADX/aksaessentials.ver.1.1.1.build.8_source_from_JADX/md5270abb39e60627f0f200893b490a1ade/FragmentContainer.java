package md5270abb39e60627f0f200893b490a1ade;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FragmentContainer extends Fragment implements IGCUserPeer {
    public static final String __md_methods = "n_getUserVisibleHint:()Z:GetGetUserVisibleHintHandler\nn_setUserVisibleHint:(Z)V:GetSetUserVisibleHint_ZHandler\nn_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\nn_onDestroyView:()V:GetOnDestroyViewHandler\nn_onHiddenChanged:(Z)V:GetOnHiddenChanged_ZHandler\nn_onPause:()V:GetOnPauseHandler\nn_onResume:()V:GetOnResumeHandler\n";
    private ArrayList refList;

    private native boolean n_getUserVisibleHint();

    private native View n_onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    private native void n_onDestroyView();

    private native void n_onHiddenChanged(boolean z);

    private native void n_onPause();

    private native void n_onResume();

    private native void n_setUserVisibleHint(boolean z);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AppCompat.FragmentContainer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FragmentContainer.class, __md_methods);
    }

    public FragmentContainer() throws Throwable {
        if (getClass() == FragmentContainer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.FragmentContainer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean getUserVisibleHint() {
        return n_getUserVisibleHint();
    }

    public void setUserVisibleHint(boolean z) {
        n_setUserVisibleHint(z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return n_onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        n_onDestroyView();
    }

    public void onHiddenChanged(boolean z) {
        n_onHiddenChanged(z);
    }

    public void onPause() {
        n_onPause();
    }

    public void onResume() {
        n_onResume();
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
