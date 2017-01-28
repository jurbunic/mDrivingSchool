package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkl.air.foi.core.DataLoader;
import com.bkl.air.foi.core.VoziloDataLoadedListener;
import com.bkl.air.foi.mdrivingschool.adapters.VozilaAdapter;
import com.bkl.air.foi.database.Vozilo;
import com.bkl.air.foi.mdrivingschool.loaders.AppDataLoader;
import com.bkl.air.foi.mdrivingschool.loaders.DbDataLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

public class VozilaFragment extends Fragment implements VoziloDataLoadedListener{

    private List<Vozilo> listaVozila = new ArrayList<>();
    private RecyclerView recyclerView;
    private VozilaAdapter mAdapter;
    private DataLoader dataLoader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vozila, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Vozila");
        recyclerView = (RecyclerView) getView().findViewById(R.id.main_recycler);

        requestData();

        mAdapter = new VozilaAdapter(listaVozila, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * Predefinirana metoda koja postavlja listu vozila u koju moraju doci podaci
     *
     * @param listVozilo Lista vozila
     */
    @Override
    public void onDataLoaded(ArrayList<Vozilo> listVozilo) {
        this.listaVozila = listVozilo;
    }

    /**
     * Metoda trazi/pribavlja podatke o svim vozilima
     */
    public void requestData(){
        if(SQLite.select().from(Vozilo.class).queryList().isEmpty()){
            dataLoader = new AppDataLoader();
        }
        else{
            dataLoader = new DbDataLoader();
        }
        dataLoader.loadVoziloData(this);
    }
}
