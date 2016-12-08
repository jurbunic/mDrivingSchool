package com.bkl.air.foi.mdrivingschool;

import android.app.FragmentManager;
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
import android.view.View;

import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.maps.MapFragment;

public class TraineeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainee_main);

        SetToolbar();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_trainee);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view_trainee);
        navigationView.setNavigationItemSelectedListener(this);

        mFragmentManager = getFragmentManager();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager().getBackStackEntryCount()==0){
                    drawer.openDrawer(GravityCompat.START);
                }else {
                    onBackPressed();
                }
            }
        });

        TraineeMSFragment tmsf = new TraineeMSFragment();
        StartFragment.StartNewFragment(tmsf, this);
    }

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
        if (id == R.id.trainee_odjava_navigation) {
            //trenutniKorisnik = null;
            this.finish();
        }
        else if (id == R.id.trainee_pocetna_navigation) {
            TraineeMSFragment tmsf = new TraineeMSFragment();
            StartFragment.StartNewFragment(tmsf, this);
        }
        else if (id == R.id.trainee_o_nama_navigation) {
            OnamaFragment onf = new OnamaFragment();
            StartFragment.StartNewFragment(onf, this);
        }
        else if (id == R.id.trainee_vozila_navigation) {
            VozilaFragment fv = new VozilaFragment();
            StartFragment.StartNewFragment(fv, this);
        }
        else if (id == R.id.trainee_kontakt_navigation){
            KontaktFragment fk = new KontaktFragment();
            StartFragment.StartNewFragment(fk , this);
        }
        else if (id == R.id.trainee_test_znanja_navigation) {
            TestoviMainFragment tmf = new TestoviMainFragment();
            StartFragment.StartNewFragment(tmf, this);
        }
        else if (id == R.id.trainee_map_navigation) {
            MapFragment mf = new MapFragment();
            StartFragment.StartNewFragment(mf, this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_trainee);

        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
