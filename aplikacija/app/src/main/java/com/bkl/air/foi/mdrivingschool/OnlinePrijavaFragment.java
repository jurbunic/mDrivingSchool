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

    private Unbinder unbinder;

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
        View calcView = inflater.inflate(R.layout.fragment_online_prijava, container, false);

        unbinder = ButterKnife.bind(this, calcView);

        return calcView;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Online upis");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /**
     * nabaviKategoriju metoda čita vrijednosti iz RadioGroup-a, tj. vraća kategoriju koju je korisnik odabrao
     * @return
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
     * kreiranjePoruke metoda uzima vrijednosti koje je korisnik upisao preko screen-a i vraća jedan string finalne poruke
     *
     * @return
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

    @OnClick(R.id.button_posalji)
    public void onButtonPosaljiClicked(){
        mEmailSender.posaljiMail(kreiranjePoruke(), "Novi polaznik - online upis", getActivity());
    }
}
