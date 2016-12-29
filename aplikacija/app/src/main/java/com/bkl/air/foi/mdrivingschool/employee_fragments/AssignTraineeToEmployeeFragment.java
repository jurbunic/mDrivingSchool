package com.bkl.air.foi.mdrivingschool.employee_fragments;

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
import android.widget.Toast;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.RetriveData;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
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

    @BindView(R.id.textView_dp_employee_name2)
    TextView employeeNameTextViewSecond;

    @BindView(R.id.spinner_ip)
    Spinner traineesSpinner;

    @BindView(R.id.spinner_ip_second)
    Spinner traineesSpinnerSecond;

    String currentUserId = "";

    String chosenTraineeForAssigning = "";
    String chosenTraineeForUnassigning = "";

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

        //U ovoj se varijabli sprema id prijavljenog zaposlenika da bude dohvativ u svim metodama
        currentUserId = getActivity().getIntent().getStringExtra("USER");

        employeeNameTextView.setText(korisnik.getIme()+" "+korisnik.getPrezime());
        employeeNameTextViewSecond.setText(korisnik.getIme()+" "+korisnik.getPrezime());

        traineesSpinner.setOnItemSelectedListener(this);
        traineesSpinnerSecond.setOnItemSelectedListener(this);

        List<String> allTraineesNames = new ArrayList<String>();
        ArrayList<Korisnik> allTrainees = new ArrayList<>();

        List<String> allTraineesNamesForUnassagning = new ArrayList<String>();
        ArrayList<Korisnik> allTraineesForUnassagning = new ArrayList<>();

        //Dohvaćaju se podaci o svim polaznicima
        allTrainees = info.getFreeTrainees(getActivity().getIntent().getStringExtra("USER"));

        allTraineesForUnassagning = info.getTrainees(getActivity().getIntent().getStringExtra("USER"));

        //Spremaju se id-jevi, imena i prezimena u privremenu listu koju vidi korisnik na spinneru
        for (Korisnik trainee : allTrainees){
            allTraineesNames.add(trainee.getId() + " - " + trainee.getIme() + " " + trainee.getPrezime());
        }

        for (Korisnik trainee : allTraineesForUnassagning){
            allTraineesNamesForUnassagning.add(trainee.getId() + " - " + trainee.getIme() + " " + trainee.getPrezime());
        }

        //Postavlja se adapter za prikaz imena polaznika u spinneru
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allTraineesNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        traineesSpinner.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapterSecond = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allTraineesNamesForUnassagning);
        dataAdapterSecond.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        traineesSpinnerSecond.setAdapter(dataAdapterSecond);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spinner_ip:
                String item = parent.getItemAtPosition(position).toString();
                chosenTraineeForAssigning = item;
                break;
            case R.id.spinner_ip_second:
                String itemSecond = parent.getItemAtPosition(position).toString();
                chosenTraineeForUnassigning = itemSecond;
                break;
            default:
                break;
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    @OnClick(R.id.button_assign_trainee)
    public void onAssignButtonPressed(){

        //Dobivanje id-a iz cijelog stringa, sada chosenTraineeId sadrži id odabranog polaznika
        String chosenTraineeId = "";
        if(chosenTraineeForAssigning.contains(" ")){
            chosenTraineeId= chosenTraineeForAssigning.substring(0, chosenTraineeForAssigning.indexOf(" "));
        }
        RetriveData retriveData = new RetriveData(thisContext);
        retriveData.execute("6","1",currentUserId,chosenTraineeId);

    }
    @OnClick(R.id.button_unassign_trainee)
    public void onUnassignButtonPressed(){
        String chosenTraineeId = "";
        if(chosenTraineeForUnassigning.contains(" ")){
            chosenTraineeId= chosenTraineeForUnassigning.substring(0, chosenTraineeForUnassigning.indexOf(" "));
        }
        Toast.makeText(thisContext,"Instruktor id: "+currentUserId+", polaznik id: "+chosenTraineeId,Toast.LENGTH_SHORT).show();
    }
}
