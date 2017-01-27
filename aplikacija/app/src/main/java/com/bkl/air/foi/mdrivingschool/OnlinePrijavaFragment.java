package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bkl.air.foi.mdrivingschool.helpers.EmailSender;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dalibor on 9.11.2016..
 */

public class OnlinePrijavaFragment extends Fragment {

    private EmailSender mEmailSender = new EmailSender();

    @BindView(R.id.button_posalji)
    Button buttonPosalji;

    @BindView(R.id.editText_ime)
    EditText ime;

    @BindView(R.id.editText_prezime)
    EditText prezime;

    @BindView(R.id.editText_email)
    EditText email;

    @BindView(R.id.editText_telefon)
    EditText telefon;

    @BindView(R.id.radioGroup_kategorija)
    RadioGroup kategorijaGrupa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.fragment_online_prijava, container, false);
        ButterKnife.bind(this, View);
        return View;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Online upis");
    }


    /**
     * Metoda cita vrijednosti iz RadioGroup-a, tj. vraca kategoriju koju je korisnik odabrao
     *
     * @return Odabrana kategorija
     */
    private String nabaviKategoriju(){
        String kategorija = "";

        int radioButtonID = kategorijaGrupa.getCheckedRadioButtonId();
        View radioButton = kategorijaGrupa.findViewById(radioButtonID);
        int idx = kategorijaGrupa.indexOfChild(radioButton);

        switch(idx){
            case 0: kategorija = "A"; break;
            case 1: kategorija = "A1"; break;
            case 2: kategorija = "B"; break;
            case 3: kategorija = "M"; break;
            default: kategorija = "";
        }

        return kategorija;
    }

    /**
     * Metoda uzima vrijednosti koje je korisnik upisao preko screen-a i vraca jedan string finalne poruke
     *
     * @return String finalne poruke
     */
    private String kreiranjePoruke(){
        String finalnaPoruka = "";

        finalnaPoruka = "Ime polaznika: " + this.ime.getText().toString() + "\n"
                + "Prezime polaznika: " + this.prezime.getText().toString() + "\n"
                + "E-mail polaznika: " + this.email.getText().toString() + "\n"
                + "Telefon polaznika: " + this.telefon.getText().toString() + "\n"
                + "Kategorija koju polaznik prijavljuje: " + nabaviKategoriju();

        return finalnaPoruka;
    }

    /**
     * Metoda provjerava ako je korisnik popunio sva potrebna polja
     * @return Vraca true ako su sva polja popunjena ili false ako nisu
     */
    private boolean checkGivenData(){
        if(ime.getText().length() == 0 || prezime.getText().length() == 0 ||
                email.getText().length() == 0 || telefon.getText().length() == 0){
            Toast.makeText(getActivity().getApplicationContext(), "Molimo ispunite sva polja!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * Metoda na klik gumba otvara email client sa vec gotovom porukom preko kojeg se salje poruka
     */
    @OnClick(R.id.button_posalji)
    public void onButtonPosaljiClicked(){
        if(checkGivenData()){
            mEmailSender.posaljiMail(kreiranjePoruke(), "Novi polaznik - online upis", getActivity());
        }
    }
}
