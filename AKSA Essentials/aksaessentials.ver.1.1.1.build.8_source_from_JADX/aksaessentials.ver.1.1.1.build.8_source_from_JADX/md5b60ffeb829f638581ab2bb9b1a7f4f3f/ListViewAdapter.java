package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ListViewAdapter extends CellAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getCount:()I:GetGetCountHandler\nn_hasStableIds:()Z:GetHasStableIdsHandler\nn_getItem:(I)Ljava/lang/Object;:GetGetItem_IHandler\nn_getViewTypeCount:()I:GetGetViewTypeCountHandler\nn_areAllItemsEnabled:()Z:GetAreAllItemsEnabledHandler\nn_getItemId:(I)J:GetGetItemId_IHandler\nn_getItemViewType:(I)I:GetGetItemViewType_IHandler\nn_getView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\nn_isEnabled:(I)Z:GetIsEnabled_IHandler\n";
    private ArrayList refList;

    private native boolean n_areAllItemsEnabled();

    private native int n_getCount();

    private native Object n_getItem(int i);

    private native long n_getItemId(int i);

    private native int n_getItemViewType(int i);

    private native View n_getView(int i, View view, ViewGroup viewGroup);

    private native int n_getViewTypeCount();

    private native boolean n_hasStableIds();

    private native boolean n_isEnabled(int i);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.ListViewAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", ListViewAdapter.class, __md_methods);
    }

    public ListViewAdapter() throws Throwable {
        if (getClass() == ListViewAdapter.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.ListViewAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public ListViewAdapter(Context context) throws Throwable {
        if (getClass() == ListViewAdapter.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.ListViewAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public int getCount() {
        return n_getCount();
    }

    public boolean hasStableIds() {
        return n_hasStableIds();
    }

    public Object getItem(int i) {
        return n_getItem(i);
    }

    public int getViewTypeCount() {
        return n_getViewTypeCount();
    }

    public boolean areAllItemsEnabled() {
        return n_areAllItemsEnabled();
    }

    public long getItemId(int i) {
        return n_getItemId(i);
    }

    public int getItemViewType(int i) {
        return n_getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return n_getView(i, view, viewGroup);
    }

    public boolean isEnabled(int i) {
        return n_isEnabled(i);
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
