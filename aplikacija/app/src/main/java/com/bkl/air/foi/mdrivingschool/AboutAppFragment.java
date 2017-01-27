package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkl.air.foi.mdrivingschool.helpers.EmailSender;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 27.1.2017..
 */

public class AboutAppFragment extends Fragment {
    private EmailSender mEmailSender = new EmailSender();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_about_app,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("O aplikaciji");
    }

    @OnClick(R.id.imageButton_feedback)
    public void onButtonFeedbackClicked(){
        mEmailSender.posaljiMail("", "Aplikacija - feedback", getActivity());
    }
}
