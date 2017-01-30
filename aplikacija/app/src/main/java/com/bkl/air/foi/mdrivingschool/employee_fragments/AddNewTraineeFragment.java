package com.bkl.air.foi.mdrivingschool.employee_fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bkl.air.foi.mdrivingschool.R;
import com.bkl.air.foi.mdrivingschool.helpers.DateAndTimeCheck;
import com.bkl.air.foi.mdrivingschool.webservice.RetriveData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 12.12.2016..
 */

public class AddNewTraineeFragment extends Fragment {

    String sName, sSurname, sBornDate, sBornPlace, sMobile, sPhone, sEmail,sAdress, sUsername, sPassword;
    Context thisContext;

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
        thisContext = container.getContext();
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Dodavanje novog polaznika");
    }
    /**
     * Metoda provjerava ako je korisnik popunio sva potrebna polja za dodavanje polaznika
     *
     * @return Vraca true ako su sva polja popunjena, false ako nisu
     */
    private boolean checkGivenData(){
        if(name.getText().length() == 0 || surname.getText().length() == 0 || bornDate.getText().length() == 0
                || bornPlace.getText().length() == 0 || mobile.getText().length() == 0 || phone.getText().length() == 0
                || email.getText().length() == 0 || adress.getText().length() == 0 || username.getText().length() == 0
                || password.getText().length() == 0){
            Toast.makeText(thisContext, "Molimo ispunite sva polja! ('0' ako je podatak nepoznat)", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * Metoda na klik gumba cita podatke iz forme koje je korisnik unio i salje ih na web server
     */
    @OnClick(R.id.button_add_trainee)
    public void onButtonAddTraineeClick(){
        if(checkGivenData()) {
            sName = name.getText().toString();
            sSurname = surname.getText().toString();
            sBornDate = bornDate.getText().toString();
            sBornPlace = bornPlace.getText().toString();
            sMobile = mobile.getText().toString();
            sPhone = phone.getText().toString();
            sEmail = email.getText().toString();
            sAdress = adress.getText().toString();
            sUsername = username.getText().toString();
            sPassword = password.getText().toString();

            // Provjerava se ispravnost unešenog vremena
            if (!(DateAndTimeCheck.isDateValid(sBornDate))) {
                Toast.makeText(getActivity().getApplicationContext(), "Pogrešan datum", Toast.LENGTH_SHORT).show();
            } else {
                RetriveData retriveData = new RetriveData(thisContext);
                retriveData.execute("4", "1", sName, sSurname, sBornDate, sBornPlace, sMobile, sPhone, sEmail, sAdress, sUsername, sPassword);

                name.setText("");
                surname.setText("");
                bornDate.setText("");
                bornPlace.setText("");
                mobile.setText("");
                phone.setText("");
                email.setText("");
                adress.setText("");
                username.setText("");
                password.setText("");
            }
        }

    }
}
