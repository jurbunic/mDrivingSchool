package com.bkl.air.foi.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;


import java.util.List;

/**
 * Created by Jurica Bunić on 14.1.2017..
 */

@Table(database = MainDatabase.class)
public class Appointment extends BaseModel {
    @PrimaryKey
    @Column String startDate;
    @Column String startTime;
    @Column String endTime;

    public Appointment() {
    }

    public Appointment(String startDate, String startTime, String endTime) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public static List<Appointment> getAll(){
        return SQLite.select().from(Appointment.class).queryList();
    }
}
