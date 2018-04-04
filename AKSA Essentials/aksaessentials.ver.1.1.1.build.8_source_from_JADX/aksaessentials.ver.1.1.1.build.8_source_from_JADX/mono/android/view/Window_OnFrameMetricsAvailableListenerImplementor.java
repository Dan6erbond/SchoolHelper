package mono.android.view;

import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Window_OnFrameMetricsAvailableListenerImplementor implements IGCUserPeer, OnFrameMetricsAvailableListener {
    public static final String __md_methods = "n_onFrameMetricsAvailable:(Landroid/view/Window;Landroid/view/FrameMetrics;I)V:GetOnFrameMetricsAvailable_Landroid_view_Window_Landroid_view_FrameMetrics_IHandler:Android.Views.Window/IOnFrameMetricsAvailableListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i);

    static {
        Runtime.register("Android.Views.Window+IOnFrameMetricsAvailableListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Window_OnFrameMetricsAvailableListenerImplementor.class, __md_methods);
    }

    public Window_OnFrameMetricsAvailableListenerImplementor() throws Throwable {
        if (getClass() == Window_OnFrameMetricsAvailableListenerImplementor.class) {
            TypeManager.Activate("Android.Views.Window+IOnFrameMetricsAvailableListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        n_onFrameMetricsAvailable(window, frameMetrics, i);
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
