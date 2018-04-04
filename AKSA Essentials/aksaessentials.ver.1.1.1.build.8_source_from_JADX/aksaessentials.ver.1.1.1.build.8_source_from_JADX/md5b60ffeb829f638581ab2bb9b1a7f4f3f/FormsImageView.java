package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FormsImageView extends ImageView implements IGCUserPeer {
    public static final String __md_methods = "n_invalidate:()V:GetInvalidateHandler\n";
    private ArrayList refList;

    private native void n_invalidate();

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.FormsImageView, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FormsImageView.class, __md_methods);
    }

    public FormsImageView(Context context) throws Throwable {
        super(context);
        if (getClass() == FormsImageView.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormsImageView, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public FormsImageView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == FormsImageView.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormsImageView, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public FormsImageView(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == FormsImageView.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormsImageView, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public void invalidate() {
        n_invalidate();
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
