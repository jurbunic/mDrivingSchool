package com.bkl.air.foi.mdrivingschool;

import android.app.FragmentTransaction;
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
import android.view.Menu;
import android.view.MenuItem;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        FlowManager.init(new FlowConfig.Builder(this).build());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
        toolbar.setTitle("Početna stranica");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        drawer.addDrawerListener(toggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        MainScreenFragment msf = new MainScreenFragment();
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, msf);
        fm.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        getSupportActionBar().setTitle("Početna");
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }





    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.kontakt_navigation){

            KontaktFragment fk = new KontaktFragment();
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.replace(R.id.fragment_container, fk);
            fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.addToBackStack("kontakt");
            fm.commit();
        }
        else if(id==R.id.vozila_navigation){
            VozilaFragment fv = new VozilaFragment();
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.replace(R.id.fragment_container, fv);
            fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.addToBackStack("vozila");
            fm.commit();
        }
        else if(id==R.id.online_prijava_navigation) {
            OnlinePrijavaFragment opn = new OnlinePrijavaFragment();
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.replace(R.id.fragment_container, opn);
            fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.addToBackStack("online upis");
            fm.commit();
        }
        else if(id==R.id.o_nama_navigation){
            OnamaFragment onf = new OnamaFragment();
            FragmentTransaction fm = getFragmentManager().beginTransaction();
            fm.replace(R.id.fragment_container, onf);
            fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.addToBackStack("o nama");
            fm.commit();
        }
        else if(id==R.id.prijava_navigation){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*
    @Optional
    @OnClick(R.id.button_vozila)
    public void buttonVozilaClicked(){
        Intent intent = new Intent(this, VozilaFragment.class);
        startActivity(intent);
    }
    @Optional
    @OnClick(R.id.button_kontakt)
    public void buttonKontaktClicked(){


        Intent intent = new Intent(this, KontaktFragment.class);
        startActivity(intent);
    }
    @Optional
    @OnClick(R.id.button_login)
    public void buttonLoginClicked(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
*/
}
