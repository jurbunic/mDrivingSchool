package com.bkl.air.foi.mdrivingschool;




import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener{
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        FlowManager.init(new FlowConfig.Builder(this).build());


        SetToolbar();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mFragmentManager = getFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager().getBackStackEntryCount()==1){
                    drawer.openDrawer(GravityCompat.START);
                }else if(getFragmentManager().getBackStackEntryCount()==2){
                    drawer.openDrawer(GravityCompat.START);
                }
                else {
                    onBackPressed();
                }
            }
        });

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        preferences.edit().putBoolean("NOTIFICATION",true).apply();

        MainScreenFragment msf = new MainScreenFragment();
        StartFragment.StartNewFragment(msf, this,"1");

    }




    /**
     * SetToolbar
     *
     * Metoda služi za postavljanje toolbara, boje i naslova toolbara;
     *
     * @return toolbar sa naslovom bijele boje
     */
    private Toolbar SetToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
        toolbar.setTitle("Početna stranica");
        setSupportActionBar(toolbar);
        return toolbar;
    }

    @Override
    public void onBackPressed() {
        int a = mFragmentManager.getBackStackEntryCount();
        if (a>=2){
            if(drawer.isDrawerOpen(GravityCompat.START)){
                drawer.closeDrawer(GravityCompat.START);
            }
            else {
                mFragmentManager.popBackStack();
            }
        } else {
            if (drawer.isDrawerOpen(GravityCompat.START)){
                drawer.closeDrawer(GravityCompat.START);
            }else {
                this.finish();
            }
        }
    }

    @Override
    public void onBackStackChanged() {
        toggle.setDrawerIndicatorEnabled(mFragmentManager.getBackStackEntryCount()==1 || mFragmentManager.getBackStackEntryCount()==2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(mFragmentManager.getBackStackEntryCount()>2);
        toggle.syncState();
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.kontakt_navigation) {

            KontaktFragment fk = new KontaktFragment();
            StartFragment.StartNewFragment(fk , this);
        } else if (id == R.id.vozila_navigation) {
            VozilaFragment fv = new VozilaFragment();
            StartFragment.StartNewFragment(fv, this);
        } else if (id == R.id.online_prijava_navigation) {
            OnlinePrijavaFragment opn = new OnlinePrijavaFragment();
            StartFragment.StartNewFragment(opn, this);

        } else if (id == R.id.o_nama_navigation) {
            OnamaFragment onf = new OnamaFragment();
            StartFragment.StartNewFragment(onf, this);
        } else if (id == R.id.prijava_navigation) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.pocetna_navigation) {
            MainScreenFragment msf = new MainScreenFragment();
            mFragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            mFragmentManager.beginTransaction()
                    .addToBackStack("1")
                    .replace(R.id.fragment_container, msf)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();

        } else if (id == R.id.map_navigation) {
            MapFragment mf = new MapFragment();
            StartFragment.StartNewFragment(mf, this);

        } else if (id == R.id.test_znanja_navigation) {
            TestoviMainFragment tmf = new TestoviMainFragment();
            StartFragment.StartNewFragment(tmf, this);
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

            drawer.closeDrawer(GravityCompat.START);
            return false;
        }

    }
