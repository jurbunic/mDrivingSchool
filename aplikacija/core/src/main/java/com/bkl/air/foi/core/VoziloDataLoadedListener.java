package com.bkl.air.foi.core;

import com.bkl.air.foi.database.Vozilo;

import java.util.ArrayList;

/**
 * Created by Dalibor on 14.1.2017..
 */

public interface VoziloDataLoadedListener {
    void onDataLoaded(ArrayList<Vozilo> listVozilo);
}
