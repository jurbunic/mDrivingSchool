package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkl.air.foi.core.DataLoader;
import com.bkl.air.foi.core.KontaktDataLoadedListener;
import com.bkl.air.foi.database.Kontakt;
import com.bkl.air.foi.mdrivingschool.adapters.KontaktAdapter;
import com.bkl.air.foi.mdrivingschool.helpers.KontaktData;
import com.bkl.air.foi.mdrivingschool.loaders.AppDataLoader;
import com.bkl.air.foi.mdrivingschool.loaders.DbDataLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bunic on 1.11.2016..
 */

public class KontaktFragment extends Fragment implements KontaktDataLoadedListener {

    private List<Kontakt> listKontakt = new ArrayList<>();
    private RecyclerView recyclerView;
    private KontaktAdapter mAdapter;
    private DataLoader dataLoader;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kontakt, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Kontakti");

        recyclerView = (RecyclerView) getView().findViewById(R.id.kontakt_recycler);

        requestData();

        mAdapter = new KontaktAdapter(listKontakt, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDataLoaded(ArrayList<Kontakt> listKontakt) {
        this.listKontakt = listKontakt;
    }

    /**
     * Metoda trazi/pribavlja podatke o svim kontaktima
     */
    public void requestData(){
        if(SQLite.select().from(Kontakt.class).queryList().isEmpty()){
            this.dataLoader = new AppDataLoader();
        }
        else{
            this.dataLoader = new DbDataLoader();
        }
        dataLoader.loadKontaktData(this);
    }
}
