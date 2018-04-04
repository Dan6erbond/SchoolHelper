package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.support.v7.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public abstract class CellAdapter extends BaseAdapter implements IGCUserPeer, OnItemLongClickListener, Callback, OnItemClickListener, ActionMode.Callback {
    public static final String __md_methods = "n_onItemLongClick:(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z:GetOnItemLongClick_Landroid_widget_AdapterView_Landroid_view_View_IJHandler:Android.Widget.AdapterView/IOnItemLongClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onActionItemClicked:(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z:GetOnActionItemClicked_Landroid_view_ActionMode_Landroid_view_MenuItem_Handler:Android.Views.ActionMode/ICallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onCreateActionMode:(Landroid/view/ActionMode;Landroid/view/Menu;)Z:GetOnCreateActionMode_Landroid_view_ActionMode_Landroid_view_Menu_Handler:Android.Views.ActionMode/ICallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onDestroyActionMode:(Landroid/view/ActionMode;)V:GetOnDestroyActionMode_Landroid_view_ActionMode_Handler:Android.Views.ActionMode/ICallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onPrepareActionMode:(Landroid/view/ActionMode;Landroid/view/Menu;)Z:GetOnPrepareActionMode_Landroid_view_ActionMode_Landroid_view_Menu_Handler:Android.Views.ActionMode/ICallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onItemClick:(Landroid/widget/AdapterView;Landroid/view/View;IJ)V:GetOnItemClick_Landroid_widget_AdapterView_Landroid_view_View_IJHandler:Android.Widget.AdapterView/IOnItemClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onActionItemClicked:(Landroid/support/v7/view/ActionMode;Landroid/view/MenuItem;)Z:GetOnActionItemClicked_Landroid_support_v7_view_ActionMode_Landroid_view_MenuItem_Handler:Android.Support.V7.View.ActionMode/ICallbackInvoker, Xamarin.Android.Support.v7.AppCompat\nn_onCreateActionMode:(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z:GetOnCreateActionMode_Landroid_support_v7_view_ActionMode_Landroid_view_Menu_Handler:Android.Support.V7.View.ActionMode/ICallbackInvoker, Xamarin.Android.Support.v7.AppCompat\nn_onDestroyActionMode:(Landroid/support/v7/view/ActionMode;)V:GetOnDestroyActionMode_Landroid_support_v7_view_ActionMode_Handler:Android.Support.V7.View.ActionMode/ICallbackInvoker, Xamarin.Android.Support.v7.AppCompat\nn_onPrepareActionMode:(Landroid/support/v7/view/ActionMode;Landroid/view/Menu;)Z:GetOnPrepareActionMode_Landroid_support_v7_view_ActionMode_Landroid_view_Menu_Handler:Android.Support.V7.View.ActionMode/ICallbackInvoker, Xamarin.Android.Support.v7.AppCompat\n";
    private ArrayList refList;

    private native boolean n_onActionItemClicked(ActionMode actionMode, MenuItem menuItem);

    private native boolean n_onActionItemClicked(android.view.ActionMode actionMode, MenuItem menuItem);

    private native boolean n_onCreateActionMode(ActionMode actionMode, Menu menu);

    private native boolean n_onCreateActionMode(android.view.ActionMode actionMode, Menu menu);

    private native void n_onDestroyActionMode(ActionMode actionMode);

    private native void n_onDestroyActionMode(android.view.ActionMode actionMode);

    private native void n_onItemClick(AdapterView adapterView, View view, int i, long j);

    private native boolean n_onItemLongClick(AdapterView adapterView, View view, int i, long j);

    private native boolean n_onPrepareActionMode(ActionMode actionMode, Menu menu);

    private native boolean n_onPrepareActionMode(android.view.ActionMode actionMode, Menu menu);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.CellAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", CellAdapter.class, __md_methods);
    }

    public CellAdapter() throws Throwable {
        if (getClass() == CellAdapter.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.CellAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public CellAdapter(Context context) throws Throwable {
        if (getClass() == CellAdapter.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.CellAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        return n_onItemLongClick(adapterView, view, i, j);
    }

    public boolean onActionItemClicked(android.view.ActionMode actionMode, MenuItem menuItem) {
        return n_onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(android.view.ActionMode actionMode, Menu menu) {
        return n_onCreateActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(android.view.ActionMode actionMode) {
        n_onDestroyActionMode(actionMode);
    }

    public boolean onPrepareActionMode(android.view.ActionMode actionMode, Menu menu) {
        return n_onPrepareActionMode(actionMode, menu);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        n_onItemClick(adapterView, view, i, j);
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return n_onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return n_onCreateActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        n_onDestroyActionMode(actionMode);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return n_onPrepareActionMode(actionMode, menu);
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
