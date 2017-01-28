package com.bkl.air.foi.mdrivingschool.helpers;

/**
 * Created by Jurica Bunić on 25.1.2017..
 */

public class StringDateParser {
    private String returnString="";


    public StringDateParser() {

    }

    /**
     * Metoda za pretvaranje datuma u prikaz koji je prikladniji za čitanje.
     *
     * @param entry datum tipa String kojeg vraća baza u obliku yyyy-MM-dd
     * @return datum tipa string oblika dd.MM.yyyy
     */
    public String toUserForm(String entry){
        String[] spliter = entry.split("\\-");
        returnString = spliter[2]+"."+spliter[1]+"."+spliter[0];
        return returnString;
    }

    /**
     * Metoda za pretvaranje korisničkog unosa datuma oblika dd.MM.yyyy u datum pogodan za spremanje u bazu
     *
     * @param entry datum tipa String kojeg unosi korisnik u obliku dd.MM.yyyy
     * @return datum tipa string oblika yyyy-MM-dd
     */
    public String toDatabase(String entry){
        String[] spliter = entry.split("\\.");
        returnString = spliter[2]+"-"+spliter[1]+"-"+spliter[0];
        return returnString;
    }
}
