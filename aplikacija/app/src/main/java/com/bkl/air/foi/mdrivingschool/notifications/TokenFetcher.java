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
 * Created by Jurica Bunić on 20.1.2017..
 */

public class TokenFetcher extends AsyncTask<String, Void, String> {
    String userId;
    String userToken;

    public TokenFetcher(String userId) {
        this.userId = userId;
    }

    /**
     * Metoda dohvaća token iz baze na temelju korisničkog ID-a. Korisnički id se dohvaća u konstruktoru
     * klase
     *
     * @return korisnički token za Firebase notifikacije ( tip String )
     */
    private String fetchToken(){
        String token="";
        try {

            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("userId", userId)
                    .build();

            Request request = new Request.Builder()
                    .url("https://mdrivingschool0.000webhostapp.com/getToken.php")
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            token = response.body().string();

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            }catch (IOException e){
                e.printStackTrace();
            }
        Log.w("RETURN1",token);
        return token;

    }

    @Override
    protected String doInBackground(String... params) {
        try {
            userToken = fetchToken();
        }catch (Exception e){

        }
        return userToken;
    }


}
