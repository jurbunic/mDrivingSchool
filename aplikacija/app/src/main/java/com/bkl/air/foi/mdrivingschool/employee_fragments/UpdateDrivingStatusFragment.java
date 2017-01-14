package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.RetriveData;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HP on 14.1.2017..
 */

public class UpdateDrivingStatusFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.spinner_ip_update_driving)
    Spinner traineeSpinner;

    @BindView(R.id.textView_current_hours)
    TextView currentStatusHours;

    @BindView(R.id.editText_driving_hours)
    EditText drivingHaurs;

    @BindView(R.id.editText_date)
    EditText dateSession;

    @BindView(R.id.editText_time)
    EditText timeSession;

    Context thisContext;
    String currentUserId;
    String chosenTraineeID;
    String dodajSat;
    String date;
    String time;

    ArrayList<Korisnik> allTrainees = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_driving_status,container,false);
        ButterKnife.bind(this,view);
        thisContext = container.getContext();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Ažuriranje statusa vožnje");
        UserInfo userInfo = new UserInfo(getActivity().getApplicationContext());
        Korisnik korisnik = userInfo.getInfoById(getActivity().getIntent().getStringExtra("USER"));

        currentUserId = getActivity().getIntent().getStringExtra("USER");

        List<String> allTraineesNames = new ArrayList<>();

        allTrainees = userInfo.getTrainees(getActivity().getIntent().getStringExtra("USER"));

        for(Korisnik trainee : allTrainees){
            allTraineesNames.add(trainee.getId() + " - " + trainee.getIme() + " " + trainee.getPrezime());
        }

        traineeSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(thisContext,android.R.layout.simple_spinner_item,allTraineesNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        traineeSpinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        chosenTraineeID = item;
        chosenTraineeID = getOnlyId(chosenTraineeID);
        for(Korisnik trainee: allTrainees){
            if(chosenTraineeID.equals(String.valueOf(trainee.getId()))){
                currentStatusHours.setText(String.valueOf(trainee.getSati_voznje()));
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick(R.id.button_update_hours)
    public void onButtonUpdateHoursClick(){
        dodajSat = drivingHaurs.getText().toString();
        RetriveData retriveData = new RetriveData(thisContext);
        retriveData.execute("9","1",chosenTraineeID,dodajSat);
        refresh();
    }

    @OnClick(R.id.button_update_session)
    public void onButtonUpdateSessionClick(){
        date = dateSession.getText().toString();
        time = timeSession.getText().toString();
        RetriveData retriveData = new RetriveData(thisContext);
        retriveData.execute("10","1",chosenTraineeID,date,time);
        refresh();
    }

    private String getOnlyId(String fullString){
        String id = "";
        if(fullString.contains(" ")){
            id = fullString.substring(0, fullString.indexOf(" "));
        }
        return id;
    }

    public void refresh(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
}
