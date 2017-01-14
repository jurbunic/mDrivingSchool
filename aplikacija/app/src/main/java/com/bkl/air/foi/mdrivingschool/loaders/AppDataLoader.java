package com.bkl.air.foi.mdrivingschool.loaders;

import com.bkl.air.foi.core.DataLoader;
import com.bkl.air.foi.core.KontaktDataLoadedListener;
import com.bkl.air.foi.core.PitanjeDataLoadedListener;
import com.bkl.air.foi.core.VoziloDataLoadedListener;
import com.bkl.air.foi.database.Kontakt;
import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.mdrivingschool.helpers.KontaktData;
import com.bkl.air.foi.mdrivingschool.helpers.PitanjaData;
import com.bkl.air.foi.mdrivingschool.helpers.VozilaData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dalibor on 14.1.2017..
 */

public class AppDataLoader extends DataLoader{
    @Override
    public void loadKontaktData(KontaktDataLoadedListener kontaktDataLoadedListener){
        super.loadKontaktData(kontaktDataLoadedListener);

        listKontakt = new ArrayList<>();
        KontaktData.loadKontaktData(listKontakt);

        mKontaktDataLoadedListener.onDataLoaded(listKontakt);
    }
    @Override
    public void loadVoziloData(VoziloDataLoadedListener voziloDataLoadedListener){
        super.loadVoziloData(voziloDataLoadedListener);

        listVozilo = new ArrayList<>();
        VozilaData.nabaviPodatkeVozila(listVozilo);

        mVoziloDataLoadedListener.onDataLoaded(listVozilo);
    }
    @Override
    public void loadPitanjeData(PitanjeDataLoadedListener pitanjeDataLoadedListener, int type){
        super.loadPitanjeData(pitanjeDataLoadedListener, type);
        listPitanje = new ArrayList<>();
        if(type == 1) {
            PitanjaData.nabaviPitanjaPropisi(listPitanje);
        }
        else{
            PitanjaData.nabaviPitanjaPrvaPomoc(listPitanje);
        }
        mPitanjeDataLoadedListener.onDataLoaded(listPitanje);
    }

}
