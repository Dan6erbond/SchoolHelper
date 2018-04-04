package mono.android.media.tv;

import android.media.tv.TvView.OnUnhandledInputEventListener;
import android.view.InputEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TvView_OnUnhandledInputEventListenerImplementor implements IGCUserPeer, OnUnhandledInputEventListener {
    public static final String __md_methods = "n_onUnhandledInputEvent:(Landroid/view/InputEvent;)Z:GetOnUnhandledInputEvent_Landroid_view_InputEvent_Handler:Android.Media.TV.TvView/IOnUnhandledInputEventListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onUnhandledInputEvent(InputEvent inputEvent);

    static {
        Runtime.register("Android.Media.TV.TvView+IOnUnhandledInputEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", TvView_OnUnhandledInputEventListenerImplementor.class, __md_methods);
    }

    public TvView_OnUnhandledInputEventListenerImplementor() throws Throwable {
        if (getClass() == TvView_OnUnhandledInputEventListenerImplementor.class) {
            TypeManager.Activate("Android.Media.TV.TvView+IOnUnhandledInputEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onUnhandledInputEvent(InputEvent inputEvent) {
        return n_onUnhandledInputEvent(inputEvent);
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
