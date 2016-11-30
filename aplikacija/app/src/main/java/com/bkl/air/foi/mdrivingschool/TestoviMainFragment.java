package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.database.TipPitanja;
import com.bkl.air.foi.mdrivingschool.helpers.PitanjaData;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dalibor on 23.11.2016..
 */

public class TestoviMainFragment extends Fragment {

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View calcView = inflater.inflate(R.layout.fragment_testovi_main, container, false);
        unbinder = ButterKnife.bind(this,calcView);
        return calcView;
    }

    @Override
    public void onStart(){
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Testovi znanja");

    }
    @OnClick(R.id.button_propisi)
    public void onPropisiButtonClicked(){
        ArrayList<Integer> poljeZadataka = new ArrayList<Integer>(5);
        generiranjeRandomBrojeva(5, 20, poljeZadataka);

        Bundle args=new Bundle();
        args.putString("tipPitanja", "propisi");
        args.putIntegerArrayList("randomZadaci", poljeZadataka);
        TestoviPitanjeFragment tpf = new TestoviPitanjeFragment();
        tpf.setArguments(args);
        StartFragment.StartNewFragment(tpf,"pitanja propisa",getActivity());
    }

    @OnClick(R.id.button_prvaPomoc)
    public void onPrvaPomocClicked(){
        ArrayList<Integer> poljeZadataka = new ArrayList<>(5);
        generiranjeRandomBrojeva(5,12, poljeZadataka);

        Bundle args = new Bundle();
        args.putString("tipPitanja", "prvaPomoc");
        args.putIntegerArrayList("randomZadaci", poljeZadataka);
        TestoviPitanjeFragment tpf = new TestoviPitanjeFragment();
        tpf.setArguments(args);
        StartFragment.StartNewFragment(tpf,"",getActivity());
    }

    //metoda generira polje od n elemenata. Ti elementi su random brojevi (int) koji se ne ponavljaju
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
