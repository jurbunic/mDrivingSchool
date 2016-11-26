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
import com.squareup.picasso.Picasso;

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
    private ArrayList<Integer> poljeZadataka = new ArrayList<Integer>(5);
    private String tipPitanja;
    private Unbinder unbinder;
    private List<Pitanje> listaPitanja = new ArrayList<>();
    private int trenutnoPitanje = 1;
    private int tocniOdgovori = 0;

    private ArrayList<Integer> tocniIds = new ArrayList<>(5);

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
        poljeZadataka=getArguments().getIntegerArrayList("randomZadaci");
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
            pripremiPitanja();
        }
        else{
        //to be added...
        }
    }
    @OnClick(R.id.button_dalje)
    public void onButtonDaljeClicked(){
        if(trenutnoPitanje <5) {
            provjeraTocnosti();
            trenutnoPitanje++;
            pripremiPitanja();
        }
        else{
            provjeraTocnosti();
            Bundle args=new Bundle();
            args.putIntegerArrayList("tocniIds", tocniIds);
            args.putIntegerArrayList("randomZadaci", poljeZadataka);
            args.putInt("Tocnost", tocniOdgovori);
            TestoviRezultatiFragment trf = new TestoviRezultatiFragment();
            trf.setArguments(args);
            StartFragment.StartNewFragment(trf,"rezultati testova",getActivity());
        }
    }

    //metoda priprema graficko sucelje za novo nadolazece pitanje
    private void pripremiPitanja(){
        brojPitanja.setText("Pitanje " + trenutnoPitanje);
        odg1.setChecked(false); odg2.setChecked(false); odg3.setChecked(false);
        pitanje.setText(listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).getPitanje());
        odg1.setText(listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).getOdg1());
        odg2.setText(listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).getOdg2());
        odg3.setText(listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).getOdg3());
        Picasso.with(getActivity()).load(listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).getImgUrl()).into(slika);
    }

    //metoda provjerava tocnost odgovora koje je korisnik dao, tj. usporeduje checkbox sa predefiniranom tocnosti odgovora
    private void provjeraTocnosti() {
        int stanjeTocnosti = 0;
        if((odg1.isChecked() == true && listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).isTocan1() == true)
                || (odg1.isChecked() == false && listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).isTocan1() == false)){
            stanjeTocnosti++;
        }
        if((odg2.isChecked() == true && listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).isTocan2() == true)
                || (odg2.isChecked() == false && listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).isTocan2() == false)){
            stanjeTocnosti++;
        }
        if((odg3.isChecked() == true && listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).isTocan3() == true)
                || (odg3.isChecked() == false && listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).isTocan3() == false)){
            stanjeTocnosti++;
        }
        if(stanjeTocnosti == 3){
            tocniOdgovori++;
            tocniIds.add(listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).getId());
        }
        else{
            tocniIds.add(999);
        }
    }
}
