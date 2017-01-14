package com.bkl.air.foi.core;

import com.bkl.air.foi.database.Kontakt;

import java.util.ArrayList;

/**
 * Created by Dalibor on 14.1.2017..
 */

public interface KontaktDataLoadedListener {
    void onDataLoaded(ArrayList<Kontakt> listKontakt);
}
