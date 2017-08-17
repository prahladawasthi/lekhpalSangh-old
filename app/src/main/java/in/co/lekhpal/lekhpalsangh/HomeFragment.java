package in.co.lekhpal.lekhpalsangh;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        Button lekhpalSanghButton;
        Button lekhpalSearchButton;
        Button villageSearchButton;
        Button mandalButton;
        Button districtButton;
        Button tahsilButton;
        Button edistrictButton;
        Button govButton;
        Button lekhpalPortalButton;
        Button lekhpalNewsButton;
        Button complainButton;
        Button feedbackButton;
        Button contactButton;


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
        View mContentView = inflater.inflate(R.layout.fragment_home, container, false);

        lekhpalSanghButton = ((Button) mContentView.findViewById(R.id.lekhpalSangh));
        lekhpalSanghButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "http://www.lekhpal.co.in");
                startActivity(intent);
            }
        });


        lekhpalSearchButton = ((Button) mContentView.findViewById(R.id.lekhpalSearch));
        lekhpalSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "https://lekhpal.cfapps.io/common/lekhpalSearch");
                startActivity(intent);
            }
        });

        villageSearchButton = ((Button) mContentView.findViewById(R.id.villageSearch));
        villageSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "https://lekhpal.cfapps.io/common/villageSearch");
                startActivity(intent);
            }
        });


        mandalButton = ((Button) mContentView.findViewById(R.id.mandal));
        mandalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "https://lekhpal.cfapps.io/mandal/");
                startActivity(intent);
            }
        });

        districtButton = ((Button) mContentView.findViewById(R.id.district));
        districtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "https://lekhpal.cfapps.io/district/");
                startActivity(intent);
            }
        });

        tahsilButton = ((Button) mContentView.findViewById(R.id.tahsil));
        tahsilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "https://lekhpal.cfapps.io/tahsil/");
                startActivity(intent);
            }
        });
        edistrictButton = ((Button) mContentView.findViewById(R.id.edistrict));
        edistrictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "http://164.100.181.28/edistrict/login/login.aspx");
                startActivity(intent);
            }
        });

        govButton = ((Button) mContentView.findViewById(R.id.govPortal));
        govButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "http://www.lekhpal.co.in/p/importent-links.html");
                startActivity(intent);
            }
        });

        lekhpalPortalButton = ((Button) mContentView.findViewById(R.id.lekhpalPortal));
        lekhpalPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "https://lekhpal.cfapps.io/");
                startActivity(intent);
            }
        });

        lekhpalNewsButton = ((Button) mContentView.findViewById(R.id.lekhpalNews));
        lekhpalNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "http://lekhpalnews.blogspot.in/");
                startActivity(intent);
            }
        });

        complainButton = ((Button) mContentView.findViewById(R.id.complain));
        complainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "https://lekhpal.cfapps.io/complain/");
                startActivity(intent);
            }
        });

        feedbackButton = ((Button) mContentView.findViewById(R.id.feedback));
        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "https://lekhpal.cfapps.io/feedback/");
                startActivity(intent);
            }
        });

        contactButton = ((Button) mContentView.findViewById(R.id.contact));
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("url", "http://www.lekhpal.co.in/p/contact-us.html");
                startActivity(intent);
            }
        });

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
}
