package com.bkl.air.foi.mdrivingschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bkl.air.foi.mdrivingschool.vozila.VozilaAdapter;
import com.bkl.air.foi.mdrivingschool.vozila.Vozilo;

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

        nabaviPodatkeVozila();
    }

    private void nabaviPodatkeVozila() {
        Vozilo vozilo = new Vozilo(1, "Škoda Fabia", "http://autoskola-premuz.hr/wp-content/uploads/2014/12/fabia-silver1.jpg");
        listaVozila.add(vozilo);

        vozilo = new Vozilo(2, "Škoda Rapid", "http://autoskola-premuz.hr/wp-content/uploads/2012/09/rapid.jpg");
        listaVozila.add(vozilo);

        vozilo = new Vozilo(3, "Škoda Octavia", "http://autoskola-premuz.hr/wp-content/uploads/2012/09/octavia.jpg");
        listaVozila.add(vozilo);

        mAdapter.notifyDataSetChanged();
    }
}
