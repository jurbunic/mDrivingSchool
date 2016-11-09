package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dalibor on 9.11.2016..
 */

public class OnlinePrijavaFragment extends Fragment {

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

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void posaljiMail(String poruka){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"dadolg22@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Novi polaznik - online upis");
        i.putExtra(Intent.EXTRA_TEXT, poruka);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(Intent.createChooser(i, "Mail se šalje..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "Nažalost, nije pronađen e-mail client na vašem uređaju.", Toast.LENGTH_LONG).show();
        }
    }

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
        posaljiMail(kreiranjePoruke());
        Toast.makeText(getActivity(), kreiranjePoruke(), Toast.LENGTH_SHORT).show();
    }
}
