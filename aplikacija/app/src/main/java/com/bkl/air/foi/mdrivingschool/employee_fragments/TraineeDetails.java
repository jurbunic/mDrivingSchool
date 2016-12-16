package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;

/**
 * Created by Jurica Bunić on 14.12.2016..
 */

public class TraineeDetails extends Fragment {

    String traineeId;

    TextView traineeName;
    TextView traineeSurname;
    TextView traineeAdress;
    TextView traineeDoB;
    TextView traineeMob;
    TextView traineePhone;
    TextView traineePoB;
    TextView traineeEmail;
    TextView traineeDrivingRules;
    TextView traineeFirstAid;
    TextView traineeHoursOfDriving;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_trainee_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Detalji polaznika");

        traineeName = (TextView) getActivity().findViewById(R.id.trainee_details_name);
        traineeSurname = (TextView) getActivity().findViewById(R.id.trainee_details_surname);
        traineeAdress = (TextView) getActivity().findViewById(R.id.trainee_details_address);
        traineeDoB = (TextView) getActivity().findViewById(R.id.trainee_details_dob);
        traineeMob = (TextView) getActivity().findViewById(R.id.trainee_details_mob);
        traineePhone = (TextView) getActivity().findViewById(R.id.trainee_details_phone);
        traineePoB = (TextView) getActivity().findViewById(R.id.trainee_details_pob);
        traineeEmail = (TextView) getActivity().findViewById(R.id.trainee_details_email);
        traineeDrivingRules = (TextView) getActivity().findViewById(R.id.trainee_details_pp);
        traineeFirstAid = (TextView) getActivity().findViewById(R.id.trainee_details_ppp);
        traineeHoursOfDriving = (TextView) getActivity().findViewById(R.id.trainee_details_sv);

        traineeId = getArguments().getString("id");

        UserInfo info = new UserInfo(getActivity().getApplicationContext());
        Korisnik korisnik;
        korisnik = info.getInfoById(traineeId);

        traineeName.setText(korisnik.getIme());
        traineeSurname.setText(korisnik.getPrezime());
        traineeAdress.setText(korisnik.getAdresa());
        traineeDoB.setText(korisnik.getDatum_rodenja());
        traineeMob.setText(korisnik.getMobitel());
        traineePhone.setText(korisnik.getTelefon());
        traineePoB.setText(korisnik.getMjesto_rodenja());
        traineeEmail.setText(korisnik.getEmail());
        traineeDrivingRules.setText(korisnik.getPropisi());
        traineeFirstAid.setText(korisnik.getPrva_pomoc());
        traineeHoursOfDriving.setText(Integer.toString(korisnik.getSati_voznje()));

    }
}
