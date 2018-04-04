package md5270abb39e60627f0f200893b490a1ade;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FormsViewPager extends ViewPager implements IGCUserPeer {
    public static final String __md_methods = "n_onInterceptTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnInterceptTouchEvent_Landroid_view_MotionEvent_Handler\nn_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\n";
    private ArrayList refList;

    private native boolean n_onInterceptTouchEvent(MotionEvent motionEvent);

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AppCompat.FormsViewPager, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FormsViewPager.class, __md_methods);
    }

    public FormsViewPager(Context context) throws Throwable {
        super(context);
        if (getClass() == FormsViewPager.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.FormsViewPager, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public FormsViewPager(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == FormsViewPager.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.FormsViewPager, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return n_onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
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
