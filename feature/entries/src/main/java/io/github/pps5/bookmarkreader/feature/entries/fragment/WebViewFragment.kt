package io.github.pps5.bookmarkreader.feature.entries.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import io.github.pps5.feature.entries.databinding.FragmentWebviewBinding

class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebviewBinding
    private val args: WebViewFragmentArgs by navArgs()

    private val webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            return false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupWebView()
        binding.webview.loadUrl(args.url)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().onBackPressedDispatcher
            .addCallback(this, true) {
                val shouldHandleBack = binding.webview.canGoBack()
                if (shouldHandleBack) {
                    binding.webview.goBack()
                }
                isEnabled = shouldHandleBack
            }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        binding.webview
            .apply {
                overScrollMode = View.OVER_SCROLL_NEVER
                webViewClient = this@WebViewFragment.webViewClient
                setInitialScale(1)
            }
        binding.webview.settings
            .apply {
                javaScriptEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
            }
        CookieManager.getInstance()
            .apply {
                setAcceptCookie(true)
                setAcceptThirdPartyCookies(binding.webview, true)
            }
    }
}

