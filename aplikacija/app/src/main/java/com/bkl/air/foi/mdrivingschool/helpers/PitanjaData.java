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
        Pitanje pitanje = new Pitanje( 8, 2, "Sigurni znakovi smrti su:", "Mačje oko", "Mrtvačke pjege" ,"Prestanak disanja" , true, true, false, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 9, 2, "Odaberite ispravni redosljed pružanja prve pomoći", "neodgodiva pomoć, detaljan pregled, izvlačenje iz vozila", "izvlačenje iz vozila,neodgodiva pomoć, detaljan pregled" ,"neodgodiva pomoć, izvljačenje iz vozila, detaljan pregled" , false, false, true, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 10, 2, "Koji je najčešći uzroksmrti kod onesviještenih osoba?", "krvarenje", "gušenje" ,"šok" , false, true, false, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 11, 2, "Koje su ispravne radnje kada ozljeđena osoba krvari?", "Podvezivanje uda", "Izravan pritisak na ranu" ,"Postavljanje kompresnog zavoja na ranu" , true, true, true, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 12, 2, "Koji se znakovi javljaju kod iskrvarenja osobe", "Disanje ozljeđene osobe je duboko i smireno", "Puls je ubrzan i slab" ,"Koža je blijeda i hladna" , false, true, true, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 13, 2, "Koje metode umjetnog disanja postoje?", "Usta na usta", "Uho na uho" ,"Usta na nos" , true, false, true, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 14, 2, "Kako se naziva hvat za pomicanje osobe bez svijesti?", "Plackov hvat", "Rautekov hvat", "Skoratov hvat", false, true, false, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 15, 2, "Koja su standardna sredstva za pružanje prve pomoći", "sredstva iz kutije prve pomoći", "prometni trokut" ,"kravata" , true, false, false, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 16, 2, "Označite najčešći uzroke gubitka svijesti?", "Iščašenje zgloba", "Ozljeda glave" ,"Otrovanje ispušnim plinovima" , false, true, true, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 17, 2, "Koji je broj prve pomoći?", "194", "192" ,"112" , true, false, true, "");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 18, 2, "Kada onesviještenog moramo staviti u položaj na trbuh?", "Kod ozljede trbuha", "Kod ozljede kralježnice" ,"Kod probojne rane prsnog koša" , false, true, false, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
        pitanje = new Pitanje( 19, 2, "Koji su znakovi šoka?", " Unesrećeni izgleda odsutno", "koža blijeda i hladna" ,"Ubrzani i slabi puls" , true, true, true, "blank");
        listaPitanja.add(pitanje);
        //pitanje.save();
    }
    public static void nabaviPodatkePitanja(List<Pitanje> listaPitanja) {
        Pitanje pitanje = new Pitanje(1, 1, "Kako reagiraju djeca u prometu ?", "razborito i staloženo", "nepredvidljivo",
                "u skladu sa prometnim pravilima i propisima", false, true, false, "http://i.imgur.com/Mc8h0zP.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(2, 1, "Koja svjetla u pravilu koristimo za osvjetljavanje ceste ?", "kratka svjetla", "duga svjetla",
                "pozicijska svjetla", false, true, false, "http://i.imgur.com/YtCQdps.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(3, 1, "Koja je brzina ograničenja u naselju, ako znakom nije drugačije određeno ?", "60 km/h",
                "40 km/h", "50 km/h", false, false, true, "http://i.imgur.com/FgRBLPI.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(4, 1, "Zašto nastaje vodeni klin ?", "zbog velike brzine", "zbog novih guma jer one slabije prijanjaju na kolnik",
                "zbog velike količine vode na kolnik", true, false, true, "http://i.imgur.com/rFb46TQ.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(5, 1, "Koja je najmanja dopuštena brzina vožnje u normalnim prometnim uvjetima ?", "30 km/h",
                "40 km/h", "50 km/h", false, true, false, "http://i.imgur.com/68t3Xqh.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje (6, 1, "Kako ćete postupiti u ovoj situaciji ?", "propustiti crveni automobil", "voziti prvi kroz raskrižje",
                "ništa od navedenog", false, true, false, "http://autoskola-premuz.hr/wp-content/uploads/2012/09/1.jpg");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(7, 1, "Što je pretjecanje ?", "prolaženje pokraj zaustavljenog vozila", "prolaženje pokraj vozila koje dolazi iz suprotnog smjera",
                "prolaženje pokraj vozila koje se kreće u istom smjeru", false, false, true, "http://i.imgur.com/FQ1yr6F.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(20, 1, "Koji je redoslijed vozila ?", "autobus , mi , crveno vozilo", "mi, autobus, crveno vozilo",
                "crveno vozilo , mi , autobus", true, false, false, "http://autoskola-premuz.hr/wp-content/uploads/2012/09/8.jpg");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(21, 1, "Što utječe na zaustavni put ?", "brzina vožnje", "gustoča prometa", "stanje kolnika",
                true, false, true, "http://i.imgur.com/nHlJMu4.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(22, 1, "Gdje je zabranjeno polukružno okretanje ?", "na autocesti", "u tunelu", "na cesti s jednosmjernim prometom",
                true, true, true, "http://i.imgur.com/8ueibyu.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(23, 1, "Zbog čega je vožnja pod utjecajem alkohola opasna ?", "alkohol smanjuje vidno polje kod vozača",
                "pod utjecajem alkohola vozač reagira razborito i staloženo", "alkohol na vozača djeluje prividno stimulativno", true, false, true, "http://i.imgur.com/4qJhtyt.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(24, 1, "Kad je dopušteno pretjecati ?", "ako se pretjecanjem ne ugrožavaju vozila iz suprotnog smjera",
                "ako vozilo iza nije započelo pretjecanje", "ako prometnim znakom nije zabranjeno pretjecanje", true, true, true, "http://i.imgur.com/Btqn3A9.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(25, 1, "Što za vas znači kad je na semaforu upaljeno crveno istodobno sa žutim svjetlom ?", "slobodan prolazak",
                "skoru pojavu zelenog svjetla", "zabrana prolaska", false, true, true, "http://i.imgur.com/pfrCVHf.png");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(26, 1, "Kako ćete postupiti u prikazanoj situaciji ?", "povečati oprez", "propustiti biciklistu", "voziti prije bicikliste",
                true, true, false, "http://autoskola-premuz.hr/wp-content/uploads/2012/09/7.jpg");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(27, 1, "Što za vas znači ovaj znak ?", "da moram obavezno voziti ravno", "da se nesmijem polukružno okretati kad vozim po ulici koja je označena takavim znakom",
                "da vozim po cesti s jednosmjernim prometom", false, false, true, "http://autoskola-premuz.hr/wp-content/uploads/2012/09/jednosmjernacesta.gif");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(28, 1, "Kako ćete postupiti nakon ovog prometnog znaka ?", "obvezno se zaustaviti", "propustiti vozila koja dolaze po cesti sa prednošću prolaska",
                "po potrebi se zaustaviti", false, true, true, "http://autoskola-premuz.hr/wp-content/uploads/2012/09/nailazaknaglavnucestu.gif");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(29, 1, "Kako se zove ovaj prometni znak ?", "štefov križ", "andrijin križ", "blažov križ", false, true, false,
                "http://autoskola-premuz.hr/wp-content/uploads/2012/09/andrijinkriz.gif");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(30, 1, "Na što ukazuje ovaj prometni znak ?", "da vozim po autocesti", "da nesmijem voziti brže od 110 km/h",
                "da vozim po cesti isključivo za promet motornih vozila", false, true, true, "http://autoskola-premuz.hr/wp-content/uploads/2012/09/cizpmv.gif");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(31, 1, "Što za vas znači prikazani znak ?", "dopušteno zaustavljanje", "zabrana zaustavljnja i parkiranja",
                "dopušteno parkiranje", false, true, false, "http://autoskola-premuz.hr/wp-content/uploads/2012/09/zaustavljanjeiparkiranje.gif");
        listaPitanja.add(pitanje);
        //pitanje.save();

        pitanje = new Pitanje(32, 1, "Što predstavlja ovaj znak ?", "Promet vozila u oba smjera", "Obvezu propuštanja vozila iz suprotnog smjera",
                "Početak jednosmjerne ulice", true, false, false, "http://autoskola-premuz.hr/wp-content/uploads/2012/09/prometuobasmjera.gif");
        listaPitanja.add(pitanje);
        //pitanje.save();
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
