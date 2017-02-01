package com.bkl.air.foi.mdrivingschool.notifications;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by HP on 1.2.2017..
 */

public class EmailFetcher extends AsyncTask<String,Void,String> {
    String userId;
    String email;

    public EmailFetcher(String userId) {
        this.userId = userId;
    }

    private String fetchEmail(){
        String emailReturn = "";
        try {

            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("userId", userId)
                    .build();

            Request request = new Request.Builder()
                    .url("http://barka.foi.hr/WebDiP/2015_projekti/WebDiP2015x045/servis/email.php")
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            emailReturn = response.body().string();

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        Log.w("RETURN2",emailReturn);
        return emailReturn;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            email = fetchEmail();
        }catch (Exception e){

        }
        return email;
    }
}
