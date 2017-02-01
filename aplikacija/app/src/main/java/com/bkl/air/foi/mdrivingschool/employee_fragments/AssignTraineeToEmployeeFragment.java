package com.bkl.air.foi.mdrivingschool.employee_fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.bkl.air.foi.mdrivingschool.webservice.RetriveData;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;
import com.bkl.air.foi.mdrivingschool.notifications.NotificationBuilder;
import com.bkl.air.foi.mdrivingschool.notifications.NotificationDataChangedListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 26.12.2016..
 */

public class AssignTraineeToEmployeeFragment extends Fragment implements AdapterView.OnItemSelectedListener, NotificationDataChangedListener {

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
    String notificationMessage = "";
    String notificationUserId = "";
    boolean isMail;

    NotificationBuilder notificationBuilder = new NotificationBuilder();

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
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        isMail = preferences.getBoolean("ISMAIL",false);
        //Dohvaćaju se podaci o polaznicima
        allTrainees = info.getFreeTrainees(getActivity().getIntent().getStringExtra("USER"));
        allTraineesForUnassagning = info.getTrainees(getActivity().getIntent().getStringExtra("USER"));

        //Spremaju se id-jevi, imena i prezimena u privremenu listu koju vidi korisnik na spinneru
        for (Korisnik trainee : allTrainees){
            allTraineesNames.add(trainee.getId() + " - " + trainee.getIme() + " " + trainee.getPrezime());
        }
        for (Korisnik trainee : allTraineesForUnassagning){
            allTraineesNamesForUnassagning.add(trainee.getId() + " - " + trainee.getIme() + " " + trainee.getPrezime());
        }

        //Postavljaju se adapteri za prikaz imena polaznika u spinnerima
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allTraineesNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        traineesSpinner.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapterSecond = new ArrayAdapter<String>(thisContext, android.R.layout.simple_spinner_item, allTraineesNamesForUnassagning);
        dataAdapterSecond.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        traineesSpinnerSecond.setAdapter(dataAdapterSecond);
    }

    /**
     * Metoda prati stanje itema na spinneru i na temelju toga azurira trenutno odabranog polaznika
     * @param parent
     * @param view
     * @param position
     * @param id
     */
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

    /**
     * Metoda na klik gumba dodjeljuje polaznika instruktoru, salje notifikaciju polazniku i osvjezuje formu
     */
    @OnClick(R.id.button_assign_trainee)
    public void onAssignButtonPressed(){
        String chosenTraineeId = getOnlyId(chosenTraineeForAssigning);
        RetriveData retriveData = new RetriveData(thisContext);
        retriveData.execute("6","1",currentUserId,chosenTraineeId);

        //Azuriraju se poruka koja se mora slati i id polaznika kojemu se mora slati te se poziva builder da posalje notifikaciju
        notificationMessage = "Vaš_instruktor_je_ažuriran";
        notificationUserId = chosenTraineeId;
        notificationBuilder.sendNotification(this);

        refresh();

    }

    /**
     * Metoda na klik gumba oduzima polaznika instruktoru i osvjezuje formu
     */
    @OnClick(R.id.button_unassign_trainee)
    public void onUnassignButtonPressed(){
        String chosenTraineeId = getOnlyId(chosenTraineeForUnassigning);
        RetriveData retriveData = new RetriveData(thisContext);
        retriveData.execute("7","1",currentUserId,chosenTraineeId);
        refresh();
    }

    /**
     * Metoda za osvježavanje fragmenta, koristi se nakon dodavanja ili brisanja polaznika
     */
    public void refresh(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    /**
     * Metoda koja pretvara String sa id-jem, imenom i prezimenom u String samo sa id-jem
     *
     * @param fullString Cijeli String sa id-jem, imenom i prezimenom
     * @return Vraca String samo s id-jem
     */
    private String getOnlyId(String fullString){
        String id = "";
        if(fullString.contains(" ")){
            id = fullString.substring(0, fullString.indexOf(" "));
        }
        return id;
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
        return notificationUserId;
    }


    @Override
    public boolean getUserPreference() {
        return isMail;
    }
}
