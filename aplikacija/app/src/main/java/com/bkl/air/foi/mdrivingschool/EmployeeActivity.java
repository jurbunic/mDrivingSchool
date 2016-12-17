package com.bkl.air.foi.mdrivingschool;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import android.widget.TextView;
import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.employee_fragments.MainEmployeeFragment;
import com.bkl.air.foi.mdrivingschool.employee_fragments.MyTraineesFragment;
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


    @Override
    protected void onStart() {
        super.onStart();

    }

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

        MainEmployeeFragment mef = new MainEmployeeFragment();
        StartFragment.StartNewFragment(mef,this,"1");

        loadPicture();

}

    private Toolbar SetToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
        toolbar.setTitle("Početna stranica");
        setSupportActionBar(toolbar);
        return toolbar;
    }

    private void loadPicture(){
        View view = navigationView.getHeaderView(0);
        TextView userNameAndSurname = (TextView)view.findViewById(R.id.korisnik_ime_navigation_header);
        TextView userEmail = (TextView)view.findViewById(R.id.korisnik_email_navigation_header);

        UserInfo info = new UserInfo(this);
        Korisnik korisnik = info.getInfoById(getIntent().getStringExtra("USER"));

        userNameAndSurname.setText(korisnik.getIme()+" "+korisnik.getPrezime());
        userEmail.setText(korisnik.getEmail());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.employee_pocetna_navigation:
                MainEmployeeFragment mef = new MainEmployeeFragment();
                mFragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
                mFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, mef)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
                break;
            case R.id.employee_dodaj_polaznika_navigation:
                AddNewTraineeFragment antf = new AddNewTraineeFragment();
                StartFragment.StartNewFragment(antf,this);
                break;
            case R.id.employee_informacije_o_polaznicima:
                MyTraineesFragment mtf = new MyTraineesFragment();

                StartFragment.StartNewFragment(mtf,this);
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
            case R.id.employee_odjava_navigation:
                finish();
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_employee);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        int a = mFragmentManager.getBackStackEntryCount();
        if (a>2){
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
                super.onBackPressed();
                if(mFragmentManager.getBackStackEntryCount()==0){
                    super.onBackPressed();
                }
            }
        }
    }

    @Override
    public void onBackStackChanged() {
        toggle.setDrawerIndicatorEnabled(mFragmentManager.getBackStackEntryCount()==1 || mFragmentManager.getBackStackEntryCount()==2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(mFragmentManager.getBackStackEntryCount()>2);
        toggle.syncState();
    }
}
