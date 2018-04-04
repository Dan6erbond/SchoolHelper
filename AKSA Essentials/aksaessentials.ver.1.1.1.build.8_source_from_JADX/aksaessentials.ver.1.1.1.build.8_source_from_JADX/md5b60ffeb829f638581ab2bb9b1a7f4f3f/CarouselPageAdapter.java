package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class CarouselPageAdapter extends PagerAdapter implements IGCUserPeer, OnPageChangeListener {
    public static final String __md_methods = "n_getCount:()I:GetGetCountHandler\nn_destroyItem:(Landroid/view/ViewGroup;ILjava/lang/Object;)V:GetDestroyItem_Landroid_view_ViewGroup_ILjava_lang_Object_Handler\nn_getItemPosition:(Ljava/lang/Object;)I:GetGetItemPosition_Ljava_lang_Object_Handler\nn_instantiateItem:(Landroid/view/ViewGroup;I)Ljava/lang/Object;:GetInstantiateItem_Landroid_view_ViewGroup_IHandler\nn_isViewFromObject:(Landroid/view/View;Ljava/lang/Object;)Z:GetIsViewFromObject_Landroid_view_View_Ljava_lang_Object_Handler\nn_onPageScrollStateChanged:(I)V:GetOnPageScrollStateChanged_IHandler:Android.Support.V4.View.ViewPager/IOnPageChangeListenerInvoker, Xamarin.Android.Support.v4\nn_onPageScrolled:(IFI)V:GetOnPageScrolled_IFIHandler:Android.Support.V4.View.ViewPager/IOnPageChangeListenerInvoker, Xamarin.Android.Support.v4\nn_onPageSelected:(I)V:GetOnPageSelected_IHandler:Android.Support.V4.View.ViewPager/IOnPageChangeListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_destroyItem(ViewGroup viewGroup, int i, Object obj);

    private native int n_getCount();

    private native int n_getItemPosition(Object obj);

    private native Object n_instantiateItem(ViewGroup viewGroup, int i);

    private native boolean n_isViewFromObject(View view, Object obj);

    private native void n_onPageScrollStateChanged(int i);

    private native void n_onPageScrolled(int i, float f, int i2);

    private native void n_onPageSelected(int i);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.CarouselPageAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", CarouselPageAdapter.class, __md_methods);
    }

    public CarouselPageAdapter() throws Throwable {
        if (getClass() == CarouselPageAdapter.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.CarouselPageAdapter, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public int getCount() {
        return n_getCount();
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        n_destroyItem(viewGroup, i, obj);
    }

    public int getItemPosition(Object obj) {
        return n_getItemPosition(obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return n_instantiateItem(viewGroup, i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return n_isViewFromObject(view, obj);
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
