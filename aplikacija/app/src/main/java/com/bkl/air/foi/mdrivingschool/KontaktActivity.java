package com.bkl.air.foi.mdrivingschool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bkl.air.foi.database.Kontakt;
import com.bkl.air.foi.mdrivingschool.adapters.KontaktAdapter;
import com.bkl.air.foi.mdrivingschool.helpers.KontaktData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bunic on 1.11.2016..
 */

public class KontaktActivity extends AppCompatActivity {

    private List<Kontakt> listKontakt = new ArrayList<>();
    private RecyclerView recyclerView;
    private KontaktAdapter mAdapter;
    private KontaktData kontaktData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakt);

        kontaktData = new KontaktData();
     //   if (Kontakt.getAll().isEmpty()){
    //        kontaktData.loadKontaktData(listKontakt);
    //    }

        kontaktData.loadKontaktData(listKontakt);

        recyclerView = (RecyclerView) findViewById(R.id.kontakt_recycler);

        mAdapter = new KontaktAdapter(listKontakt, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

       // listKontakt.add(Kontakt.getSpecific(1));
       // listKontakt.add(Kontakt.getSpecific(2));
    }
}
