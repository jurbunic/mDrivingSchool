package com.bkl.air.foi.mdrivingschool;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.bkl.air.foi.mdrivingschool.employee_fragments.MainEmployeeFragment;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;
import com.bkl.air.foi.mdrivingschool.maps.MapFragment;


/**
 * Created by Jurica Bunić on 6.12.2016..
 */

public class EmployeeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener{
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private FragmentManager mFragmentManager;
    private String recivedData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_main);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        SetToolbar();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_employee);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view_employee);
        navigationView.setNavigationItemSelectedListener(this);

        mFragmentManager = getFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(this);



        MainEmployeeFragment mef = new MainEmployeeFragment();
        StartFragment.StartNewFragment(mef,this);

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
        switch (id){
            case R.id.employee_pocetna_navigation:
                MainEmployeeFragment mef = new MainEmployeeFragment();
                StartFragment.StartNewFragment(mef,this);
                break;
            case R.id.employee_kontakt_navigation:
                KontaktFragment kf = new KontaktFragment();
                StartFragment.StartNewFragment(kf,this);
                break;
            case R.id.employee_o_nama_navigation:
                OnamaFragment onf = new OnamaFragment();
                StartFragment.StartNewFragment(onf,this);
                break;
            case R.id.employee_vozila_navigation:
                VozilaFragment vf = new VozilaFragment();
                StartFragment.StartNewFragment(vf,this);
                break;
            case R.id.employee_map_navigation:
                MapFragment mf = new MapFragment();
                StartFragment.StartNewFragment(mf,this);
                break;
            case R.id.employee_test_znanja_navigation:
                TestoviMainFragment tmf = new TestoviMainFragment();
                StartFragment.StartNewFragment(tmf,this);
                break;
            case R.id.employee_add_new_trainee_navigation:
                AddNewTraineeFragment antf = new AddNewTraineeFragment();
                StartFragment.StartNewFragment(antf,this);
                break;
            case R.id.employee_odjava_navigation:
                finish();
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_employee);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackStackChanged() {
        toggle.setDrawerIndicatorEnabled(mFragmentManager.getBackStackEntryCount()==0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(mFragmentManager.getBackStackEntryCount()>0);
        toggle.syncState();
    }
}
