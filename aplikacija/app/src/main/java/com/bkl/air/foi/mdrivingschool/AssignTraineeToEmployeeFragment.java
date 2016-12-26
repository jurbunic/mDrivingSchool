package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 26.12.2016..
 */

public class AssignTraineeToEmployeeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Context thisContext;

    @BindView(R.id.textView_dp_employee_name)
    TextView employeeNameTextView;

    @BindView(R.id.spinner_ip)
    Spinner traineesSpinner;

    String chosenTrainee = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_assign_trainee_to_employee,container,false);
        ButterKnife.bind(this, view);
        thisContext = container.getContext();
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Dodjela polaznika instruktoru");

        UserInfo info = new UserInfo(getActivity().getApplicationContext());
        Korisnik korisnik = info.getInfoById(getActivity().getIntent().getStringExtra("USER"));

        employeeNameTextView.setText(korisnik.getIme()+" "+korisnik.getPrezime());

        traineesSpinner.setOnItemSelectedListener(this);

        List<String> allTraineesNames = new ArrayList<String>();

        ArrayList<Korisnik> allTrainees = new ArrayList<>();

        //Dohvaćaju se podaci o svim polaznicima
        allTrainees = info.getTrainees(getActivity().getIntent().getStringExtra("USER"));

        //Spremaju se id-jevi, imena i prezimena u privremenu listu koju vidi korisnik na spinneru
        for (Korisnik trainee : allTrainees){
            allTraineesNames.add(trainee.getId() + " - " + trainee.getIme() + " " + trainee.getPrezime());
        }

        //Postavlja se adapter za prikaz imena polaznika u spinneru
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allTraineesNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        traineesSpinner.setAdapter(dataAdapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        chosenTrainee = item;
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    @OnClick(R.id.button_assign_trainee)
    public void onAssignButtonPressed(){

        //Dobivanje id-a iz cijelog stringa, sada chosenTraineeId sadrži id odabranog polaznika
        String chosenTraineeId = "";
        if(chosenTrainee.contains(" ")){
            chosenTraineeId= chosenTrainee.substring(0, chosenTrainee.indexOf(" "));
        }

    }
}
