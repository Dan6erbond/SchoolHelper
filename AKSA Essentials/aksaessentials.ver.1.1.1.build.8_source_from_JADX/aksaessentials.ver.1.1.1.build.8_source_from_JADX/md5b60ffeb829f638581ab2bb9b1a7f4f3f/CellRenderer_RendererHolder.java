package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class CellRenderer_RendererHolder implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.CellRenderer+RendererHolder, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", CellRenderer_RendererHolder.class, __md_methods);
    }

    public CellRenderer_RendererHolder() throws Throwable {
        if (getClass() == CellRenderer_RendererHolder.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.CellRenderer+RendererHolder, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
