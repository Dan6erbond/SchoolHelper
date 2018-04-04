package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class TintContextWrapper extends ContextWrapper {
    private static final ArrayList<WeakReference<TintContextWrapper>> sCache = new ArrayList();
    private Resources mResources;

    public static Context wrap(@NonNull Context context) {
        if (context instanceof TintContextWrapper) {
            return context;
        }
        TintContextWrapper wrapper;
        int count = sCache.size();
        for (int i = 0; i < count; i++) {
            WeakReference<TintContextWrapper> ref = (WeakReference) sCache.get(i);
            wrapper = ref != null ? (TintContextWrapper) ref.get() : null;
            if (wrapper != null && wrapper.getBaseContext() == context) {
                return wrapper;
            }
        }
        wrapper = new TintContextWrapper(context);
        sCache.add(new WeakReference(wrapper));
        return wrapper;
    }

    private TintContextWrapper(Context base) {
        super(base);
    }

    public Resources getResources() {
        if (this.mResources == null) {
            this.mResources = new TintResources(this, super.getResources());
        }
        return this.mResources;
    }
}
