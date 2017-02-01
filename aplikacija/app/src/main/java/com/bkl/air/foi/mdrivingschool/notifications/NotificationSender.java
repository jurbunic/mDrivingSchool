package com.bkl.air.foi.mdrivingschool.notifications;

import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Jurica Bunić on 20.1.2017..
 */

public class NotificationSender implements NotificationSenderInterface {
    String tok;
    String mes;

    public NotificationSender(String tok, String mes) {
        this.tok = tok;
        this.mes = mes;
    }

    /**
     * Metoda šalje notifikaciju koja sadrži poruku na uređaj sa određenim tokenom.
     *
     */
    @Override
    public void send(){
        try{
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("token", tok)
                    .add("message",mes)
                    .build();

            Request request = new Request.Builder()
                    .url("https://mdrivingschool0.000webhostapp.com/notifications.php")
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()) {throw new IOException("Unexpected code "+response);}
        }catch (IOException io){
            io.printStackTrace();
        }

    }
}
