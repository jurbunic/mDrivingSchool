package com.bkl.air.foi.mdrivingschool;

import android.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bkl.air.foi.mdrivingschool.helpers.StartFragment;

public class TraineeActivity extends AppCompatActivity {
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
}
