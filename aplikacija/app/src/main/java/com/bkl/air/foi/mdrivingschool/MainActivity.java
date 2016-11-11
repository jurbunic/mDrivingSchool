package com.bkl.air.foi.mdrivingschool;


import android.app.Fragment;
import android.app.FragmentManager;
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
import android.view.MenuItem;


import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        FlowManager.init(new FlowConfig.Builder(this).build());


        setToolbar();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        drawer.addDrawerListener(toggle);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        MainScreenFragment msf = new MainScreenFragment();
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.addToBackStack("pocetna");
        fm.replace(R.id.fragment_container, msf);
        fm.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        FragmentManager fm = getFragmentManager();

        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            getSupportActionBar().setTitle("Početna stranica");

            if((fm.getBackStackEntryCount()-1)==0){
                super.onBackPressed();
            }
            else {
                String naziv = fm.getBackStackEntryAt(getFragmentManager().getBackStackEntryCount() - 2).getName();


                if (naziv == "o nama") {
                    navigationView.getMenu().getItem(0).setChecked(true);
                } else if (naziv == "kontakt") {
                    navigationView.getMenu().getItem(1).setChecked(true);
                } else if (naziv == "vozila") {
                    navigationView.getMenu().getItem(2).setChecked(true);
                } else if (naziv == "online upis") {
                    navigationView.getMenu().getItem(3).setChecked(true);
                } else {
                    for (int i = 0; i < 4; i++) {
                        navigationView.getMenu().getItem(i).setChecked(false);
                    }
                }
            }
            super.onBackPressed();
        }
    }



    /**Metoda setToolbar
     *
     * Metoda kreira novi toolbar i veže ga za toolbar koji je definiran u navigation_app_bar_main
     * Postavlja boju "hamburger" ikone u bijelu i postavlja naslov u "Početna stranica"
     */
    private Toolbar setToolbar (){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
        toolbar.setTitle("Početna stranica");
        setSupportActionBar(toolbar);
        return toolbar;
    }

    private void StartFragment(Fragment fragment, String tag){
        FragmentTransaction fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, fragment);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack(tag);
        fm.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.kontakt_navigation){

            KontaktFragment fk = new KontaktFragment();
            StartFragment(fk,"kontakt");

        }
        else if(id==R.id.vozila_navigation){
            VozilaFragment fv = new VozilaFragment();
            StartFragment(fv, "vozila");
        }
        else if(id==R.id.online_prijava_navigation) {
            OnlinePrijavaFragment opn = new OnlinePrijavaFragment();
            StartFragment(opn, "online upis");

        }
        else if(id==R.id.o_nama_navigation){
            OnamaFragment onf = new OnamaFragment();
            StartFragment(onf,"o nama");
        }
        else if(id==R.id.prijava_navigation){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
