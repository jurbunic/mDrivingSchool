package com.bkl.air.foi.mdrivingschool;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bkl.air.foi.mdrivingschool.helpers.VozilaData;
import com.bkl.air.foi.mdrivingschool.adapters.VozilaAdapter;
import com.bkl.air.foi.database.Vozilo;

import java.util.ArrayList;
import java.util.List;

public class VozilaFragment extends Fragment{

    private List<Vozilo> listaVozila = new ArrayList<>();
    private RecyclerView recyclerView;
    private VozilaAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vozila, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        recyclerView = (RecyclerView) getView().findViewById(R.id.main_recycler);

        mAdapter = new VozilaAdapter(listaVozila, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        VozilaData.nabaviPodatkeVozila(listaVozila);
        mAdapter.notifyDataSetChanged();
    }

}
