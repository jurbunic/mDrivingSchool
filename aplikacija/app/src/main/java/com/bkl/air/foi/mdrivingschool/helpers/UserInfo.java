package com.bkl.air.foi.mdrivingschool.helpers;

import android.content.Context;

import com.bkl.air.foi.database.Korisnik;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by Jurica Bunić on 12.12.2016..
 */

public class UserInfo {
    private Context context;
    public UserInfo(Context context) {
        this.context = context;
    }

    /**
     * Metoda dohvaća sa servera podatke o korisniku sa određenim ID-om
     * Metoda vraća vrijednost tipa Korisnik
     *
     * @param userId ID korisnika za kojeg se dohvaćaju podaci
     * @return objekt Korisnik sa pripadajućim podacima
     */
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

    /**
     * Metoda dohvaća informacije o polaznicima koji su dodjeljeni zaposleniku
     * sa određenim ID-om.
     * Metoda vraća listu tipa Korisnik.
     *
     * @param userId (tip String) ID zaposlenika za kojeg želimo dohvatiti dodjeljene polaznike
     * @return lista polaznika koji pripadaju trenutnom zaposleniku
     */
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

    /**
     * Metoda koja sprema korisnike koji nisu dodijeljeni niti jednom instruktoru
     * @param userId
     * @return Vraća listu tipa korisnik
     */
    public ArrayList<Korisnik> getFreeTrainees (String userId){
        ArrayList<Korisnik> trainess = new ArrayList<>();
        try{
            RetriveData data = new RetriveData(context);
            String fetchedData = data.execute("5",userId).get();

            Korisnik korisnik;

            JSONObject jsonObject = new JSONObject(fetchedData);
            JSONArray jsonArray = jsonObject.getJSONArray("add");
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
