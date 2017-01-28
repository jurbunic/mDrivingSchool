package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;

import java.util.ArrayList;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dalibor on 23.11.2016..
 */

public class TestoviMainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_testovi_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Testovi znanja");

    }

    /**
     * Metoda na klik gumba otvara fragment za rjesavanje testova znanja propisa
     */
    @OnClick(R.id.button_propisi)
    public void onPropisiButtonClicked(){
        ArrayList<Integer> poljeZadataka = new ArrayList<Integer>(5);
        generiranjeRandomBrojeva(5, 20, poljeZadataka);

        Bundle args=new Bundle();
        args.putString("tipPitanja", "propisi");
        args.putIntegerArrayList("randomZadaci", poljeZadataka);
        TestoviPitanjeFragment tpf = new TestoviPitanjeFragment();
        tpf.setArguments(args);
        StartFragment.StartNewFragment(tpf,getActivity(),"propisi");
    }

    /**
     * Metoda na klik gumba otvara fragment za rjesavanje testova znanja prve pomoci
     */
    @OnClick(R.id.button_prvaPomoc)
    public void onPrvaPomocClicked(){
        ArrayList<Integer> poljeZadataka = new ArrayList<>(5);
        generiranjeRandomBrojeva(5,12, poljeZadataka);

        Bundle args = new Bundle();
        args.putString("tipPitanja", "prvaPomoc");
        args.putIntegerArrayList("randomZadaci", poljeZadataka);
        TestoviPitanjeFragment tpf = new TestoviPitanjeFragment();
        tpf.setArguments(args);
        StartFragment.StartNewFragment(tpf,getActivity(),"prvapomoc");
    }

    /**
     * Metoda generira polje od n elemenata. Ti elementi su random brojevi (int) koji se ne ponavljaju
     *
     * @param n Broj elemenata koje zelimo dobiti u polju
     * @param opseg Opseg generiranih brojeva
     * @param polje Polje u koje se generirani brojevi salju
     */
    private void generiranjeRandomBrojeva(int n,int opseg,  ArrayList<Integer> polje){
        Random rand = new Random();
        while(polje.size() < n){
            int randomBroj = rand.nextInt(opseg);
            if (!polje.contains(randomBroj)) {
                polje.add(randomBroj);
            }
        }
    }
}
