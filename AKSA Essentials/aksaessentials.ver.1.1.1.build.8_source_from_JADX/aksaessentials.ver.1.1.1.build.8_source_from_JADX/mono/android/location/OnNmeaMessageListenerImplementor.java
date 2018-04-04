package mono.android.location;

import android.location.OnNmeaMessageListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class OnNmeaMessageListenerImplementor implements IGCUserPeer, OnNmeaMessageListener {
    public static final String __md_methods = "n_onNmeaMessage:(Ljava/lang/String;J)V:GetOnNmeaMessage_Ljava_lang_String_JHandler:Android.Locations.IOnNmeaMessageListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onNmeaMessage(String str, long j);

    static {
        Runtime.register("Android.Locations.IOnNmeaMessageListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", OnNmeaMessageListenerImplementor.class, __md_methods);
    }

    public OnNmeaMessageListenerImplementor() throws Throwable {
        if (getClass() == OnNmeaMessageListenerImplementor.class) {
            TypeManager.Activate("Android.Locations.IOnNmeaMessageListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onNmeaMessage(String str, long j) {
        n_onNmeaMessage(str, j);
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
