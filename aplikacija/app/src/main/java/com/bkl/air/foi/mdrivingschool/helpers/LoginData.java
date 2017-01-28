package com.bkl.air.foi.mdrivingschool.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.bkl.air.foi.mdrivingschool.EmployeeActivity;
import com.bkl.air.foi.mdrivingschool.TraineeActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

/**
 * Created by HP on 29.11.2016..
 */

public class LoginData extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    Context context;

    public LoginData(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Info");
    }

    /**
     * Metoda za komunikaciju sa serverom
     * @param params parametri koje šalje metoda execute
     * @return Vraća odgovor servera metodi onPostExecute
     */
    @Override
    protected String doInBackground(String... params) {
        String login_url = "http://barka.foi.hr/WebDiP/2015_projekti/WebDiP2015x045/servis/login.php";
        String login_name = params[1];
        String login_pass = params[2];
        String method = "login";
        if(method.equals(params[0])){
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") +"="+URLEncoder.encode(login_name,"UTF-8")
                        +"&"+URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String responese = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    responese += line;
                }

                bufferedReader.close();
                inputStream.close();

                httpURLConnection.disconnect();
                return  responese;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "nema nicega";
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    /**
     * Metoda koja obrađuje odogvor metode doInBackground i priprema je za export
     * @param s
     */
    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            JSONObject JO = jsonArray.getJSONObject(0);
            String tip_id = JO.getString("tip_id");
            String id = JO.getString("id");

            if(tip_id.equals("1")){
                Intent intent = new Intent(context,EmployeeActivity.class);
                RetriveData data = new RetriveData(context);
                String fetchedData = data.execute("2",id).get();
                intent.putExtra("USER",id);
                context.startActivity(intent);
                ((Activity)context).finish();
            }else {
                Intent intent = new Intent(context, TraineeActivity.class);
                intent.putExtra("USER", id);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            alertDialog.setMessage("Pogrešno korisničko ime ili lozinka");
            alertDialog.show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
