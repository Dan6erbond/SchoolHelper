package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FormsApplicationActivity extends Activity implements IGCUserPeer {
    public static final String __md_methods = "n_onBackPressed:()V:GetOnBackPressedHandler\nn_onConfigurationChanged:(Landroid/content/res/Configuration;)V:GetOnConfigurationChanged_Landroid_content_res_Configuration_Handler\nn_onOptionsItemSelected:(Landroid/view/MenuItem;)Z:GetOnOptionsItemSelected_Landroid_view_MenuItem_Handler\nn_onPrepareOptionsMenu:(Landroid/view/Menu;)Z:GetOnPrepareOptionsMenu_Landroid_view_Menu_Handler\nn_onActivityResult:(IILandroid/content/Intent;)V:GetOnActivityResult_IILandroid_content_Intent_Handler\nn_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onDestroy:()V:GetOnDestroyHandler\nn_onPause:()V:GetOnPauseHandler\nn_onRestart:()V:GetOnRestartHandler\nn_onResume:()V:GetOnResumeHandler\nn_onStart:()V:GetOnStartHandler\nn_onStop:()V:GetOnStopHandler\n";
    private ArrayList refList;

    private native void n_onActivityResult(int i, int i2, Intent intent);

    private native void n_onBackPressed();

    private native void n_onConfigurationChanged(Configuration configuration);

    private native void n_onCreate(Bundle bundle);

    private native void n_onDestroy();

    private native boolean n_onOptionsItemSelected(MenuItem menuItem);

    private native void n_onPause();

    private native boolean n_onPrepareOptionsMenu(Menu menu);

    private native void n_onRestart();

    private native void n_onResume();

    private native void n_onStart();

    private native void n_onStop();

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.FormsApplicationActivity, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FormsApplicationActivity.class, __md_methods);
    }

    public FormsApplicationActivity() throws Throwable {
        if (getClass() == FormsApplicationActivity.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormsApplicationActivity, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onBackPressed() {
        n_onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        n_onConfigurationChanged(configuration);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return n_onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return n_onPrepareOptionsMenu(menu);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        n_onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
    }

    public void onDestroy() {
        n_onDestroy();
    }

    public void onPause() {
        n_onPause();
    }

    public void onRestart() {
        n_onRestart();
    }

    public void onResume() {
        n_onResume();
    }

    public void onStart() {
        n_onStart();
    }

    public void onStop() {
        n_onStop();
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
