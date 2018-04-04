package md5270abb39e60627f0f200893b490a1ade;

import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NavigationPageRenderer_DrawerMultiplexedListener implements IGCUserPeer, DrawerListener {
    public static final String __md_methods = "n_onDrawerClosed:(Landroid/view/View;)V:GetOnDrawerClosed_Landroid_view_View_Handler:Android.Support.V4.Widget.DrawerLayout/IDrawerListenerInvoker, Xamarin.Android.Support.v4\nn_onDrawerOpened:(Landroid/view/View;)V:GetOnDrawerOpened_Landroid_view_View_Handler:Android.Support.V4.Widget.DrawerLayout/IDrawerListenerInvoker, Xamarin.Android.Support.v4\nn_onDrawerSlide:(Landroid/view/View;F)V:GetOnDrawerSlide_Landroid_view_View_FHandler:Android.Support.V4.Widget.DrawerLayout/IDrawerListenerInvoker, Xamarin.Android.Support.v4\nn_onDrawerStateChanged:(I)V:GetOnDrawerStateChanged_IHandler:Android.Support.V4.Widget.DrawerLayout/IDrawerListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onDrawerClosed(View view);

    private native void n_onDrawerOpened(View view);

    private native void n_onDrawerSlide(View view, float f);

    private native void n_onDrawerStateChanged(int i);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AppCompat.NavigationPageRenderer+DrawerMultiplexedListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", NavigationPageRenderer_DrawerMultiplexedListener.class, __md_methods);
    }

    public NavigationPageRenderer_DrawerMultiplexedListener() throws Throwable {
        if (getClass() == NavigationPageRenderer_DrawerMultiplexedListener.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.NavigationPageRenderer+DrawerMultiplexedListener, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onDrawerClosed(View view) {
        n_onDrawerClosed(view);
    }

    public void onDrawerOpened(View view) {
        n_onDrawerOpened(view);
    }

    public void onDrawerSlide(View view, float f) {
        n_onDrawerSlide(view, f);
    }

    public void onDrawerStateChanged(int i) {
        n_onDrawerStateChanged(i);
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
