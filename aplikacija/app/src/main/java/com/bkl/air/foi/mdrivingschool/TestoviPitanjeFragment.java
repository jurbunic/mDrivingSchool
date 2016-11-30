package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.media.Image;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        if (tipPitanja == "propisi"){
            PitanjaData.nabaviPodatkePitanja(listaPitanja);
        }
        else{
            PitanjaData.nabaviPitanjaPrvaPomoc(listaPitanja);
        }

        return calcView;
    }

    ArrayList<Button> navButtons = new ArrayList<Button>();

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Testovi znanja");

        for (int i=0; i<5;i++){
            Button navButton = new Button(getActivity().getApplicationContext());
            navButton.setText(Integer.toString(i+1));
            navButtons.add(navButton);
            LinearLayout navigationLayout = (LinearLayout) getActivity().findViewById(R.id.questionNavigation);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            navigationLayout.addView(navButton,lp);
        }
        for(int i=0; i<5;i++){
            Tocnost tocnost = new Tocnost();
            tocnost.brojPitanja = i+1;
            listaTocnosti.add(tocnost);
        }
        for (int i=0; i<navButtons.size();i++){
            Button button = navButtons.get(i);
            final int j=i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    brojPitanja.setText("Pitanje " + (j+1));


                    pitanje.setText(listaPitanja.get(poljeZadataka.get(j)).getPitanje());
                    odg1.setText(listaPitanja.get(poljeZadataka.get(j)).getOdg1());
                    odg2.setText(listaPitanja.get(poljeZadataka.get(j)).getOdg2());
                    odg3.setText(listaPitanja.get(poljeZadataka.get(j)).getOdg3());
//                    Picasso.with(getActivity()).load(listaPitanja.get(poljeZadataka.get(j)).getImgUrl()).into(slika);
                    odg1.setChecked(false);odg2.setChecked(false);odg3.setChecked(false);
                    try {
                        Tocnost tocnost = listaTocnosti.get(j);
                        if (tocnost.odgovor1 == true)
                            odg1.setChecked(true);
                        if (tocnost.odgovor2 == true) {
                            odg2.setChecked(true);
                        }
                        if (tocnost.odgovor3 == true) {
                            odg3.setChecked(true);
                        }
                    }catch (Exception a) {

                    }
                    trenutnoPitanje = j + 1;

                }
            });
        }


            pripremiPitanja();

    }
    @OnClick(R.id.button_dalje)
    public void onButtonDaljeClicked(){
        if(trenutnoPitanje <5) {
            provjeraTocnosti();
            spremiOdg(trenutnoPitanje);
            trenutnoPitanje++;
            pripremiPitanja();
        }
        else{
            provjeraTocnosti();
            Bundle args=new Bundle();
            args.putIntegerArrayList("tocniIds", tocniIds);
            args.putIntegerArrayList("randomZadaci", poljeZadataka);
            args.putString("tipPitanja", tipPitanja);
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
        //Picasso.with(getActivity()).load(listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).getImgUrl()).into(slika);
        try {
            Tocnost tocnost = listaTocnosti.get(trenutnoPitanje-1);
            if (tocnost.odgovor1 == true)
                odg1.setChecked(true);
            if (tocnost.odgovor2 == true) {
                odg2.setChecked(true);
            }
            if (tocnost.odgovor3 == true) {
                odg3.setChecked(true);
            }
        }catch (Exception a) {

        }
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

    private static class Tocnost{
        protected int brojPitanja;
        protected boolean odgovor1=false;
        protected boolean odgovor2=false;
        protected boolean odgovor3=false;

    }

    ArrayList<Tocnost> listaTocnosti = new ArrayList<>();

    private void spremiOdg(int broj){
        Tocnost tocnost = new Tocnost();
        tocnost.brojPitanja = broj-1;
        if (odg1.isChecked()==true){
            tocnost.odgovor1=true;
        }else {
            tocnost.odgovor1=false;
        }
        if (odg2.isChecked()==true){
            tocnost.odgovor2=true;
        }else {
            tocnost.odgovor2=false;
        }
        if (odg3.isChecked()==true){
            tocnost.odgovor3=true;
        }else {
            tocnost.odgovor3=false;
        }
        try {
            if(listaTocnosti.get(broj-1) != null){
                listaTocnosti.remove(broj-1);
                listaTocnosti.add(broj-1,tocnost);

            }
        }catch (Exception e){
            listaTocnosti.add(tocnost);
        }

    }
}
