package com.bkl.air.foi.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Bunic on 1.11.2016..
 */
@Table(database = MainDatabase.class)
public class Kontakt extends BaseModel {
    @PrimaryKey
    @Column int id;
    @Column String ime;
    @Column String prezime;
    @Column String mobitel;
    @Column String email;
    @Column String slikaUrl;

    List<Kontakt> kontaktList;

    //.............Konstruktori..............

    public Kontakt() {
    }
    public Kontakt(int id, String ime, String prezime, String mobitel, String email, String slikaUrl) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.mobitel = mobitel;
        this.email = email;
        this.slikaUrl = slikaUrl;
    }

    //.............Get & Set..................

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
    public String getMobitel() {
        return mobitel;
    }
    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSlikaUrl() {
        return slikaUrl;
    }
    public void setSlikaUrl(String slikaUrl) {
        this.slikaUrl = slikaUrl;
    }

    //.................Metode.....................

    /**
     * Metoda služi za dohvaćanje svih "kontakta" u lokalnoj bazi.
     * Metoda nema parametre a vraća vrijednost List<Kontakt>
     *
     * @return lista svih korisnika
     */
    public static List<Kontakt> getAll(){
        return SQLite.select().from(Kontakt.class).queryList();
    }

}
