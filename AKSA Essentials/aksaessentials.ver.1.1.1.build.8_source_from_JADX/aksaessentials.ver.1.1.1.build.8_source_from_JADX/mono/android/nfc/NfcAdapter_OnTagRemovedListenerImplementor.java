package mono.android.nfc;

import android.nfc.NfcAdapter.OnTagRemovedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NfcAdapter_OnTagRemovedListenerImplementor implements IGCUserPeer, OnTagRemovedListener {
    public static final String __md_methods = "n_onTagRemoved:()V:GetOnTagRemovedHandler:Android.Nfc.NfcAdapter/IOnTagRemovedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTagRemoved();

    static {
        Runtime.register("Android.Nfc.NfcAdapter+IOnTagRemovedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", NfcAdapter_OnTagRemovedListenerImplementor.class, __md_methods);
    }

    public NfcAdapter_OnTagRemovedListenerImplementor() throws Throwable {
        if (getClass() == NfcAdapter_OnTagRemovedListenerImplementor.class) {
            TypeManager.Activate("Android.Nfc.NfcAdapter+IOnTagRemovedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTagRemoved() {
        n_onTagRemoved();
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
