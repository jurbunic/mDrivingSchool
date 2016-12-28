package com.bkl.air.foi.mdrivingschool.helpers;

import android.content.Context;

import com.bkl.air.foi.database.Korisnik;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Jurica Bunić on 12.12.2016..
 */

public class UserInfo {
    private Context context;
    public UserInfo(Context context) {
        this.context = context;
    }
    public Korisnik getInfoById(String userId){
        Korisnik korisnik = new Korisnik();
        try{

            RetriveData data = new RetriveData(context);
            String fetchedData = data.execute("2",userId).get();

            JSONObject jsonObject = new JSONObject(fetchedData);
            JSONArray jsonArray = jsonObject.getJSONArray("korisnik");
            JSONObject JO = jsonArray.getJSONObject(0);
            korisnik.setIme(JO.getString("ime"));
            korisnik.setPrezime(JO.getString("prezime"));
            korisnik.setAdresa(JO.getString("adresa"));
            korisnik.setMobitel(JO.getString("mobitel"));
            korisnik.setDatum_rodenja(JO.getString("datum_rodenja"));
            korisnik.setMjesto_rodenja(JO.getString("mjesto_rodenja"));
            korisnik.setEmail(JO.getString("email"));
            korisnik.setTelefon(JO.getString("telefon"));
            korisnik.setPrva_pomoc(JO.getString("prva_pomoc"));
            korisnik.setPropisi(JO.getString("propisi"));
            korisnik.setSati_voznje(JO.getInt("sati_voznje"));
            korisnik.setId(JO.getInt("id"));
            korisnik.setTip_id(JO.getInt("tip_id"));
        }catch (Exception e){

        }
        return korisnik;
    }

    public ArrayList<Korisnik> getTrainees (String userId){
        ArrayList<Korisnik> trainess = new ArrayList<>();
        try{
            RetriveData data = new RetriveData(context);
            String fetchedData = data.execute("3",userId).get();

            Korisnik korisnik;

            JSONObject jsonObject = new JSONObject(fetchedData);
            JSONArray jsonArray = jsonObject.getJSONArray("polaznik");
            for (int i=0; i<jsonArray.length();i++){
                JSONObject JO = jsonArray.getJSONObject(i);

                korisnik = new Korisnik();

                korisnik.setIme(JO.getString("ime"));
                korisnik.setPrezime(JO.getString("prezime"));
                korisnik.setAdresa(JO.getString("adresa"));
                korisnik.setMobitel(JO.getString("mobitel"));
                korisnik.setDatum_rodenja(JO.getString("datum_rodenja"));
                korisnik.setMjesto_rodenja(JO.getString("mjesto_rodenja"));
                korisnik.setEmail(JO.getString("email"));
                korisnik.setTelefon(JO.getString("telefon"));
                korisnik.setPrva_pomoc(JO.getString("prva_pomoc"));
                korisnik.setPropisi(JO.getString("propisi"));
                korisnik.setSati_voznje(JO.getInt("sati_voznje"));
                korisnik.setId(JO.getInt("id"));
        //        korisnik.setTip_id(JO.getInt("tip_id"));

                trainess.add(korisnik);

            }
        }catch (Exception e){

        }
        return trainess;
    }
}