package com.bkl.air.foi.mdrivingschool.helpers;

import com.bkl.air.foi.database.Kontakt;

import java.util.List;

/**
 * Created by Bunic on 3.11.2016..
 */

public class KontaktData {

    /**
     * Metoda puni listu kontakta sa mogućim kontaktima i sprema ih u lokalnu bazu
     *
     *
     * @param lista --lista tipa Kontakt u koju će se spremati kontakti
     */
    public static void loadKontaktData(List<Kontakt> lista){
        Kontakt kontakt1 = new Kontakt();
        kontakt1.setId(1);
        kontakt1.setIme("Josip");
        kontakt1.setPrezime("Premuž");
        kontakt1.setMobitel("098 673 072");
        kontakt1.setSlikaUrl("http://autoskola-premuz.hr/wp-content/uploads/2012/01/josippremuz.png");
        lista.add(kontakt1);
        kontakt1.save();

        Kontakt kontakt2 = new Kontakt();
        kontakt2.setId(2);
        kontakt2.setIme("Ivica");
        kontakt2.setPrezime("Hosni");
        kontakt2.setMobitel("091 353 0752");
        kontakt2.setSlikaUrl("http://autoskola-premuz.hr/wp-content/uploads/2012/01/ivicahosni.png");
        lista.add(kontakt2);
        kontakt2.save();

        Kontakt kontakt3 = new Kontakt();
        kontakt3.setId(3);
        kontakt3.setIme("Mario");
        kontakt3.setPrezime("Rudolf");
        kontakt3.setMobitel("091 733 4272");
        kontakt3.setSlikaUrl("http://autoskola-premuz.hr/wp-content/uploads/2012/01/mariorudolf.png");
        lista.add(kontakt3);
        kontakt3.save();

        Kontakt kontakt4 = new Kontakt();
        kontakt4.setId(4);
        kontakt4.setIme("Denis");
        kontakt4.setPrezime("Pernarić");
        kontakt4.setMobitel("098 9264 421");
        kontakt4.setSlikaUrl("http://autoskola-premuz.hr/wp-content/uploads/2016/11/instruktor.jpg");
        lista.add(kontakt4);
        kontakt4.save();

        Kontakt kontakt5 = new Kontakt();
        kontakt5.setId(5);
        kontakt5.setIme("Miljenko");
        kontakt5.setPrezime("Šarec");
        kontakt5.setMobitel("095 4284 699");
        kontakt5.setSlikaUrl("http://autoskola-premuz.hr/wp-content/uploads/2016/11/instruktor.jpg");
        lista.add(kontakt5);
        kontakt5.save();
    }
}
