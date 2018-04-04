package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NavigationMenuRenderer_MenuAdapter extends BaseAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getItem:(I)Ljava/lang/Object;:GetGetItem_IHandler\nn_getView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\nn_getItemId:(I)J:GetGetItemId_IHandler\nn_getCount:()I:GetGetCountHandler\n";
    private ArrayList refList;

    private native int n_getCount();

    private native Object n_getItem(int i);

    private native long n_getItemId(int i);

    private native View n_getView(int i, View view, ViewGroup viewGroup);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.NavigationMenuRenderer+MenuAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", NavigationMenuRenderer_MenuAdapter.class, __md_methods);
    }

    public NavigationMenuRenderer_MenuAdapter() throws Throwable {
        if (getClass() == NavigationMenuRenderer_MenuAdapter.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.NavigationMenuRenderer+MenuAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public Object getItem(int i) {
        return n_getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return n_getView(i, view, viewGroup);
    }

    public long getItemId(int i) {
        return n_getItemId(i);
    }

    public int getCount() {
        return n_getCount();
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
