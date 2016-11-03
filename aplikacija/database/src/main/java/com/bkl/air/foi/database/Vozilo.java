package com.bkl.air.foi.database;

import java.util.List;

/**
 * Created by Dalibor on 1.11.2016..
 */

public class Vozilo {
    int id;
    String naziv;
    String imgUrl;
    String kategorija;
    String motor;
    String detalji;

    public Vozilo() {
    }

    public Vozilo(int id, String naziv, String imgUrl, String kategorija, String motor, String detalji) {
        this.id = id;
        this.naziv = naziv;
        this.imgUrl = imgUrl;
        this.kategorija = kategorija;
        this.motor = motor;
        this.detalji = detalji;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getDetalji() {
        return detalji;
    }

    public void setDetalji(String detalji) {
        this.detalji = detalji;
    }
}
