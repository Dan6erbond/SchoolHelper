package md5270abb39e60627f0f200893b490a1ade;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FormsFragmentPagerAdapter_1 extends FragmentPagerAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getCount:()I:GetGetCountHandler\nn_getItem:(I)Landroid/support/v4/app/Fragment;:GetGetItem_IHandler\nn_getItemId:(I)J:GetGetItemId_IHandler\nn_getItemPosition:(Ljava/lang/Object;)I:GetGetItemPosition_Ljava_lang_Object_Handler\nn_getPageTitle:(I)Ljava/lang/CharSequence;:GetGetPageTitle_IHandler\nn_restoreState:(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V:GetRestoreState_Landroid_os_Parcelable_Ljava_lang_ClassLoader_Handler\n";
    private ArrayList refList;

    private native int n_getCount();

    private native Fragment n_getItem(int i);

    private native long n_getItemId(int i);

    private native int n_getItemPosition(Object obj);

    private native CharSequence n_getPageTitle(int i);

    private native void n_restoreState(Parcelable parcelable, ClassLoader classLoader);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.AppCompat.FormsFragmentPagerAdapter`1, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FormsFragmentPagerAdapter_1.class, __md_methods);
    }

    public FormsFragmentPagerAdapter_1(FragmentManager fragmentManager) throws Throwable {
        super(fragmentManager);
        if (getClass() == FormsFragmentPagerAdapter_1.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.AppCompat.FormsFragmentPagerAdapter`1, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Support.V4.App.FragmentManager, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", this, new Object[]{fragmentManager});
        }
    }

    public int getCount() {
        return n_getCount();
    }

    public Fragment getItem(int i) {
        return n_getItem(i);
    }

    public long getItemId(int i) {
        return n_getItemId(i);
    }

    public int getItemPosition(Object obj) {
        return n_getItemPosition(obj);
    }

    public CharSequence getPageTitle(int i) {
        return n_getPageTitle(i);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        n_restoreState(parcelable, classLoader);
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
