package com.bkl.air.foi.mdrivingschool.loaders;

import com.bkl.air.foi.core.DataLoader;
import com.bkl.air.foi.core.KontaktDataLoadedListener;
import com.bkl.air.foi.core.PitanjeDataLoadedListener;
import com.bkl.air.foi.core.VoziloDataLoadedListener;
import com.bkl.air.foi.database.Kontakt;
import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.database.Vozilo;

import java.util.ArrayList;

/**
 * Created by Dalibor on 14.1.2017..
 */

public class DbDataLoader extends DataLoader {
    /**
     * Metoda koja ucitava podatke o kontaktima iz lokalne baze podataka
     *
     * @param kontaktDataLoadedListener poseban listener koji ceka dolazak podataka o kontaktima
     */
    @Override
    public void loadKontaktData(KontaktDataLoadedListener kontaktDataLoadedListener){
        super.loadKontaktData(kontaktDataLoadedListener);
        try{
            listKontakt = (ArrayList<Kontakt>) Kontakt.getAll();

            mKontaktDataLoadedListener.onDataLoaded(listKontakt);

        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    /**
     * Metoda ucitava podatke o vozilima iz lokalne baze podataka
     *
     * @param voziloDataLoadedListener poseban listener koji ceka dolazak podataka o vozilima
     */
    @Override
    public void loadVoziloData(VoziloDataLoadedListener voziloDataLoadedListener){
        super.loadVoziloData(voziloDataLoadedListener);
        try{
            listVozilo = (ArrayList<Vozilo>) Vozilo.getAll();

            mVoziloDataLoadedListener.onDataLoaded(listVozilo);

        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    /**
     * Metoda ucitava podatke o pitanjima, bilo da su propisi ili prva pomoc, iz lokalne baze podataka
     *
     * @param pitanjeDataLoadedListener poseban listener koji ceka dolazak podataka o pitanjima
     * @param type predstavlja flag koji se koristi za raspoznavanje tipa pitanja, 1 = propisi, 2 = prva pomoc
     */
    @Override
    public void loadPitanjeData(PitanjeDataLoadedListener pitanjeDataLoadedListener, int type) {
        super.loadPitanjeData(pitanjeDataLoadedListener, type);
        try{
            if(type == 1) {
                listPitanje = (ArrayList<Pitanje>) Pitanje.getOnlyPropisi();
            }
            else{
                listPitanje = (ArrayList<Pitanje>) Pitanje.getOnlyPrvaPomoc();
            }

            mPitanjeDataLoadedListener.onDataLoaded(listPitanje);

        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
