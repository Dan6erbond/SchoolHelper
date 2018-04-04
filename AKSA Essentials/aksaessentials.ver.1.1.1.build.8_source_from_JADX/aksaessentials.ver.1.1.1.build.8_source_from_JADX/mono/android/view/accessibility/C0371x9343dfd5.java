package mono.android.view.accessibility;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class C0371x9343dfd5 implements IGCUserPeer, TouchExplorationStateChangeListener {
    public static final String __md_methods = "n_onTouchExplorationStateChanged:(Z)V:GetOnTouchExplorationStateChanged_ZHandler:Android.Views.Accessibility.AccessibilityManager/ITouchExplorationStateChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTouchExplorationStateChanged(boolean z);

    static {
        Runtime.register("Android.Views.Accessibility.AccessibilityManager+ITouchExplorationStateChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", C0371x9343dfd5.class, __md_methods);
    }

    public C0371x9343dfd5() throws Throwable {
        if (getClass() == C0371x9343dfd5.class) {
            TypeManager.Activate("Android.Views.Accessibility.AccessibilityManager+ITouchExplorationStateChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTouchExplorationStateChanged(boolean z) {
        n_onTouchExplorationStateChanged(z);
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
