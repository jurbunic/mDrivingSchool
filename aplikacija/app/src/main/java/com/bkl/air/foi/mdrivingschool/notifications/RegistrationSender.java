package com.bkl.air.foi.mdrivingschool.notifications;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;



/**
 * Created by Jurica Bunić on 17.1.2017..
 */

public class RegistrationSender extends AsyncTask<String, Void, Void> {

    String SERVER_URL;
    Context context;
    String token;
    String userId;

    public RegistrationSender(Context context, String userId,String token) {

        SERVER_URL = "https://mdrivingschool0.000webhostapp.com/addtoken.php";
        this.context = context;
        this.token = token;
        this.userId = userId;

    }

    private void sendData() throws Exception{
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("token", token)
                .add("userid",userId)
                .build();

        Request request = new Request.Builder()
                .url("https://mdrivingschool0.000webhostapp.com/addtoken.php")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) {throw new IOException("Unexpected code "+response);}
    }


    @Override
    protected Void doInBackground(String... params) {
        try{
            sendData();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
