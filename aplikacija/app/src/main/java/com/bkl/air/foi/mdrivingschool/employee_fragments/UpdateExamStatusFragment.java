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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 11.1.2017..
 */

public class UpdateExamStatusFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    @BindView(R.id.textView_ts_propisi)
    TextView currentStatusPropisi;

    @BindView(R.id.textView_ts_prvaPomoc)
    TextView currentStatusPrvaPomoc;

    @BindView(R.id.textView_ts_voznja)
    TextView currentStatusVoznja;

    @BindView(R.id.spinner_ip_update_exam)
    Spinner traineesSpinner;

    @BindView(R.id.spinner_update_propisi)
    Spinner propisiSpinner;

    @BindView(R.id.spinner_update_prvaPomoc)
    Spinner prvaPomocSpinner;

    @BindView(R.id.spinner_update_voznja)
    Spinner voznjaSpinner;

    Context thisContext;

    String currentUserId = "";

    String chosenTraineeId = "";

    String chosenStatusPropisi = "";

    String chosenStatusPrvaPomoc = "";

    String chosenStatusVoznja = "";

    ArrayList<Korisnik> allTrainees = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_update_exam_status,container,false);
        ButterKnife.bind(this, view);
        thisContext = container.getContext();
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Ažuriranje statusa ispita");

        UserInfo info = new UserInfo(getActivity().getApplicationContext());
        Korisnik korisnik = info.getInfoById(getActivity().getIntent().getStringExtra("USER"));

        currentUserId = getActivity().getIntent().getStringExtra("USER");

        List<String> allTraineesNames = new ArrayList<String>();

        allTrainees = info.getTrainees(getActivity().getIntent().getStringExtra("USER"));

        for (Korisnik trainee : allTrainees){
            allTraineesNames.add(trainee.getId() + " - " + trainee.getIme() + " " + trainee.getPrezime());
        }

        List<String> allStatuses = new ArrayList<String>();
        allStatuses.add("polozeno");
        allStatuses.add("nepolozeno");

        traineesSpinner.setOnItemSelectedListener(this);
        propisiSpinner.setOnItemSelectedListener(this);
        prvaPomocSpinner.setOnItemSelectedListener(this);
        voznjaSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allTraineesNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        traineesSpinner.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allStatuses);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        propisiSpinner.setAdapter(dataAdapter2);

        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allStatuses);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prvaPomocSpinner.setAdapter(dataAdapter3);

        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allStatuses);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        voznjaSpinner.setAdapter(dataAdapter4);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spinner_ip_update_exam:
                String item = parent.getItemAtPosition(position).toString();
                String chosenTraineeName = item;
                chosenTraineeId = getOnlyId(chosenTraineeName);
                for (Korisnik trainee : allTrainees){
                    if(chosenTraineeId.equals(String.valueOf(trainee.getId()))){
                        currentStatusPropisi.setText(String.valueOf(trainee.getPropisi()));
                        currentStatusPrvaPomoc.setText(String.valueOf(trainee.getPrva_pomoc()));
                        currentStatusVoznja.setText(String.valueOf(trainee.getSati_voznje())); //potrebna promjena za novi atribut
                    }
                }
                break;
            case R.id.spinner_update_propisi:
                String item2 = parent.getItemAtPosition(position).toString();
                chosenStatusPropisi = item2;
                break;
            case R.id.spinner_update_prvaPomoc:
                String item3 = parent.getItemAtPosition(position).toString();
                chosenStatusPrvaPomoc = item3;
                break;
            case R.id.spinner_update_voznja:
                String item4 = parent.getItemAtPosition(position).toString();
                chosenStatusVoznja = item4;
            default:
                break;
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }
    private String getOnlyId(String fullString){
        String id = "";
        if(fullString.contains(" ")){
            id = fullString.substring(0, fullString.indexOf(" "));
        }
        return id;
    }

    @OnClick(R.id.button_update_exams)
    public void onButtonUpdateExamsPressed(){
        Toast.makeText(thisContext, chosenTraineeId + chosenStatusPropisi + chosenStatusPrvaPomoc + chosenStatusVoznja, Toast.LENGTH_SHORT).show();
    }
}
