package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dalibor on 7.12.2016..
 */

public class TraineeMSFragment extends Fragment {
    @BindView(R.id.textView_user)
    TextView textUser;

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
}
