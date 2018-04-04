package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FormsWebChromeClient extends WebChromeClient implements IGCUserPeer {
    public static final String __md_methods = "n_onShowFileChooser:(Landroid/webkit/WebView;Landroid/webkit/ValueCallback;Landroid/webkit/WebChromeClient$FileChooserParams;)Z:GetOnShowFileChooser_Landroid_webkit_WebView_Landroid_webkit_ValueCallback_Landroid_webkit_WebChromeClient_FileChooserParams_Handler\n";
    private ArrayList refList;

    private native boolean n_onShowFileChooser(WebView webView, ValueCallback valueCallback, FileChooserParams fileChooserParams);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.FormsWebChromeClient, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", FormsWebChromeClient.class, __md_methods);
    }

    public FormsWebChromeClient() throws Throwable {
        if (getClass() == FormsWebChromeClient.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FormsWebChromeClient, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, FileChooserParams fileChooserParams) {
        return n_onShowFileChooser(webView, valueCallback, fileChooserParams);
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
