package mono.android.accessibilityservice;

import android.accessibilityservice.AccessibilityService.MagnificationController;
import android.accessibilityservice.AccessibilityService.MagnificationController.OnMagnificationChangedListener;
import android.graphics.Region;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class C0368xb19d768a implements IGCUserPeer, OnMagnificationChangedListener {
    public static final String __md_methods = "n_onMagnificationChanged:(Landroid/accessibilityservice/AccessibilityService$MagnificationController;Landroid/graphics/Region;FFF)V:GetOnMagnificationChanged_Landroid_accessibilityservice_AccessibilityService_MagnificationController_Landroid_graphics_Region_FFFHandler:Android.AccessibilityServices.AccessibilityService/MagnificationController/IOnMagnificationChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onMagnificationChanged(MagnificationController magnificationController, Region region, float f, float f2, float f3);

    static {
        Runtime.register("Android.AccessibilityServices.AccessibilityService+MagnificationController+IOnMagnificationChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", C0368xb19d768a.class, __md_methods);
    }

    public C0368xb19d768a() throws Throwable {
        if (getClass() == C0368xb19d768a.class) {
            TypeManager.Activate("Android.AccessibilityServices.AccessibilityService+MagnificationController+IOnMagnificationChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onMagnificationChanged(MagnificationController magnificationController, Region region, float f, float f2, float f3) {
        n_onMagnificationChanged(magnificationController, region, f, f2, f3);
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
