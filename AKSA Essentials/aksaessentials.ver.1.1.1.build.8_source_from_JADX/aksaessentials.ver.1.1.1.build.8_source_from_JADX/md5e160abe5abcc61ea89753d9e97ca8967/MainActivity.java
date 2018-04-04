package md5e160abe5abcc61ea89753d9e97ca8967;

import android.os.Bundle;
import java.util.ArrayList;
import md5b60ffeb829f638581ab2bb9b1a7f4f3f.FormsApplicationActivity;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MainActivity extends FormsApplicationActivity implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onResume:()V:GetOnResumeHandler\n";
    private ArrayList refList;

    private native void n_onCreate(Bundle bundle);

    private native void n_onResume();

    static {
        Runtime.register("AKSAEssentials.Droid.MainActivity, AKSAEssentials.Droid, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", MainActivity.class, __md_methods);
    }

    public MainActivity() throws Throwable {
        if (getClass() == MainActivity.class) {
            TypeManager.Activate("AKSAEssentials.Droid.MainActivity, AKSAEssentials.Droid, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
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
