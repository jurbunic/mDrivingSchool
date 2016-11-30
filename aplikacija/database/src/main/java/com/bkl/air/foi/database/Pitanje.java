package com.bkl.air.foi.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by Dalibor on 23.11.2016..
 */
@Table(database = MainDatabase.class)
public class Pitanje extends BaseModel {
    @PrimaryKey
    @Column int id;
    @ForeignKey(tableClass = TipPitanja.class)
    @Column int id_tipa;

    @Column String pitanje;
    @Column String odg1;
    @Column String odg2;
    @Column String odg3;

    @Column boolean tocan1;
    @Column boolean tocan2;
    @Column boolean tocan3;

    @Column String imgUrl;

    public Pitanje() {
    }

    public Pitanje(int id, int id_tipa, String pitanje, String odg1, String odg2, String odg3, boolean tocan1, boolean tocan2, boolean tocan3, String imgUrl) {
        this.id = id;
        this.id_tipa = id_tipa;
        this.pitanje = pitanje;
        this.odg1 = odg1;
        this.odg2 = odg2;
        this.odg3 = odg3;
        this.tocan1 = tocan1;
        this.tocan2 = tocan2;
        this.tocan3 = tocan3;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tipa() {
        return id_tipa;
    }

    public void setId_tipa(int id_tipa) {
        this.id_tipa = id_tipa;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public String getOdg1() {
        return odg1;
    }

    public void setOdg1(String odg1) {
        this.odg1 = odg1;
    }

    public String getOdg2() {
        return odg2;
    }

    public void setOdg2(String odg2) {
        this.odg2 = odg2;
    }

    public String getOdg3() {
        return odg3;
    }

    public void setOdg3(String odg3) {
        this.odg3 = odg3;
    }

    public boolean isTocan1() {
        return tocan1;
    }

    public void setTocan1(boolean tocan1) {
        this.tocan1 = tocan1;
    }

    public boolean isTocan2() {
        return tocan2;
    }

    public void setTocan2(boolean tocan2) {
        this.tocan2 = tocan2;
    }

    public boolean isTocan3() {
        return tocan3;
    }

    public void setTocan3(boolean tocan3) {
        this.tocan3 = tocan3;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public static List<Pitanje> getAll(){ return SQLite.select().from(Pitanje.class).queryList(); }

    public static List<Pitanje> getOnlyPropisi(){
        return SQLite.select().from(Pitanje.class).where(Pitanje_Table.id_tipa_id.eq(1)).queryList();
    }

    public static List<Pitanje> getOnlyPrvaPomoc(){
        return SQLite.select().from(Pitanje.class).where(Pitanje_Table.id_tipa_id.eq(2)).queryList();
    }

}
