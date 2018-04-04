package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AndroidActivity extends FormsApplicationActivity implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AndroidActivity, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", AndroidActivity.class, __md_methods);
    }

    public AndroidActivity() throws Throwable {
        if (getClass() == AndroidActivity.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AndroidActivity, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
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
