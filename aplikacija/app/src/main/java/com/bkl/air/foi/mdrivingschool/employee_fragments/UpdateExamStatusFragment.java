package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
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

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.RetriveData;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;
import com.bkl.air.foi.mdrivingschool.notifications.NotificationBuilder;
import com.bkl.air.foi.mdrivingschool.notifications.NotificationDataChangedListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 11.1.2017..
 */

public class UpdateExamStatusFragment extends Fragment implements AdapterView.OnItemSelectedListener, NotificationDataChangedListener{

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

    String notificationMessage = "";

    ArrayList<Korisnik> allTrainees = new ArrayList<>();

    NotificationBuilder notificationBuilder = new NotificationBuilder();

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

        //Postavljaju se adapteri za prikaz podataka
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

    /**
     * Metoda prati stanje spinnera i na temelju nega azurira odabrane polaznike/ispite
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
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
                        currentStatusVoznja.setText(String.valueOf(trainee.getIspit_voznje()));
                        setSpinnerStartValue(trainee.getPropisi(), trainee.getPrva_pomoc(), trainee.getIspit_voznje());
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

    /**
     * Metoda koja iz cijelog stringa uzetog sa spinnera uzima samo id polaznika
     *
     * @param fullString Cijeli string
     * @return Vraca se id polaznika
     */
    private String getOnlyId(String fullString){
        String id = "";
        if(fullString.contains(" ")){
            id = fullString.substring(0, fullString.indexOf(" "));
        }
        return id;
    }

    /**
     * Metoda na klik gumba azurira stanje ispita polaznika i salje notifikaciju polazniku
     */
    @OnClick(R.id.button_update_exams)
    public void onButtonUpdateExamsPressed(){
        RetriveData retriveData = new RetriveData(thisContext);
        retriveData.execute("8","1",chosenTraineeId,chosenStatusPropisi,chosenStatusPrvaPomoc,chosenStatusVoznja);

        notificationMessage = "Ažuriran_status_ispita";
        notificationBuilder.sendNotification(this);

        refresh();
    }

    /**
     * Metoda koja ponovno pokreće fragment nakon što je ažurirano stranje
     */
    public void refresh(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    /**
     * Metoda provjerava trenutni status pojedinog ispita polaznika i postavlja pocetne vrijednosti spinnera
     *
     * @param propisiStatus Status ispita propisa
     * @param prvaPomocStatus Status ispita prve pomoci
     * @param voznjaStatus Status ispita voznje
     */
    public void setSpinnerStartValue(String propisiStatus, String prvaPomocStatus, String voznjaStatus){
        String negativeStatus = "nepolozeno";
        if(propisiStatus.equals(negativeStatus)){
            propisiSpinner.setSelection(1);
        }
        else{
            propisiSpinner.setSelection(0);
        }
        if(prvaPomocStatus.equals(negativeStatus)){
            prvaPomocSpinner.setSelection(1);
        }
        else{
            prvaPomocSpinner.setSelection(0);
        }
        if(voznjaStatus.equals(negativeStatus)){
            voznjaSpinner.setSelection(1);
        }
        else{
            voznjaSpinner.setSelection(0);
        }
    }

    /**
     * Predefinirana metoda koja prati trenutnu poruku za slanje u notifikaciji
     *
     * @return Vraca poruku notifikacije
     */
    @Override
    public String getNotificationMessage() {
        return notificationMessage;
    }

    /**
     * Predefinirana metoda koja prati trenutnog polaznika kojem treba slati notifikaciju
     *
     * @return Vraca id polaznika kojem se salje notifikacija
     */
    @Override
    public String getUserId() {
        return chosenTraineeId;
    }
}
