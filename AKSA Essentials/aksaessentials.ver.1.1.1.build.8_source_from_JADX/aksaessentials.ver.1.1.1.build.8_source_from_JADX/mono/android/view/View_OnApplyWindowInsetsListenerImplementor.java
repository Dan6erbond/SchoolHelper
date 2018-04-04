package mono.android.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnApplyWindowInsetsListenerImplementor implements IGCUserPeer, OnApplyWindowInsetsListener {
    public static final String __md_methods = "n_onApplyWindowInsets:(Landroid/view/View;Landroid/view/WindowInsets;)Landroid/view/WindowInsets;:GetOnApplyWindowInsets_Landroid_view_View_Landroid_view_WindowInsets_Handler:Android.Views.View/IOnApplyWindowInsetsListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native WindowInsets n_onApplyWindowInsets(View view, WindowInsets windowInsets);

    static {
        Runtime.register("Android.Views.View+IOnApplyWindowInsetsListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnApplyWindowInsetsListenerImplementor.class, __md_methods);
    }

    public View_OnApplyWindowInsetsListenerImplementor() throws Throwable {
        if (getClass() == View_OnApplyWindowInsetsListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnApplyWindowInsetsListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return n_onApplyWindowInsets(view, windowInsets);
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
