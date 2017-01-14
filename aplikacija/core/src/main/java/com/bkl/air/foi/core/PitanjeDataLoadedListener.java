package com.bkl.air.foi.core;

import com.bkl.air.foi.database.Kontakt;
import com.bkl.air.foi.database.Pitanje;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dalibor on 14.1.2017..
 */

public interface PitanjeDataLoadedListener {
    void onDataLoaded(ArrayList<Pitanje> listPitanje);
}
