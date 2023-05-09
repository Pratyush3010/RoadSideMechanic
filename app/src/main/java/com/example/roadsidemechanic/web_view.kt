package com.example.roadsidemechanic

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.roadsidemechanic.databinding.ActivityWebViewBinding

class web_view : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        webviewSetup()
    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewSetup() {
        binding.webview.webViewClient = WebViewClient()

        binding.webview.apply {
            val link: String = intent.getStringExtra("Link").toString()
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.safeBrowsingEnabled = true
            settings.allowFileAccess = true
            settings.pluginState = WebSettings.PluginState.ON
            loadUrl(link)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBackPressed() {
        if (binding.webview.canGoBack()){
            binding.webview.goBack()
        }
        else
        super.onBackPressed()
    }
    // Overriding WebViewClient functions
    inner class WebViewClient : android.webkit.WebViewClient() {

        // Load the URL
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        // ProgressBar will disappear once page is loaded
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility = View.GONE
        }
    }
}