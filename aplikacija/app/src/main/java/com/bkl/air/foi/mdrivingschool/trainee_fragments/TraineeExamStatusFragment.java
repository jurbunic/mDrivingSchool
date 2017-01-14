package com.bkl.air.foi.mdrivingschool.trainee_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Jurica Bunić on 6.1.2017..
 */

public class TraineeExamStatusFragment extends Fragment {

    @BindView(R.id.trainee_test_status_propis)
    TextView examPropisi;

    @BindView(R.id.trainee_test_status_first_aid)
    TextView examFirstAid;

    @BindView(R.id.trainee_test_status_driving)
    TextView examDrivig;

    Korisnik korisnik;
    private String currentUserId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_trainee_test_status, container, false);
        currentUserId = getArguments().getString("USER_ID");
        UserInfo info = new UserInfo(getActivity());
        korisnik = info.getInfoById(currentUserId);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Početna stranica");

        if(korisnik.getPropisi().equals("polozeno")) {
            examPropisi.setText("Položio");
            examPropisi.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        }else {
            examPropisi.setText("Nije položio");
            examPropisi.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
        if(korisnik.getPrva_pomoc().equals("polozeno")){
            examFirstAid.setText("Položio");
            examFirstAid.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        }else {
            examFirstAid.setText("Nije položio");
            examFirstAid.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
        if(korisnik.getIspit_voznje().equals("polozeno")){
            examDrivig.setText("Položio");
            examDrivig.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        }else{
            examDrivig.setText("Nije položio");
            examDrivig.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }


    }

}
