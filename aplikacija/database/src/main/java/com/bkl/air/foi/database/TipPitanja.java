package com.bkl.air.foi.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Dalibor on 23.11.2016..
 */
@Table(database = MainDatabase.class)
public class TipPitanja extends BaseModel {
    @PrimaryKey
    @Column int id;
    @Column String naziv;

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
