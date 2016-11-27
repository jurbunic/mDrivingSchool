package com.bkl.air.foi.mdrivingschool;




import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.maps.MapFragment;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        FlowManager.init(new FlowConfig.Builder(this).build());


        SetToolbar();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        drawer.addDrawerListener(toggle);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        MainScreenFragment msf = new MainScreenFragment();
        StartFragment.StartNewFragment(msf, "pocetna", this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    /**
     * SetToolbar
     * Metoda služi za postavljanje toolbara, boje i naslova toolbara;
     *
     * @return
     */
    private Toolbar SetToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
        toolbar.setTitle("Početna stranica");
        setSupportActionBar(toolbar);
        return toolbar;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.kontakt_navigation) {

            KontaktFragment fk = new KontaktFragment();
            StartFragment.StartNewFragment(fk, "kontakt", this);
        } else if (id == R.id.vozila_navigation) {
            VozilaFragment fv = new VozilaFragment();
            StartFragment.StartNewFragment(fv, "vozila", this);
        } else if (id == R.id.online_prijava_navigation) {
            OnlinePrijavaFragment opn = new OnlinePrijavaFragment();
            StartFragment.StartNewFragment(opn, "online upis", this);

        } else if (id == R.id.o_nama_navigation) {
            OnamaFragment onf = new OnamaFragment();
            StartFragment.StartNewFragment(onf, "o nama", this);
        } else if (id == R.id.prijava_navigation) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.pocetna_navigation) {
            MainScreenFragment msf = new MainScreenFragment();
            StartFragment.StartNewFragment(msf, "pocetna", this);

        } else if (id == R.id.map_navigation) {
            MapFragment mf = new MapFragment();
            StartFragment.StartNewFragment(mf, "map", this);

        } else if (id == R.id.test_znanja_navigation) {
            TestoviMainFragment tmf = new TestoviMainFragment();
            StartFragment.StartNewFragment(tmf, "testovi main", this);
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

            drawer.closeDrawer(GravityCompat.START);
            return false;
        }

    }
