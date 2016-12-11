package com.bkl.air.foi.mdrivingschool.helpers;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HP on 11.12.2016..
 */

public class RetriveData extends AsyncTask <String, Void, String> {

    Context context;
    String dataUrl = "";
    String jsonString = "";

    public RetriveData(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dataUrl = "http://barka.foi.hr/WebDiP/2015/zadaca_02/matlazar/servis/json_query.php";
    }

    @Override
    protected String doInBackground(String... params) {
        String query = params[0];
        String specify = params[1];
        if(query.equals("1")){
            dataUrl += "?data_retrive=1";
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();

                httpURLConnection.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(query.equals("2")){
            dataUrl += "?data_retrive=2&osoba="+specify;
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
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
        } else if (query.equals("3")){
            dataUrl += "?data_retrive=3&osoba="+specify;
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
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

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        jsonString = s;
    }
}
