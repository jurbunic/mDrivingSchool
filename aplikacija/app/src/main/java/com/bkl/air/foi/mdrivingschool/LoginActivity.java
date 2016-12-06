package com.bkl.air.foi.mdrivingschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.bkl.air.foi.mdrivingschool.helpers.LoginData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    String login_name, login_pass;

    @BindView(R.id.editText_username)
    EditText username;

    @BindView(R.id.editText_password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_prijava)
    public void onButtonPrijavaClick(){
        login_name = username.getText().toString();
        login_pass = password.getText().toString();
        LoginData loginData = new LoginData(this);
        loginData.execute("login",login_name,login_pass);


    }
}
