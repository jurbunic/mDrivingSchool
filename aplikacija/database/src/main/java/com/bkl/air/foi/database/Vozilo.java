package com.bkl.air.foi.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Dalibor on 1.11.2016..
 */

@Table(database = MainDatabase.class)
public class Vozilo extends BaseModel{
    @PrimaryKey
    @Column int id;
    @Column String naziv;
    @Column String imgUrl;
    @Column String kategorija;
    @Column String motor;
    @Column String detalji;

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

    /**
     * Metoda dohvaca podatake o svim vozilima iz lokalne baze i spremanje u danu listu
     *
     * @return Lista sa svim podacima vozila
     */
    public static List<Vozilo> getAll(){
        return SQLite.select().from(Vozilo.class).queryList();
    }

    /**
     * Metoda dohvaca podatake o vozilu odredenog id-a
     *
     * @param id Id vozila
     * @return Jedan objekt trazenog vozila
     */
    public static Vozilo getSpecific(int id) {
        return SQLite.select().from(Vozilo.class).where(Vozilo_Table.id.eq(id)).querySingle();
    }
}
