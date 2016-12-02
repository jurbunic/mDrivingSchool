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
import com.bkl.air.foi.database.Pitanje_Table;
import com.bkl.air.foi.database.TipPitanja;
import com.bkl.air.foi.database.Vozilo;
import com.bkl.air.foi.mdrivingschool.helpers.PitanjaData;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.helpers.VozilaData;
import com.raizlabs.android.dbflow.sql.language.SQLite;
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
    private int lastOpenedQuestion = 1;
    private int imgId = 0;



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
            if(SQLite.select().from(Pitanje.class).where(Pitanje_Table.id_tipa_id.eq(1)).queryList().isEmpty()){
                PitanjaData.nabaviPitanjaPropisi(listaPitanja);
            }
            else{
                listaPitanja = Pitanje.getOnlyPropisi();
            }
        }
        else{
            if(SQLite.select().from(Pitanje.class).where(Pitanje_Table.id_tipa_id.eq(2)).queryList().isEmpty()){
                PitanjaData.nabaviPitanjaPrvaPomoc(listaPitanja);
            }
            else{
                listaPitanja = Pitanje.getOnlyPrvaPomoc();
            }
        }

        return calcView;
    }

    ArrayList<Button> navButtons = new ArrayList<Button>();

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Testovi znanja");

        final Button navButton = (Button) getActivity().findViewById(R.id.button_nav_test1);
        navButtons.add(navButton);
        Button navButton1 = (Button) getActivity().findViewById(R.id.button_nav_test2);
        navButtons.add(navButton1);
        Button navButton2 = (Button) getActivity().findViewById(R.id.button_nav_test3);
        navButtons.add(navButton2);
        Button navButton3 = (Button) getActivity().findViewById(R.id.button_nav_test4);
        navButtons.add(navButton3);
        Button navButton4 = (Button) getActivity().findViewById(R.id.button_nav_test5);
        navButtons.add(navButton4);

        navButton.setEnabled(false);
        for(int i=0; i<5;i++){
            Tocnost tocnost = new Tocnost();
            tocnost.brojPitanja = i+1;
            listaTocnosti.add(tocnost);
            tocniIds.add(999);
        }
        for (int i=0; i<navButtons.size();i++){
            Button button = navButtons.get(i);
            final int j=i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    brojPitanja.setText("Pitanje " + (j+1));

                    //Spremanje trenutno otvorenog pitanja
                    spremiOdg(lastOpenedQuestion);
                    provjeraTocnosti();
                    navButtons.get(lastOpenedQuestion-1).setEnabled(true);
                    pripremiPitanja(j);
                    trenutnoPitanje = j+1;
                    lastOpenedQuestion = j+1;

                    navButtons.get(j).setEnabled(false);

                }
            });
        }

            brojPitanja.setText("Pitanje " + trenutnoPitanje);
            pripremiPitanja(trenutnoPitanje-1);

    }
    @OnClick(R.id.button_dalje)
    public void onButtonDaljeClicked(){
        navButtons.get(trenutnoPitanje-1).setEnabled(true);
        if(trenutnoPitanje <5) {
            provjeraTocnosti();
            spremiOdg(trenutnoPitanje);
            navButtons.get(trenutnoPitanje).setEnabled(false);
            trenutnoPitanje++;
            lastOpenedQuestion = trenutnoPitanje;
            brojPitanja.setText("Pitanje " + trenutnoPitanje);
            pripremiPitanja(trenutnoPitanje-1);
        }
        else{
            tocniOdgovori=0;
            provjeraTocnosti();
            for (int i=0; i<tocniIds.size();i++){
                if(tocniIds.get(i) != 999){
                    tocniOdgovori++;
                }
            }
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

    //metoda priprema graficko sucelje za novo nadolazece pitanje, parametar tp označava broj trenutnog pitanja
    private void pripremiPitanja(int tp){
        odg1.setChecked(false); odg2.setChecked(false); odg3.setChecked(false);
        pitanje.setText(listaPitanja.get(poljeZadataka.get(tp)).getPitanje());
        odg1.setText(listaPitanja.get(poljeZadataka.get(tp)).getOdg1());
        odg2.setText(listaPitanja.get(poljeZadataka.get(tp)).getOdg2());
        odg3.setText(listaPitanja.get(poljeZadataka.get(tp)).getOdg3());
        imgId = getResources().getIdentifier(listaPitanja.get(poljeZadataka.get(tp)).getImgUrl(), "drawable", getActivity().getPackageName());
        slika.setImageDrawable(getResources().getDrawable(imgId));

        try {
            Tocnost tocnost = listaTocnosti.get(tp);
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
           // tocniOdgovori++;
            tocniIds.remove(lastOpenedQuestion-1);
            tocniIds.add(lastOpenedQuestion-1,listaPitanja.get(poljeZadataka.get(trenutnoPitanje-1)).getId());
        }
        else{
            tocniIds.remove(lastOpenedQuestion-1);
            tocniIds.add(lastOpenedQuestion-1, 999);
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
