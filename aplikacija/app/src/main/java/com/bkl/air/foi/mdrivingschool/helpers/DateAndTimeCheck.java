package com.bkl.air.foi.mdrivingschool.helpers;

/**
 * Created by Jurica Bunić on 27.1.2017..
 */

public class DateAndTimeCheck {
    public static boolean isDateValid(String date){
        String[] splited = date.split("\\.");
        boolean valid = true;
        try {
            int year = Integer.parseInt(splited[2]);
            int month = Integer.parseInt(splited[1]);
            int day = Integer.parseInt(splited[0]);

            if(year < 1920 || year > 2100){
                valid = false;
            }
            if(month < 1 || month > 12){
                valid = false;
            }
            if(day < 1 || day > 31){
                valid = false;
            }
        }catch (Exception e){
            valid = false;
        }
        return valid;
    }

    public static boolean isTimeValid(String time){
        String[] splited = time.split("\\:");
        boolean valid = true;
        try {
            int hour = Integer.parseInt(splited[0]);
            int minute = Integer.parseInt(splited[1]);

            if(hour > 24 || hour < 0){
                valid = false;
            }
            if(minute > 60 || minute < 0){
                valid = false;
            }

        }catch (Exception e){
            valid = false;
        }
        return valid;
    }
}
