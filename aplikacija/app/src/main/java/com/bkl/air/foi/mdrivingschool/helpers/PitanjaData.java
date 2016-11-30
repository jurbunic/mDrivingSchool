package com.bkl.air.foi.mdrivingschool.helpers;

import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.database.TipPitanja;
import com.bkl.air.foi.database.Vozilo;

import java.util.ArrayList;
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
    public static void nabaviPitanjaPrvaPomoc(List<Pitanje> listaPitanja){
        Pitanje pitanje = new Pitanje( 8, 2, "Sigurni znakovi smrti su:", "Mačje oko", "Mrtvačke pjege" ,"Prestanak disanja" , true, true, false, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 9, 2, "Odaberite ispravni redosljed pružanja prve pomoći", "neodgodiva pomoć, detaljan pregled, izvlačenje iz vozila", "izvlačenje iz vozila,neodgodiva pomoć, detaljan pregled" ,"neodgodiva pomoć, izvljačenje iz vozila, detaljan pregled" , false, false, true, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 10, 2, "Koji je najčešći uzroksmrti kod onesviještenih osoba?", "krvarenje", "gušenje" ,"šok" , false, true, false, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 11, 2, "Koje su ispravne radnje kada ozljeđena osoba krvari?", "Podvezivanje uda", "Izravan pritisak na ranu" ,"Postavljanje kompresnog zavoja na ranu" , true, true, true, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 12, 2, "Koji se znakovi javljaju kod iskrvarenja osobe", "Disanje ozljeđene osobe je duboko i smireno", "Puls je ubrzan i slab" ,"Koža je blijeda i hladna" , false, true, true, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 13, 2, "Koje metode umjetnog disanja postoje?", "Usta na usta", "Uho na uho" ,"Usta na nos" , true, false, true, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 14, 2, "Kako se naziva hvat za pomicanje osobe bez svijesti?", "Plackov hvat", "Rautekov hvat", "Skoratov hvat", false, true, false, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 15, 2, "Pitanje 21", "1", "2" ,"3" , true, false, false, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 16, 2, "t", "1", "2" ,"3" , false, true, true, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 17, 2, "t", "1", "2" ,"3" , false, false, true, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 18, 2, "t", "1", "2" ,"3" , false, true, false, "");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 19, 2, "t", "1", "2" ,"3" , true, true, false, "");
        listaPitanja.add(pitanje);
        pitanje.save();
    }
    public static void nabaviPodatkePitanja(List<Pitanje> listaPitanja) {
        Pitanje pitanje = new Pitanje(1, 1, "Kako reagiraju djeca u prometu ?", "razborito i staloženo", "nepredvidljivo",
                "u skladu sa prometnim pravilima i propisima", false, true, false, "http://www.spremi-klopu.com/img/site/article_infos/djeca_vegani.jpg");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(2, 1, "Koja svjetla u pravilu koristimo za osvjetljavanje ceste ?", "kratka svjetla", "duga svjetla",
                "pozicijska svjetla", false, true, false, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(3, 1, "ASP?", "A", "MN",
                "SP", true, false, true, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(4, 1, "BBb?", "B", "ggg",
                "ll", true, false, false, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(5, 1, "CCc?", "er", "Cc",
                "CCc", false, true, true, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(6, 1, "DDd?", "DD", "d",
                "DDd", true, true, true, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(7, 1, "Ejj?", "Ej", "opaaa",
                "jj", true, false, true, "http://www.vecernji.hr/media/cache/11/1b/111b17a4e5c0476a27b1c9a49c38bdb6.jpg");
        listaPitanja.add(pitanje);
        pitanje.save();
    }
    public static void nabaviPodatkeOdredenihPitanja(List<Pitanje> listaPitanja, List<Integer> listaOdredenih, int nekaj){
        List<Pitanje> privremenaLista = new ArrayList<>();
        if (nekaj == 1){
            PitanjaData.nabaviPodatkePitanja(privremenaLista);
        }else {
            PitanjaData.nabaviPitanjaPrvaPomoc(privremenaLista);
        }
        for(int i=0;i<listaOdredenih.size();i++){
            listaPitanja.add(privremenaLista.get(listaOdredenih.get(i)));
        }
    }
}
