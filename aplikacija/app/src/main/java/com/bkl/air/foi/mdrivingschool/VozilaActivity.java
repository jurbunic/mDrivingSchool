package com.bkl.air.foi.mdrivingschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bkl.air.foi.mdrivingschool.helpers.VozilaData;
import com.bkl.air.foi.mdrivingschool.adapters.VozilaAdapter;
import com.bkl.air.foi.database.Vozilo;

import java.util.ArrayList;
import java.util.List;

public class VozilaActivity extends AppCompatActivity {

    private List<Vozilo> listaVozila = new ArrayList<>();
    private RecyclerView recyclerView;
    private VozilaAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vozila);

        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);

        mAdapter = new VozilaAdapter(listaVozila, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        VozilaData.nabaviPodatkeVozila(listaVozila);
        mAdapter.notifyDataSetChanged();
    }

}
