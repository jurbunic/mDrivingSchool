package com.bkl.air.foi.mdrivingschool.notifications;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Jurica Bunić on 1.2.2017..
 */

public class NotificationSenderMail implements NotificationSenderInterface {
    String dest;
    String mes;

    public NotificationSenderMail(String dest, String mes) {
        this.dest = dest;
        this.mes = mes;
    }

    @Override
    public void send() {
        try{
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("email", dest)
                    .add("poruka",mes)
                    .build();

            Request request = new Request.Builder()
                    .url("http://barka.foi.hr/WebDiP/2015_projekti/WebDiP2015x045/servis/air.php")
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()) {throw new IOException("Unexpected code "+response);}
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
