package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.database.TipPitanja;
import com.bkl.air.foi.database.Vozilo;
import com.bkl.air.foi.mdrivingschool.helpers.PitanjaData;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.helpers.VozilaData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Dalibor on 23.11.2016..
 */

public class TestoviPitanjeFragment extends Fragment {
    private int [] poljeZadataka = new int[5];
    private String tipPitanja;
    private Unbinder unbinder;
    private List<Pitanje> listaPitanja = new ArrayList<>();
    private int trenutnoPitanje;

    @BindView(R.id.textView_broj)
    TextView brojPitanja;

    @BindView(R.id.imageView_slika)
    ImageView slika;

    @BindView(R.id.textView_pitanje)
    TextView pitanje;

    @BindView(R.id.checkBox_broj1)
    CheckBox odg1;

    @BindView(R.id.checkBox_broj2)
    CheckBox odg2;

    @BindView(R.id.checkBox_broj3)
    CheckBox odg3;

    @BindView(R.id.button_dalje)
    Button dalje;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        tipPitanja=getArguments().getString("tipPitanja");
        poljeZadataka=getArguments().getIntArray("randomZadaci");
        trenutnoPitanje=getArguments().getInt("TrenutnoPitanje");
        View calcView = inflater.inflate(R.layout.fragment_testovi_pitanje, container, false);
        unbinder = ButterKnife.bind(this,calcView);
        PitanjaData.nabaviPodatkePitanja(listaPitanja);
        return calcView;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Testovi znanja");

        if(tipPitanja.equals("propisi")){
            brojPitanja.setText("Pitanje " + trenutnoPitanje);
            pitanje.setText(listaPitanja.get(trenutnoPitanje-1).getPitanje());
            odg1.setText(listaPitanja.get(trenutnoPitanje-1).getOdg1());
            odg2.setText(listaPitanja.get(trenutnoPitanje-1).getOdg2());
            odg3.setText(listaPitanja.get(trenutnoPitanje-1).getOdg3());
        }
        else{
        //to be added...
        }
    }
    @OnClick(R.id.button_dalje)
    public void onButtonDaljeClicked(){
        if(trenutnoPitanje <5) {
            Bundle args = new Bundle();
            args.putString("tipPitanja", "propisi");
            args.putIntArray("randomZadaci", poljeZadataka);
            args.putInt("TrenutnoPitanje", trenutnoPitanje + 1);
            TestoviPitanjeFragment tpf = new TestoviPitanjeFragment();
            tpf.setArguments(args);
            StartFragment.StartNewFragment(tpf, "pitanja propisa", getActivity());
        }
        else{
            Toast.makeText(getActivity(), "Kraj!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
