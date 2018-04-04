package mono.android.media.midi;

import android.media.midi.MidiDevice;
import android.media.midi.MidiManager.OnDeviceOpenedListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MidiManager_OnDeviceOpenedListenerImplementor implements IGCUserPeer, OnDeviceOpenedListener {
    public static final String __md_methods = "n_onDeviceOpened:(Landroid/media/midi/MidiDevice;)V:GetOnDeviceOpened_Landroid_media_midi_MidiDevice_Handler:Android.Media.Midi.MidiManager/IOnDeviceOpenedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDeviceOpened(MidiDevice midiDevice);

    static {
        Runtime.register("Android.Media.Midi.MidiManager+IOnDeviceOpenedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MidiManager_OnDeviceOpenedListenerImplementor.class, __md_methods);
    }

    public MidiManager_OnDeviceOpenedListenerImplementor() throws Throwable {
        if (getClass() == MidiManager_OnDeviceOpenedListenerImplementor.class) {
            TypeManager.Activate("Android.Media.Midi.MidiManager+IOnDeviceOpenedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDeviceOpened(MidiDevice midiDevice) {
        n_onDeviceOpened(midiDevice);
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
