package mono.android.view;

import android.view.View;
import android.view.View.OnScrollChangeListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnScrollChangeListenerImplementor implements IGCUserPeer, OnScrollChangeListener {
    public static final String __md_methods = "n_onScrollChange:(Landroid/view/View;IIII)V:GetOnScrollChange_Landroid_view_View_IIIIHandler:Android.Views.View/IOnScrollChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onScrollChange(View view, int i, int i2, int i3, int i4);

    static {
        Runtime.register("Android.Views.View+IOnScrollChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnScrollChangeListenerImplementor.class, __md_methods);
    }

    public View_OnScrollChangeListenerImplementor() throws Throwable {
        if (getClass() == View_OnScrollChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnScrollChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onScrollChange(View view, int i, int i2, int i3, int i4) {
        n_onScrollChange(view, i, i2, i3, i4);
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
