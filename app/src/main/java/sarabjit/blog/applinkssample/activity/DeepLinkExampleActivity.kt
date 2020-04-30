package sarabjit.blog.applinkssample.activity

import android.webkit.WebView
import android.webkit.WebViewClient
import sarabjit.blog.applinkssample.R

class DeepLinkExampleActivity : androidx.appcompat.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.java_activity)
        val webView = findViewById<WebView>(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("http://www.androidinformative.com/deep-linking-in-android")
    }
}