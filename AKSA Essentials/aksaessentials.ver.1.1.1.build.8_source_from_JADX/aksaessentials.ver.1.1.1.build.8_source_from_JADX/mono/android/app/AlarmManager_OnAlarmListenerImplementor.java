package mono.android.app;

import android.app.AlarmManager.OnAlarmListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AlarmManager_OnAlarmListenerImplementor implements IGCUserPeer, OnAlarmListener {
    public static final String __md_methods = "n_onAlarm:()V:GetOnAlarmHandler:Android.App.AlarmManager/IOnAlarmListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAlarm();

    static {
        Runtime.register("Android.App.AlarmManager+IOnAlarmListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AlarmManager_OnAlarmListenerImplementor.class, __md_methods);
    }

    public AlarmManager_OnAlarmListenerImplementor() throws Throwable {
        if (getClass() == AlarmManager_OnAlarmListenerImplementor.class) {
            TypeManager.Activate("Android.App.AlarmManager+IOnAlarmListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onAlarm() {
        n_onAlarm();
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
