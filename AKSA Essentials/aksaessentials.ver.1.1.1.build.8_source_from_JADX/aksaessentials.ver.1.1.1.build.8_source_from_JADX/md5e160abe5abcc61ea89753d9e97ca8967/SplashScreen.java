package md5e160abe5abcc61ea89753d9e97ca8967;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SplashScreen extends Activity implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n";
    private ArrayList refList;

    private native void n_onCreate(Bundle bundle);

    static {
        Runtime.register("AKSAEssentials.Droid.SplashScreen, AKSAEssentials.Droid, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", SplashScreen.class, __md_methods);
    }

    public SplashScreen() throws Throwable {
        if (getClass() == SplashScreen.class) {
            TypeManager.Activate("AKSAEssentials.Droid.SplashScreen, AKSAEssentials.Droid, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
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
