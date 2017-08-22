package in.co.lekhpal.lekhpalsangh;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;
    String url;
    SwipeRefreshLayout swipeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"lekhpal.up@gmail.com", "netsolutionst@gmail.com"});  //developer 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Lekhpal Sangh Feedback"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Lekhpal Sangh," + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Feedback:"));

                Snackbar.make(view, "Opening Email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        swipeView = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        if (!Utils.checkInternetConnection(getBaseContext())) {
            Toast.makeText(getBaseContext(), "No Internet!", Toast.LENGTH_LONG).show();
        } else {
            progressBar = (ProgressBar) findViewById(R.id.progressBar3);
            if (null != getIntent() && null != getIntent().getStringExtra("url")) {
                url = getIntent().getStringExtra("url");
            } else {
                Bundle data = getIntent().getExtras();
                if (null != data.get("webViewURL")) {
                    url = String.valueOf(data.get("webViewURL"));
                }
            }

            webView = (WebView) findViewById(R.id.webView);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setDisplayZoomControls(false);
            webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

            webView.getSettings().setSupportMultipleWindows(true);
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

            if (null != url && url.contains("edistrict")) {
                Snackbar.make(webView, "We are facing some issues in this website. We will update you soon sorry for the inconvenience ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                webView.getSettings().setUserAgentString("Mozilla/5.0 (Android 4.4; Tablet; rv:41.0) Gecko/41.0 Firefox/41.0");
            }

            webView.getSettings().setSupportMultipleWindows(true);

            webView.getSettings().setJavaScriptEnabled(true);
            progressBar.setVisibility(View.VISIBLE);
            webView.loadUrl(url);

            swipeView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    if (webView.getScrollY() == 0)
                        swipeView.setEnabled(true);
                    else
                        swipeView.setEnabled(false);
                }
            });

            swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    webView.loadUrl(url);

                }
            });

            webView.setWebViewClient(new WebViewClient() {

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    url = request.getUrl().toString();
                    if (!Utils.checkInternetConnection(getBaseContext())) {
                        Toast.makeText(getBaseContext(), "No Internet!", Toast.LENGTH_LONG).show();
                    } else if (url.endsWith(".pdf")) {
                        /*String pdfUrl = googleDocs + url;
                        view.loadUrl(pdfUrl);
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(url), "application/pdf");*/
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(url));
                        try {
                            startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            //user does not have a pdf viewer installed
                        }
                    } else {
                        view.loadUrl(url);
                    }
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    swipeView.setRefreshing(false);
                    progressBar.setVisibility(View.GONE);
                }
            });

            webView.setWebChromeClient(new WebChromeClient());

            webView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                        webView.goBack();
                        return true;
                    }
                    return false;
                }
            });
        }
    }
}