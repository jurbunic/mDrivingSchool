package com.bkl.air.foi.mdrivingschool;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bkl.air.foi.database.Kontakt;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        FlowManager.init(new FlowConfig.Builder(this).build());

    }

    @OnClick(R.id.button_vozila)
    public void buttonVozilaClicked(){
        Intent intent = new Intent(this, VozilaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_kontakt)
    public void buttonKontaktClicked(){


        Intent intent = new Intent(this, KontaktActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_login)
    public void buttonLoginClicked(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
