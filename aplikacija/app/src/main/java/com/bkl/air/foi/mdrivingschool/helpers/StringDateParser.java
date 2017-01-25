package com.bkl.air.foi.mdrivingschool.helpers;

/**
 * Created by Jurica Bunić on 25.1.2017..
 */

public class StringDateParser {
    private String returnString="";


    public StringDateParser() {

    }

    public String toUserForm(String entry){
        String[] spliter = entry.split("\\-");
        returnString = spliter[2]+"."+spliter[1]+"."+spliter[0];
        return returnString;
    }

    public String toDatabase(String entry){
        String[] spliter = entry.split("\\.");
        returnString = spliter[2]+"-"+spliter[1]+"-"+spliter[0];
        return returnString;
    }
}
