package com.bkl.air.foi.mdrivingschool.helpers;

import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.database.TipPitanja;
import com.bkl.air.foi.database.Vozilo;

import java.util.List;

/**
 * Created by Dalibor on 23.11.2016..
 */

public class PitanjaData {
    public static void nabaviTipovePitanja(List<TipPitanja> listaTipovaPitanja){
        TipPitanja tipPitanja = new TipPitanja(1, "Propisi");
        listaTipovaPitanja.add(tipPitanja);

        tipPitanja = new TipPitanja(2, "Prva pomoc");
        listaTipovaPitanja.add(tipPitanja);
    }
    public static void nabaviPodatkePitanja(List<Pitanje> listaPitanja) {
        Pitanje pitanje = new Pitanje(1, 1, "Kako reagiraju djeca u prometu ?", "razborito i staloženo", "nepredvidljivo",
                "u skladu sa prometnim pravilima i propisima", false, true, false, "http://www.spremi-klopu.com/img/site/article_infos/djeca_vegani.jpg");
        listaPitanja.add(pitanje);

        pitanje = new Pitanje(2, 1, "Koja svjetla u pravilu koristimo za osvjetljavanje ceste ?", "kratka svjetla", "duga svjetla",
                "pozicijska svjetla", false, true, false, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);

        pitanje = new Pitanje(3, 1, "AAa?", "a", "aa",
                "aaa", false, true, true, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);

        pitanje = new Pitanje(4, 1, "BBb?", "b", "bb",
                "bbb", true, true, true, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);

        pitanje = new Pitanje(5, 1, "CCc?", "c", "cc",
                "ccc", true, true, true, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);

        pitanje = new Pitanje(6, 1, "DDd?", "d", "dd",
                "ddd", false, true, true, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);
    }
}
