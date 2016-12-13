package com.bkl.air.foi.mdrivingschool.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

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
import java.util.Date;

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
            dataUrl += "?data_retrive=1&osoba="+specify;
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
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
                httpURLConnection.setRequestMethod("GET");
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
                httpURLConnection.setRequestMethod("GET");
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
        }else if(query.equals("4")){
            dataUrl += "?data_retrive=4&osoba="+specify;
            String ime = params[2];
            String prezime = params[3];
            String datum_rodenja = params[4];
            String mjesto_rodenja = params[5];
            String mobitel = params[6];
            String telefon = params[7];
            String email = params[8];
            String adresa = params[9];
            String user_name = params[10];
            String user_pass = params[11];
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("ime","UTF-8")+"="+URLEncoder.encode(ime,"UTF-8")+"&"+URLEncoder.encode("prezime","UTF-8")+"="+URLEncoder.encode(prezime,"UTF-8")
                        +"&"+URLEncoder.encode("datum_rodenja","UTF-8")+"="+URLEncoder.encode(datum_rodenja,"UTF-8")+"&"+URLEncoder.encode("mjesto_rodenja","UTF-8")+"="+URLEncoder.encode(mjesto_rodenja,"UTF-8")
                        +"&"+URLEncoder.encode("mobitel","UTF-8")+"="+URLEncoder.encode(mobitel,"UTF-8")+"&"+URLEncoder.encode("telefon","UTF-8")+"="+URLEncoder.encode(telefon,"UTF-8")
                        +"&"+URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+URLEncoder.encode("adresa","UTF-8")+"="+URLEncoder.encode(adresa,"UTF-8")
                        +"&"+URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+URLEncoder.encode("user_pass","UTF-8")+"="+URLEncoder.encode(user_pass,"UTF-8");
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

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
            if(s.substring(s.length()-1).toString().equals("1")){
                Toast.makeText(context,"Uspješno dodan polaznik",Toast.LENGTH_LONG).show();
            }else if(s.substring(s.length()-1).toString().equals("0")){
                Toast.makeText(context,"Unos nije uspio",Toast.LENGTH_LONG).show();
            }
            jsonString = s;
            super.onPostExecute(jsonString);
    }
}
