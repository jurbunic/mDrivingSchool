package com.bkl.air.foi.mdrivingschool;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import android.widget.TextView;

import com.bkl.air.foi.database.Korisnik;
import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;
import com.bkl.air.foi.mdrivingschool.helpers.UserInfo;
import com.bkl.air.foi.mdrivingschool.maps.MapFragment;
import com.bkl.air.foi.mdrivingschool.trainee_fragments.TraineeExamStatusFragment;
import com.bkl.air.foi.mdrivingschool.trainee_fragments.TraineeMSFragment;

public class TraineeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener{
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private FragmentManager mFragmentManager;
    private String currentUserId;
    private Korisnik currentUser;
    private UserInfo userInfo;


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

        currentUserId = getIntent().getStringExtra("USER_ID");
        userInfo = new UserInfo(getApplicationContext());
        currentUser = userInfo.getInfoById(currentUserId);

        TraineeMSFragment tmsf = new TraineeMSFragment();
        Bundle args=new Bundle();
        args.putString("USER_ID", currentUserId);
        args.putString("USER_NAME", currentUser.getIme());
        args.putString("USER_SURNAME", currentUser.getPrezime());
        tmsf.setArguments(args);
        StartFragment.StartNewFragment(tmsf, this, "1");

        loadDrawerHeader();
    }

    /**
     * Metoda priprema personalizirani toolbar početnog zaslona
     *
     * @return Vraca toolbar
     */
    private Toolbar SetToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
        toolbar.setTitle("Početna stranica");
        setSupportActionBar(toolbar);
        return toolbar;
    }

    /**
     * Metoda priprema personalizirani header polaznika za navigation drawer
     */
    private void loadDrawerHeader(){
        View view = navigationView.getHeaderView(0);
        TextView userNameAndSurname = (TextView)view.findViewById(R.id.korisnik_ime_navigation_header);
        TextView userEmail = (TextView)view.findViewById(R.id.korisnik_email_navigation_header);

        userNameAndSurname.setText(currentUser.getIme()+" "+currentUser.getPrezime());
        userEmail.setText(currentUser.getEmail());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.trainee_odjava_navigation) {
            this.finish();
        }
        else if (id == R.id.trainee_pocetna_navigation) {
            TraineeMSFragment tmsf = new TraineeMSFragment();
            Bundle args=new Bundle();
            args.putString("USER_ID", currentUserId);
            args.putString("USER_NAME", currentUser.getIme());
            args.putString("USER_SURNAME", currentUser.getPrezime());
            tmsf.setArguments(args);
            mFragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            mFragmentManager.beginTransaction()
                    .addToBackStack("1")
                    .replace(R.id.fragment_container, tmsf)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
        else if (id == R.id.trainee_o_nama_navigation) {
            OnamaFragment onf = new OnamaFragment();
            StartFragment.StartNewFragment(onf, this);
        }
        else if(id==R.id.trainee_status_mojih_ispita){
            TraineeExamStatusFragment tesf = new TraineeExamStatusFragment();

            Bundle args=new Bundle();
            args.putString("USER_ID", currentUserId);
            tesf.setArguments(args);

            StartFragment.StartNewFragment(tesf,this);
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
}
