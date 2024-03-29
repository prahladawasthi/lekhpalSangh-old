package in.co.lekhpal.lekhpalsangh;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LekhpalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LekhpalFragment#newInstance} factory method to
 * <p>
 * create an instance of this fragment.
 */
public class LekhpalFragment extends Fragment {

    private WebView webView;
    private View mContentView;
    private ProgressBar progressBar;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public LekhpalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LekhpalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LekhpalFragment newInstance(String param1, String param2) {
        LekhpalFragment fragment = new LekhpalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContentView = inflater.inflate(R.layout.fragment_lekhpal, container, false);

        if (!Utils.checkInternetConnection(getContext())) {
            Toast.makeText(getContext(), "No Internet!", Toast.LENGTH_SHORT).show();
        } else {
            this.progressBar = (ProgressBar) mContentView.findViewById(R.id.progressBar);
            this.webView = (WebView) mContentView.findViewById(R.id.lekhpal);
            this.webView.getSettings().setLoadWithOverviewMode(true);
            this.webView.getSettings().setUseWideViewPort(true);
            this.webView.getSettings().setBuiltInZoomControls(true);
            this.webView.getSettings().setDisplayZoomControls(false);
            this.progressBar.setVisibility(View.VISIBLE);
            this.webView.loadUrl("https://lekhpal.wordpress.com/");
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.setWebViewClient(new CustomWebViewClient());

            //this.webView.setWebViewClient(new CustomWebViewClient());
            //webView.setWebChromeClient(new WebChromeClient());

            this.webView.setOnKeyListener(new View.OnKeyListener() {
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
        return mContentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class CustomWebViewClient extends WebViewClient {
        private CustomWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!Utils.checkInternetConnection(LekhpalFragment.this.getContext())) {
                Toast.makeText(LekhpalFragment.this.getContext(), "No Internet!", Toast.LENGTH_LONG).show();
            } else if (url.endsWith(".pdf")) {
                view.loadUrl("https://docs.google.com/viewer?url=" + url);
            } else if (url.endsWith(".jpg") || url.endsWith(".jpeg")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(url));
                LekhpalFragment.this.startActivity(intent);
            } else {
                view.loadUrl(url);
            }
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}
