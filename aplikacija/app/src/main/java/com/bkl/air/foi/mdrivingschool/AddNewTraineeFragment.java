package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dalibor on 12.12.2016..
 */

public class AddNewTraineeFragment extends Fragment {

    @BindView(R.id.editText_name_p)
    EditText name;

    @BindView(R.id.editText_surname_p)
    EditText surname;

    @BindView(R.id.editText_adress_p)
    EditText adress;

    @BindView(R.id.editText_bornDate_p)
    EditText bornDate;

    @BindView(R.id.editText_bornPlace_p)
    EditText bornPlace;

    @BindView(R.id.editText_mobile_p)
    EditText mobile;

    @BindView(R.id.editText_phone_p)
    EditText phone;

    @BindView(R.id.editText_email_p)
    EditText email;

    @BindView(R.id.editText_username_p)
    EditText username;

    @BindView(R.id.editText_password_p)
    EditText password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_add_new_trainee,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Dodavanje novog polaznika");
    }
}
