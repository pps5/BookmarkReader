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
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import io.github.pps5.feature.entries.databinding.FragmentWebviewBinding

class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebviewBinding
    private val args: WebViewFragmentArgs by navArgs()
    private lateinit var onBackPressedCallback: OnBackPressedCallback
    private val webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            onBackPressedCallback.isEnabled = true
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
        onBackPressedCallback = requireActivity().onBackPressedDispatcher
            .addCallback(this, false) {
                binding.webview.goBack()
                isEnabled = binding.webview.canGoBack()
            }
        setupWebView()
        binding.webview.loadUrl(args.url)
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

