package com.bkl.air.foi.mdrivingschool.webservice;

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

/**
 * Created by HP on 11.12.2016..
 */

public class RetriveData extends AsyncTask <String, Void, String> {

    Context context;
    String dataUrl = "";
    String notificationUrl = "";
    String jsonString = "";

    public RetriveData(Context context){
        this.context = context;
    }

    /**
     * Metoda koja inicijalizira url sa php skriptama
     */
    @Override
    protected void onPreExecute() {
        dataUrl = "http://barka.foi.hr/WebDiP/2015_projekti/WebDiP2015x045/servis/json_query.php";
        notificationUrl = "http://barka.foi.hr/WebDiP/2015_projekti/WebDiP2015x045/servis/notifikacije.php";
    }

    /**
     *
     * @param params parametri uneseni execute metodom
     * @return response ili null ukoliko nije ni jedan uvijet zadovoljen
     */
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
        }else if (query.equals("5")){
            dataUrl += "?data_retrive=5&osoba="+specify;
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
        }else if(query.equals("6")){
            dataUrl += "?data_retrive=6&osoba="+specify;
            String instruktor= params[2];
            String polaznik = params[3];
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("instruktor","UTF-8")+"="+URLEncoder.encode(instruktor,"UTF-8")+"&"+URLEncoder.encode("polaznik","UTF-8")+"="+URLEncoder.encode(polaznik,"UTF-8");
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
        }else if(query.equals("7")){
            dataUrl += "?data_retrive=7&osoba="+specify;
            String instruktorDelete= params[2];
            String traineeDelete = params[3];
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("instruktor","UTF-8")+"="+URLEncoder.encode(instruktorDelete,"UTF-8")+"&"+URLEncoder.encode("polaznik","UTF-8")+"="+URLEncoder.encode(traineeDelete,"UTF-8");
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
        } else if(query.equals("8")){
            dataUrl += "?data_retrive=8&osoba="+specify;
            String id = params[2];
            String propisi = params[3];
            String prva_pomoc = params[4];
            String ispit_voznje = params[5];
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+URLEncoder.encode("propisi","UTF-8")+"="+URLEncoder.encode(propisi,"UTF-8")
                        +"&"+URLEncoder.encode("prva_pomoc","UTF-8")+"="+URLEncoder.encode(prva_pomoc,"UTF-8")+"&"+URLEncoder.encode("ispit_voznje","UTF-8")+"="+URLEncoder.encode(ispit_voznje,"UTF-8");
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
        }else if(query.equals("9")){
            dataUrl += "?data_retrive=9&osoba="+specify;
            String id = params[2];
            String sati = params[3];
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("id1","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+URLEncoder.encode("sati","UTF-8")+"="+URLEncoder.encode(sati,"UTF-8");
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
        }else if(query.equals("10")){
            dataUrl += "?data_retrive=10&osoba="+specify;
            String id2 = params[2];
            String datum_voznje = params[3];
            String vrijeme_voznje = params[4];
            try {
                URL url = new URL(dataUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("id2","UTF-8")+"="+URLEncoder.encode(id2,"UTF-8")+"&"+URLEncoder.encode("datum_voznje","UTF-8")+"="+URLEncoder.encode(datum_voznje,"UTF-8")
                        +"&"+URLEncoder.encode("vrijeme_voznje","UTF-8")+"="+URLEncoder.encode(vrijeme_voznje,"UTF-8");
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
        }else if(query.equals("11")){
            String token= "fijXJtzioyI:APA91bEH9vESMpokubQroHyK4NTZTt3cJOVA7eqfEDFjMzO-xS329fl0LX2ABZPHgUFQuwwm6sFMIG6i_IkYxd5QwcHIRL9lAtAEEJufza5DxC4aKTqzxRlTbiDFrbP6ut2ao192Dulq\n";
            String messageBody = "Server";
            try {
                URL url = new URL(notificationUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("token","UTF-8")+"="+URLEncoder.encode(token,"UTF-8")+"&"+URLEncoder.encode("body","UTF-8")+"="+URLEncoder.encode(messageBody,"UTF-8");
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

    /**
     * Metoda koja vraća rezultat servera
     * @param s rezultat metode doInBackground tipa string
     */
    @Override
    protected void onPostExecute(String s) {
            if(s.substring(s.length()-1).toString().equals("1")){
                Toast.makeText(context,"Uspješno dodan polaznik",Toast.LENGTH_LONG).show();
            }else if(s.substring(s.length()-1).toString().equals("0")){
                Toast.makeText(context,"Unos nije uspio",Toast.LENGTH_LONG).show();
            }else if(s.substring(s.length()-1).toString().equals("2")){
                Toast.makeText(context,"Uspješno izbrisan polaznik",Toast.LENGTH_LONG).show();
            }else if (s.substring(s.length()-1).toString().equals("3")){
                Toast.makeText(context,"Brisanje nije uspjelo",Toast.LENGTH_LONG).show();
            }else if (s.equals("4")){
                Toast.makeText(context,"Ažurirani ispiti",Toast.LENGTH_LONG).show();
            }else if (s.equals("5")){
                Toast.makeText(context,"Ispiti nisu ažurirani",Toast.LENGTH_LONG).show();
            }else if (s.equals("6")){
                Toast.makeText(context,"Dodani sati vožnje",Toast.LENGTH_LONG).show();
            }else if (s.equals("7")){
                Toast.makeText(context,"Neuspješno dodavanje sati",Toast.LENGTH_LONG).show();
            }else if (s.equals("8")){
                Toast.makeText(context,"Dodan termin vožnje",Toast.LENGTH_LONG).show();
            }else if (s.equals("9")) {
                Toast.makeText(context, "Nije dodan termin", Toast.LENGTH_LONG).show();
            }
            jsonString = s;
            super.onPostExecute(jsonString);
    }
}
