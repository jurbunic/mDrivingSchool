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

import com.bkl.air.foi.database.Kontakt;
import com.bkl.air.foi.mdrivingschool.adapters.KontaktAdapter;
import com.bkl.air.foi.mdrivingschool.helpers.KontaktData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bunic on 1.11.2016..
 */

public class KontaktFragment extends Fragment  {

    private List<Kontakt> listKontakt = new ArrayList<>();
    private RecyclerView recyclerView;
    private KontaktAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kontakt, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Kontakti");
        KontaktData.loadKontaktData(listKontakt);
        recyclerView = (RecyclerView) getView().findViewById(R.id.kontakt_recycler);

        mAdapter = new KontaktAdapter(listKontakt, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
    }
}
