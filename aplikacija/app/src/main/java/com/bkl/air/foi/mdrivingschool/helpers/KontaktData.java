package com.bkl.air.foi.mdrivingschool.helpers;

import com.bkl.air.foi.database.Kontakt;

import java.util.List;

/**
 * Created by Bunic on 3.11.2016..
 */

public class KontaktData {

    public static void loadKontaktData(List<Kontakt> lista){
        Kontakt kontakt1 = new Kontakt();
        kontakt1.setId(1);
        kontakt1.setIme("Josip");
        kontakt1.setPrezime("Premuž");
        kontakt1.setMobitel("098 673 072");
        kontakt1.setSlikaUrl("http://autoskola-premuz.hr/wp-content/uploads/2012/01/josippremuz.png");
        lista.add(kontakt1);

        Kontakt kontakt2 = new Kontakt();
        kontakt2.setId(2);
        kontakt2.setIme("Ivica");
        kontakt2.setPrezime("Hosni");
        kontakt2.setMobitel("091 353 0752");
        kontakt2.setSlikaUrl("http://autoskola-premuz.hr/wp-content/uploads/2012/01/ivicahosni.png");
        lista.add(kontakt2);

        Kontakt kontakt3 = new Kontakt();
        kontakt3.setId(3);
        kontakt3.setIme("Mario");
        kontakt3.setPrezime("Rudolf");
        kontakt3.setMobitel("091 733 4272");
        kontakt3.setSlikaUrl("http://autoskola-premuz.hr/wp-content/uploads/2012/01/mariorudolf.png");
        lista.add(kontakt3);
    }
}
