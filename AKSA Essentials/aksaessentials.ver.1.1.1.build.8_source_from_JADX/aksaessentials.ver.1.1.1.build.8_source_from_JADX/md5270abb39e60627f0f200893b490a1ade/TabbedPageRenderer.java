package md5270abb39e60627f0f200893b490a1ade;

import android.content.Context;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import java.util.ArrayList;
import md5b60ffeb829f638581ab2bb9b1a7f4f3f.VisualElementRenderer_1;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TabbedPageRenderer extends VisualElementRenderer_1 implements IGCUserPeer, OnTabSelectedListener, OnPageChangeListener {
    public static final String __md_methods = "n_onAttachedToWindow:()V:GetOnAttachedToWindowHandler\nn_onDetachedFromWindow:()V:GetOnDetachedFromWindowHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onTabReselected:(Landroid/support/design/widget/TabLayout$Tab;)V:GetOnTabReselected_Landroid_support_design_widget_TabLayout_Tab_Handler:Android.Support.Design.Widget.TabLayout/IOnTabSelectedListenerInvoker, Xamarin.Android.Support.Design\nn_onTabSelected:(Landroid/support/design/widget/TabLayout$Tab;)V:GetOnTabSelected_Landroid_support_design_widget_TabLayout_Tab_Handler:Android.Support.Design.Widget.TabLayout/IOnTabSelectedListenerInvoker, Xamarin.Android.Support.Design\nn_onTabUnselected:(Landroid/support/design/widget/TabLayout$Tab;)V:GetOnTabUnselected_Landroid_support_design_widget_TabLayout_Tab_Handler:Android.Support.Design.Widget.TabLayout/IOnTabSelectedListenerInvoker, Xamarin.Android.Support.Design\nn_onPageScrollStateChanged:(I)V:GetOnPageScrollStateChanged_IHandler:Android.Support.V4.View.ViewPager/IOnPageChangeListenerInvoker, Xamarin.Android.Support.v4\nn_onPageScrolled:(IFI)V:GetOnPageScrolled_IFIHandler:Android.Support.V4.View.ViewPager/IOnPageChangeListenerInvoker, Xamarin.Android.Support.v4\nn_onPageSelected:(I)V:GetOnPageSelected_IHandler:Android.Support.V4.View.ViewPager/IOnPageChangeListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onAttachedToWindow();

    private native void n_onDetachedFromWindow();

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onPageScrollStateChanged(int i);

    private native void n_onPageScrolled(int i, float f, int i2);

    private native void n_onPageSelected(int i);

    private native void n_onTabReselected(Tab tab);

    private native void n_onTabSelected(Tab tab);

    private native void n_onTabUnselected(Tab tab);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AppCompat.TabbedPageRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", TabbedPageRenderer.class, __md_methods);
    }

    public TabbedPageRenderer(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == TabbedPageRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.TabbedPageRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public TabbedPageRenderer(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == TabbedPageRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.TabbedPageRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public TabbedPageRenderer(Context context) throws Throwable {
        super(context);
        if (getClass() == TabbedPageRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.TabbedPageRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public void onAttachedToWindow() {
        n_onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        n_onDetachedFromWindow();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    public void onTabReselected(Tab tab) {
        n_onTabReselected(tab);
    }

    public void onTabSelected(Tab tab) {
        n_onTabSelected(tab);
    }

    public void onTabUnselected(Tab tab) {
        n_onTabUnselected(tab);
    }

    public void onPageScrollStateChanged(int i) {
        n_onPageScrollStateChanged(i);
    }

    public void onPageScrolled(int i, float f, int i2) {
        n_onPageScrolled(i, f, i2);
    }

    public void onPageSelected(int i) {
        n_onPageSelected(i);
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
