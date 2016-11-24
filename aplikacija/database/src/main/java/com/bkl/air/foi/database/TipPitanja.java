package com.bkl.air.foi.database;

/**
 * Created by Dalibor on 23.11.2016..
 */

public class TipPitanja {
    int id;
    String naziv;

    public TipPitanja() {
    }

    public TipPitanja(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
