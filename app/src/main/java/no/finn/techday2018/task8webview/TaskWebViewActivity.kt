package no.finn.techday2018.task8webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import no.finn.techday2018.R


class TaskWebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        initWebview()

        webView.loadUrl(getString(R.string.finn_url))
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebview() {
        webView = findViewById(R.id.web_wiew)
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                // TODO: show progress
                view.loadUrl(url)

                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                // TODO: hide progress
            }
        }

    }

    fun goClicked(v: View) {
        val editText: EditText = findViewById(R.id.editUrl)
        webView.loadUrl(editText.text.toString())
    }

}
