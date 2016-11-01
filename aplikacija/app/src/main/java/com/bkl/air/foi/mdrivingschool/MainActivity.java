package com.bkl.air.foi.mdrivingschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_vozila)
    public void buttonVozilaClicked(){
        Intent intent = new Intent(this, VozilaActivity.class);
        startActivity(intent);
    }
}
