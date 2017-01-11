package com.bkl.air.foi.mdrivingschool.trainee_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.TestoviMainFragment;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 7.12.2016..
 */

public class TraineeMSFragment extends Fragment {
    @BindView(R.id.textView_user)
    TextView textUser;

    @BindView(R.id.imageButton_tzz)
    ImageButton imageButton_tzz;

    private String currentUserId;
    private String currentUserName;
    private String currentUserSurname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.trainee_ms_fragment, container, false);
        currentUserId = getArguments().getString("USER_ID");
        currentUserName = getArguments().getString("USER_NAME");
        currentUserSurname = getArguments().getString("USER_SURNAME");
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Početna stranica");
        textUser.setText(currentUserName + " " + currentUserSurname);
    }

    @OnClick(R.id.imageButton_tzz)
    public void onImageButtonTzzClicked(){
        TestoviMainFragment fk = new TestoviMainFragment();
        StartFragment.StartNewFragment(fk,getActivity());
    }
    @OnClick(R.id.imageButton_sv)
    public void onImageButtonSvClicked(){
        TraineeDrivingStatusFragment tdsf = new TraineeDrivingStatusFragment();
        Bundle args=new Bundle();
        args.putString("USER_ID", currentUserId);
        tdsf.setArguments(args);
        StartFragment.StartNewFragment(tdsf, getActivity());
    }
    @OnClick(R.id.imageButton_si)
    public void onImageButtonSiClicked(){
        TraineeExamStatusFragment tesf = new TraineeExamStatusFragment();
        Bundle args=new Bundle();
        args.putString("USER_ID", currentUserId);
        tesf.setArguments(args);
        StartFragment.StartNewFragment(tesf,getActivity());
    }
}
