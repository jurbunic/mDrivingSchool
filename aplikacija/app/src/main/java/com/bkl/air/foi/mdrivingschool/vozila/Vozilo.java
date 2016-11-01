package com.bkl.air.foi.mdrivingschool.vozila;

import java.util.List;

/**
 * Created by Dalibor on 1.11.2016..
 */

public class Vozilo {
    int id;
    String naziv;
    String imgUrl;

    public Vozilo() {
    }

    public Vozilo(int id, String naziv, String imgUrl) {
        this.id = id;
        this.naziv = naziv;
        this.imgUrl = imgUrl;
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
}
