package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_trainee_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        traineeName = (TextView) getActivity().findViewById(R.id.trainee_details_name);
        traineeSurname = (TextView) getActivity().findViewById(R.id.trainee_details_surname);
        traineeAdress = (TextView) getActivity().findViewById(R.id.trainee_details_address);
        traineeDoB = (TextView) getActivity().findViewById(R.id.trainee_details_dob);
        traineeMob = (TextView) getActivity().findViewById(R.id.trainee_details_mob);
        traineePhone = (TextView) getActivity().findViewById(R.id.trainee_details_phone);

        traineeId = getArguments().getString("id");

        UserInfo info = new UserInfo(getActivity().getApplicationContext());
        Korisnik korisnik;
        korisnik = info.getInfoById(traineeId);

        traineeName.setText(traineeName.getText()+korisnik.getIme());
        traineeSurname.setText(traineeSurname.getText()+korisnik.getPrezime());
        traineeAdress.setText(traineeAdress.getText()+korisnik.getAdresa());
        traineeDoB.setText(traineeDoB.getText()+korisnik.getDatum_rodenja());
        traineeMob.setText(traineeMob.getText()+korisnik.getMobitel());
        traineePhone.setText(traineePhone.getText()+korisnik.getTelefon());

    }
}
