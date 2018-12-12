package no.finn.techday2018.task8webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import no.finn.techday2018.R


class TaskWebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // add a web view to the layout: activity_web_view.xml
        // initialize the web view (javaScriptEnabled, webViewClient), https://stackoverflow.com/questions/8614553/can-someone-give-one-exact-example-of-webview-implementation-in-android
        // load a url: http:///www.finn.no
        // make sure that the app's manifest (AndroidManifest.xml) have set permission to use internet: "<uses-permission android:name="android.permission.INTERNET" />"

    }

}
