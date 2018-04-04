package mono.android.app;

import android.app.UiAutomation.OnAccessibilityEventListener;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class UiAutomation_OnAccessibilityEventListenerImplementor implements IGCUserPeer, OnAccessibilityEventListener {
    public static final String __md_methods = "n_onAccessibilityEvent:(Landroid/view/accessibility/AccessibilityEvent;)V:GetOnAccessibilityEvent_Landroid_view_accessibility_AccessibilityEvent_Handler:Android.App.UiAutomation/IOnAccessibilityEventListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    static {
        Runtime.register("Android.App.UiAutomation+IOnAccessibilityEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", UiAutomation_OnAccessibilityEventListenerImplementor.class, __md_methods);
    }

    public UiAutomation_OnAccessibilityEventListenerImplementor() throws Throwable {
        if (getClass() == UiAutomation_OnAccessibilityEventListenerImplementor.class) {
            TypeManager.Activate("Android.App.UiAutomation+IOnAccessibilityEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        n_onAccessibilityEvent(accessibilityEvent);
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
