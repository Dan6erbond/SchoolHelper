package md5b60ffeb829f638581ab2bb9b1a7f4f3f;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class WebViewRenderer_WebClient extends WebViewClient implements IGCUserPeer {
    public static final String __md_methods = "n_onPageFinished:(Landroid/webkit/WebView;Ljava/lang/String;)V:GetOnPageFinished_Landroid_webkit_WebView_Ljava_lang_String_Handler\nn_onReceivedError:(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V:GetOnReceivedError_Landroid_webkit_WebView_ILjava_lang_String_Ljava_lang_String_Handler\nn_onReceivedError:(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V:GetOnReceivedError_Landroid_webkit_WebView_Landroid_webkit_WebResourceRequest_Landroid_webkit_WebResourceError_Handler\nn_shouldOverrideUrlLoading:(Landroid/webkit/WebView;Ljava/lang/String;)Z:GetShouldOverrideUrlLoading_Landroid_webkit_WebView_Ljava_lang_String_Handler\n";
    private ArrayList refList;

    private native void n_onPageFinished(WebView webView, String str);

    private native void n_onReceivedError(WebView webView, int i, String str, String str2);

    private native void n_onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

    private native boolean n_shouldOverrideUrlLoading(WebView webView, String str);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.WebViewRenderer+WebClient, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", WebViewRenderer_WebClient.class, __md_methods);
    }

    public WebViewRenderer_WebClient() throws Throwable {
        if (getClass() == WebViewRenderer_WebClient.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.WebViewRenderer+WebClient, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public WebViewRenderer_WebClient(WebViewRenderer webViewRenderer) throws Throwable {
        if (getClass() == WebViewRenderer_WebClient.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.WebViewRenderer+WebClient, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", "Xamarin.Forms.Platform.Android.WebViewRenderer, Xamarin.Forms.Platform.Android, Version=2.0.0.0, Culture=neutral, PublicKeyToken=null", this, new Object[]{webViewRenderer});
        }
    }

    public void onPageFinished(WebView webView, String str) {
        n_onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        n_onReceivedError(webView, i, str, str2);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        n_onReceivedError(webView, webResourceRequest, webResourceError);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return n_shouldOverrideUrlLoading(webView, str);
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
