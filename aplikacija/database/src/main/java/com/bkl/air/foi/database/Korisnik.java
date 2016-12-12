package com.bkl.air.foi.database;

import java.util.Date;

/**
 * Created by HP on 8.12.2016..
 */

public class Korisnik {
    private int id;
    private String ime;
    private String prezime;
    private String datum_rodenja;
    private  String mjesto_rodenja;
    private String mobitel;
    private  String telefon;
    private  String email;
    private String adresa;
    private String propisi;
    private String  prva_pomoc;
    private int sati_voznje;
    private String user_name;
    private String user_pass;
    private int tip_id;

    public Korisnik() {
    }

    public Korisnik(int id, int tip_id, String ime, String prezime, String datum_rodenja, String mjesto_rodenja, String mobitel, String telefon, String email, String adresa, String propisi, String prva_pomoc, int sati_voznje, String user_name, String user_pass) {
        this.id = id;
        this.tip_id = tip_id;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodenja = datum_rodenja;
        this.mjesto_rodenja = mjesto_rodenja;
        this.mobitel = mobitel;
        this.telefon = telefon;
        this.email = email;
        this.adresa = adresa;
        this.propisi = propisi;
        this.prva_pomoc = prva_pomoc;
        this.sati_voznje = sati_voznje;
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getDatum_rodenja() {
        return datum_rodenja;
    }

    public void setDatum_rodenja(String datum_rodenja) {
        this.datum_rodenja = datum_rodenja;
    }

    public String getMjesto_rodenja() {
        return mjesto_rodenja;
    }

    public void setMjesto_rodenja(String mjesto_rodenja) {
        this.mjesto_rodenja = mjesto_rodenja;
    }

    public String getMobitel() {
        return mobitel;
    }

    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPropisi() {
        return propisi;
    }

    public void setPropisi(String propisi) {
        this.propisi = propisi;
    }

    public String getPrva_pomoc() {
        return prva_pomoc;
    }

    public void setPrva_pomoc(String prva_pomoc) {
        this.prva_pomoc = prva_pomoc;
    }

    public int getSati_voznje() {
        return sati_voznje;
    }

    public void setSati_voznje(int sati_voznje) {
        this.sati_voznje = sati_voznje;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }
}
