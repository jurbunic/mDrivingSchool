package com.bkl.air.foi.mdrivingschool.helpers;

import com.bkl.air.foi.database.Pitanje;
import com.bkl.air.foi.database.TipPitanja;
import java.util.List;

/**
 * Created by Dalibor on 23.11.2016..
 */

public class PitanjaData {
    /**
     * Metoda puni listu tipova pitanja sa svim dostupnim tipovima pitanja
     *
     * @param listaTipovaPitanja Lista tipova pitanja koja se vraca puna nakon sto se metoda izvrsi
     */
    public static void nabaviTipovePitanja(List<TipPitanja> listaTipovaPitanja){
        TipPitanja tipPitanja = new TipPitanja(1, "Propisi");
        listaTipovaPitanja.add(tipPitanja);

        tipPitanja = new TipPitanja(2, "Prva pomoc");
        listaTipovaPitanja.add(tipPitanja);
    }

    /**
     * Metoda puni listu listaPitanja sa svim trenutno dostupnim pitanjima iz prve pomoci i sprema ih u bazu
     *
     * @param listaPitanja Lista pitanja koja se vraca puna nakon sto metoda zavrsi
     */
    public static void nabaviPitanjaPrvaPomoc(List<Pitanje> listaPitanja){
        Pitanje pitanje = new Pitanje( 8, 2, "Sigurni znakovi smrti su:", "Mačje oko", "Mrtvačke pjege" ,"Prestanak disanja" , true, true, false, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 9, 2, "Odaberite ispravni redosljed pružanja prve pomoći", "neodgodiva pomoć, detaljan pregled, izvlačenje iz vozila", "izvlačenje iz vozila,neodgodiva pomoć, detaljan pregled" ,"neodgodiva pomoć, izvljačenje iz vozila, detaljan pregled" , false, false, true, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 10, 2, "Koji je najčešći uzroksmrti kod onesviještenih osoba?", "krvarenje", "gušenje" ,"šok" , false, true, false, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 11, 2, "Koje su ispravne radnje kada ozljeđena osoba krvari?", "Podvezivanje uda", "Izravan pritisak na ranu" ,"Postavljanje kompresnog zavoja na ranu" , true, true, true, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 12, 2, "Koji se znakovi javljaju kod iskrvarenja osobe", "Disanje ozljeđene osobe je duboko i smireno", "Puls je ubrzan i slab" ,"Koža je blijeda i hladna" , false, true, true, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 13, 2, "Koje metode umjetnog disanja postoje?", "Usta na usta", "Uho na uho" ,"Usta na nos" , true, false, true, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 14, 2, "Kako se naziva hvat za pomicanje osobe bez svijesti?", "Plackov hvat", "Rautekov hvat", "Skoratov hvat", false, true, false, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 15, 2, "Koja su standardna sredstva za pružanje prve pomoći", "sredstva iz kutije prve pomoći", "prometni trokut" ,"kravata" , true, false, false, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 16, 2, "Označite najčešći uzroke gubitka svijesti?", "Iščašenje zgloba", "Ozljeda glave" ,"Otrovanje ispušnim plinovima" , false, true, true, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 17, 2, "Koji je broj prve pomoći?", "194", "192" ,"112" , true, false, true, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 18, 2, "Kada onesviještenog moramo staviti u položaj na trbuh?", "Kod ozljede trbuha", "Kod ozljede kralježnice" ,"Kod probojne rane prsnog koša" , false, true, false, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
        pitanje = new Pitanje( 19, 2, "Koji su znakovi šoka?", " Unesrećeni izgleda odsutno", "koža blijeda i hladna" ,"Ubrzani i slabi puls" , true, true, true, "img_prva_pomoc_def");
        listaPitanja.add(pitanje);
        pitanje.save();
    }

    /**
     * Metoda puni listu listaPitanja sa svim trenutno dostupnim pitanjima iz propisa i sprema ih u bazu
     *
     * @param listaPitanja Lista pitanja koja se vraca puna nakon sto metoda zavrsi
     */
    public static void nabaviPitanjaPropisi(List<Pitanje> listaPitanja) {
        Pitanje pitanje = new Pitanje(1, 1, "Kako reagiraju djeca u prometu ?", "razborito i staloženo", "nepredvidljivo",
                "u skladu sa prometnim pravilima i propisima", false, true, false, "img_propisi_id1");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(2, 1, "Koja svjetla u pravilu koristimo za osvjetljavanje ceste ?", "kratka svjetla", "duga svjetla",
                "pozicijska svjetla", false, true, false, "img_propisi_id2");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(3, 1, "Koja je brzina ograničenja u naselju, ako znakom nije drugačije određeno ?", "60 km/h",
                "40 km/h", "50 km/h", false, false, true, "img_propisi_id3");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(4, 1, "Zašto nastaje vodeni klin ?", "zbog velike brzine", "zbog novih guma jer one slabije prijanjaju na kolnik",
                "zbog velike količine vode na kolnik", true, false, true, "img_propisi_id4");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(5, 1, "Koja je najmanja dopuštena brzina vožnje u normalnim prometnim uvjetima ?", "30 km/h",
                "40 km/h", "50 km/h", false, true, false, "img_propisi_id5");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje (6, 1, "Kako ćete postupiti u ovoj situaciji ?", "propustiti crveni automobil", "voziti prvi kroz raskrižje",
                "ništa od navedenog", false, true, false, "img_propisi_id6");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(7, 1, "Što je pretjecanje ?", "prolaženje pokraj zaustavljenog vozila", "prolaženje pokraj vozila koje dolazi iz suprotnog smjera",
                "prolaženje pokraj vozila koje se kreće u istom smjeru", false, false, true, "img_propisi_id7");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(20, 1, "Koji je redoslijed vozila ?", "autobus , mi , crveno vozilo", "mi, autobus, crveno vozilo",
                "crveno vozilo , mi , autobus", true, false, false, "img_propisi_id20");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(21, 1, "Što utječe na zaustavni put ?", "brzina vožnje", "gustoča prometa", "stanje kolnika",
                true, false, true, "img_propisi_id21");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(22, 1, "Gdje je zabranjeno polukružno okretanje ?", "na autocesti", "u tunelu", "na cesti s jednosmjernim prometom",
                true, true, true, "img_propisi_id22");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(23, 1, "Zbog čega je vožnja pod utjecajem alkohola opasna ?", "alkohol smanjuje vidno polje kod vozača",
                "pod utjecajem alkohola vozač reagira razborito i staloženo", "alkohol na vozača djeluje prividno stimulativno", true, false, true, "img_propisi_id23");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(24, 1, "Kad je dopušteno pretjecati ?", "ako se pretjecanjem ne ugrožavaju vozila iz suprotnog smjera",
                "ako vozilo iza nije započelo pretjecanje", "ako prometnim znakom nije zabranjeno pretjecanje", true, true, true, "img_propisi_id24");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(25, 1, "Što za vas znači kad je na semaforu upaljeno crveno istodobno sa žutim svjetlom ?", "slobodan prolazak",
                "skoru pojavu zelenog svjetla", "zabrana prolaska", false, true, true, "img_propisi_id25");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(26, 1, "Kako ćete postupiti u prikazanoj situaciji ?", "povečati oprez", "propustiti biciklistu", "voziti prije bicikliste",
                true, true, false, "img_propisi_id26");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(27, 1, "Što za vas znači ovaj znak ?", "da moram obavezno voziti ravno", "da se nesmijem polukružno okretati kad vozim po ulici koja je označena takavim znakom",
                "da vozim po cesti s jednosmjernim prometom", false, false, true, "img_propisi_id27");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(28, 1, "Kako ćete postupiti nakon ovog prometnog znaka ?", "obvezno se zaustaviti", "propustiti vozila koja dolaze po cesti sa prednošću prolaska",
                "po potrebi se zaustaviti", false, true, true, "img_propisi_id28");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(29, 1, "Kako se zove ovaj prometni znak ?", "štefov križ", "andrijin križ", "blažov križ", false, true, false,
                "img_propisi_id29");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(30, 1, "Na što ukazuje ovaj prometni znak ?", "da vozim po autocesti", "da nesmijem voziti brže od 110 km/h",
                "da vozim po cesti isključivo za promet motornih vozila", false, true, true, "img_propisi_id30");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(31, 1, "Što za vas znači prikazani znak ?", "dopušteno zaustavljanje", "zabrana zaustavljnja i parkiranja",
                "dopušteno parkiranje", false, true, false, "img_propisi_id31");
        listaPitanja.add(pitanje);
        pitanje.save();

        pitanje = new Pitanje(32, 1, "Što predstavlja ovaj znak ?", "Promet vozila u oba smjera", "Obvezu propuštanja vozila iz suprotnog smjera",
                "Početak jednosmjerne ulice", true, false, false, "img_propisi_id32");
        listaPitanja.add(pitanje);
        pitanje.save();
    }

    /**
     * Metoda nabavlja podatke samo onih pitanja ciji su mu brojevi (id) prosljedeni u listiOdredenih pitanja prema tipu
     *
     * @param listaPitanja Lista koju metoda napuni sa pitanjima danih id-jeva
     * @param listaOdredenih Lista u kojoj se nalaze id-jevi odredenih pitanja
     * @param tipPitanja Tip pitanja koji se trazi (1 - propisi ili 2 - prva pomoc)
     */
    public static void nabaviPodatkeOdredenihPitanja(List<Pitanje> listaPitanja, List<Integer> listaOdredenih, int tipPitanja){
        List<Pitanje> privremenaLista;
        if (tipPitanja == 1){
            privremenaLista = Pitanje.getOnlyPropisi();
        }else {
            privremenaLista = Pitanje.getOnlyPrvaPomoc();
        }
        for(int i=0;i<listaOdredenih.size();i++){
            listaPitanja.add(privremenaLista.get(listaOdredenih.get(i)));
        }
    }
}
