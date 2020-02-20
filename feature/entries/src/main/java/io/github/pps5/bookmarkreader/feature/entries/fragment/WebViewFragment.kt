package io.github.pps5.bookmarkreader.feature.entries.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import io.github.pps5.feature.entries.R
import io.github.pps5.feature.entries.databinding.FragmentWebviewBinding

class WebViewFragment : Fragment(R.layout.fragment_webview) {

    companion object {
        private const val ARG_URL = "url"
        fun newInstance(url: String) =
            WebViewFragment()
                .apply { arguments = bundleOf(ARG_URL to url) }
    }

    private lateinit var binding: FragmentWebviewBinding
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentWebviewBinding.bind(view)
        binding.appbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.share -> handleOnShareItemSelected()
                R.id.bookmark -> {
                    // TODO: 20/02/07 open bookmark page 
                }
                R.id.comments -> {
                    // TODO: 20/02/07 open comments sheet 
                }
            }
            return@setOnMenuItemClickListener true
        }
        onBackPressedCallback = requireActivity().onBackPressedDispatcher
            .addCallback(this, false) {
                binding.webview.goBack()
                isEnabled = binding.webview.canGoBack()
            }
        setupWebView()
        binding.webview.loadUrl(requireArguments().getString(ARG_URL))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onBackPressedCallback.remove()
    }

    private fun handleOnShareItemSelected() {
        val (title, url) = with(binding.webview) { title to url }
        val intent = Intent()
            .apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    getString(R.string.share_text, title, url)
                )
            }
        startActivity(intent)
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

