package com.bkl.air.foi.mdrivingschool.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HP on 28.1.2017..
 */
public class DateAndTimeCheckTest {

    DateAndTimeCheck dateAndTimeCheck = new DateAndTimeCheck();

    @Test
    public void isDateValid() throws Exception {

        assertTrue("Greška kod provjere datuma",dateAndTimeCheck.isDateValid("1.1.2017"));
        assertTrue("Greška kod provjere datuma",dateAndTimeCheck.isDateValid("31.12.2017"));

        assertFalse("Greška kod provjere datuma",dateAndTimeCheck.isDateValid("1.1.2200"));
        assertFalse("Greška kod provjere datuma",dateAndTimeCheck.isDateValid("1.85.2017"));
        assertFalse("Greška kod provjere datuma",dateAndTimeCheck.isDateValid("93.1.2017"));

    }

    @Test
    public void isTimeValid() throws Exception {

        assertTrue("Greška kod provjere vremena",dateAndTimeCheck.isTimeValid("24:00"));
        assertTrue("Greška kod provjere vremena",dateAndTimeCheck.isTimeValid("00:40"));
        assertTrue("Greška kod provjere vremena",dateAndTimeCheck.isTimeValid("15:30"));

        assertFalse("Greška kod provjere vremena",dateAndTimeCheck.isTimeValid("50:00"));
        assertFalse("Greška kod provjere vremena",dateAndTimeCheck.isTimeValid("22:140"));

    }

}