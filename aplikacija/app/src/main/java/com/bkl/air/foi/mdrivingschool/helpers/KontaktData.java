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
        kontakt1.setIme("Ivo");
        kontakt1.setPrezime("Ivic");
        kontakt1.setMobitel("091 333 4444");
        kontakt1.setEmail("iivic@mail.com");
        lista.add(kontakt1);

        Kontakt kontakt2 = new Kontakt();
        kontakt2.setId(2);
        kontakt2.setIme("Ana");
        kontakt2.setPrezime("Anic");
        kontakt2.setMobitel("092 222 3333");
        kontakt2.setEmail("aanic@mail.com");
        lista.add(kontakt2);
    }
}
