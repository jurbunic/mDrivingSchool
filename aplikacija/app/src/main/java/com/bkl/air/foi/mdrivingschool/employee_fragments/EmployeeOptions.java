package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.bkl.air.foi.mdrivingschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Jurica Bunić on 1.2.2017..
 */

public class EmployeeOptions extends Fragment {

    SharedPreferences preferences;

    @BindView(R.id.employee_options_push)
    RadioButton notification;

    @BindView(R.id.employee_options_mail)
    RadioButton mail;


    boolean isMail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_employee_options, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Opcije");

        isMail = preferences.getBoolean("ISMAIL",false);
        if (isMail){
            mail.setChecked(true);

        }else {
            notification.setChecked(true);
        }
    }

    @OnClick(R.id.employee_options_mail)
    public void onMailClick(){
        preferences.edit().putBoolean("ISMAIL",true).apply();
    }

    @OnClick(R.id.employee_options_push)
    public void onPushClick(){
        preferences.edit().putBoolean("ISMAIL",false).apply();
    }



}
