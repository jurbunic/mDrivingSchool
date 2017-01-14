package com.bkl.air.foi.core;

import com.bkl.air.foi.database.Kontakt;
import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.database.Vozilo;

import java.util.ArrayList;

/**
 * Created by Dalibor on 14.1.2017..
 */

public abstract class DataLoader {
    public ArrayList<Kontakt> listKontakt;
    public ArrayList<Vozilo> listVozilo;
    public ArrayList<Pitanje> listPitanje;

    protected KontaktDataLoadedListener mKontaktDataLoadedListener;
    protected VoziloDataLoadedListener mVoziloDataLoadedListener;
    protected PitanjeDataLoadedListener mPitanjeDataLoadedListener;

    /**
     * Metoda pribavlja podatke o svim kontaktima
     *
     * @param kontaktDataLoadedListener poseban listener koji ceka dolazak podataka o kontaktima
     */
    public void loadKontaktData(KontaktDataLoadedListener kontaktDataLoadedListener){
        this.mKontaktDataLoadedListener = kontaktDataLoadedListener;
    }

    /**
     * Metoda pribavlja podatke o svim vozilima
     *
     * @param voziloDataLoaderListener poseban listener koji ceka dolazak podataka o vozilima
     */
    public void loadVoziloData(VoziloDataLoadedListener voziloDataLoaderListener){
        this.mVoziloDataLoadedListener = voziloDataLoaderListener;
    }

    /**
     * Metoda pribavlja podatke o svim pitanjima propisa i/ili prve pomoci
     *
     * @param pitanjeDataLoaderListener poseban listener koji ceka dolazak podataka o pitanjima
     * @param type predstavlja flag koji se koristi za raspoznavanje tipa pitanja, 1 = propisi, 2 = prva pomoc
     */
    public void loadPitanjeData(PitanjeDataLoadedListener pitanjeDataLoaderListener, int type){
        this.mPitanjeDataLoadedListener = pitanjeDataLoaderListener;
    }
}
