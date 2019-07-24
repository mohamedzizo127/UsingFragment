package com.ps.mohamed.usingfragment.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ps.mohamed.usingfragment.Activities.MainActivity;
import com.ps.mohamed.usingfragment.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
     // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //views
    Button accBtn, genericBtn , bornWithBtn, chooseBtn;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MainFragmentInteractionListener mListener;
    private int mLightning;
    private int mAtomic;
    private int mRocket;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //    Button accBtn, genericBtn , bornWithBtn, chooseBtn;
        intializationViews(view);






        return view;
    }

    private void intializationViews(View view) {
        accBtn = (Button) view.findViewById(R.id.AccedantBtn);
        accBtn.setOnClickListener(this);

        genericBtn = (Button) view.findViewById(R.id.GenericBtn);
        genericBtn.setOnClickListener(this);

        bornWithBtn = (Button) view.findViewById(R.id.BornWithBtn);
        bornWithBtn.setOnClickListener(this);

        chooseBtn = (Button) view.findViewById(R.id.ChooseBtn);
        chooseBtn.setOnClickListener(this);
        chooseBtnAction(false);
        mLightning = R.drawable.lightning;
        mAtomic = R.drawable.atomic;
        mRocket = R.drawable.rocket;



    }

   private void intitialState() {
       //    Button accBtn, genericBtn , bornWithBtn, chooseBtn;

       accBtn.setCompoundDrawablesWithIntrinsicBounds(mLightning, 0 ,0, 0);
       genericBtn.setCompoundDrawablesWithIntrinsicBounds(mAtomic, 0 , 0, 0);
       bornWithBtn.setCompoundDrawablesWithIntrinsicBounds(mRocket, 0 , 0, 0);


   }

    private void chooseBtnAction(boolean anyIsChecked) {
        if (anyIsChecked){
            chooseBtn.setEnabled(true);
            chooseBtn.getBackground().setAlpha(255);
        }else{

            chooseBtn.setEnabled(false);
            chooseBtn.getBackground().setAlpha(128);
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMAinFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        intitialState();
        chooseBtnAction(true);
        int id = v.getId();
        switch (id){
            case R.id.AccedantBtn:
                drewRightSelected(v, mLightning);
                break;
            case R.id.GenericBtn:
                drewRightSelected(v, mAtomic);
                break;
            case R.id.BornWithBtn:
                drewRightSelected(v, mRocket);
                break;
            case R.id.ChooseBtn:
                loadAnatherFragment();
                break;
        }


    }

    private void loadAnatherFragment() {
        MainActivity mainActivity = (MainActivity)getActivity();
             mainActivity.loadPickPowerFragment();
    }

    private void drewRightSelected(View v, int leftDrwable) {
        Button btn = (Button)v;
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrwable, 0 ,R.drawable.item_selected, 0);
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
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMAinFragmentInteraction(Uri uri);
    }
}
