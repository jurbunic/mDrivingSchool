package com.bkl.air.foi.mdrivingschool.helpers;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Jurica Bunić on 27.1.2017..
 */
@RunWith(AndroidJUnit4.class)
public class StringDateParserTest {

    StringDateParser parser = new StringDateParser();
    String actualDate;
    String expectedDate;

    @Test
    public void toUserForm() throws Exception {
        actualDate = parser.toUserForm("2017-01-01");
        expectedDate = "01.01.2017";
        assertEquals("Greška kod parsiranja datuma za korisničko sučelje!",actualDate,expectedDate);

        actualDate = parser.toUserForm("2017-12-31");
        expectedDate = "31.12.2017";
        assertEquals("Greška kod parsiranja datuma za korisničko sučelje!",actualDate,expectedDate);

        actualDate = parser.toUserForm("2017-06-15");
        expectedDate = "15.06.2017";
        assertTrue("Greška kod parsiranja datuma za korisničko sučelje!", actualDate.equals(expectedDate));

        actualDate = parser.toUserForm("2017-08-07");
        expectedDate = "08.07.2017";
        assertFalse("Greška kod parsiranja datuma za korisničko sučelje!", actualDate.equals(expectedDate));

    }

    @Test
    public void toDatabase() throws Exception {
        actualDate = parser.toDatabase("1.1.2017");
        expectedDate = "2017-1-1";
        assertEquals("Greška kod parsiranja datuma za bazu!", actualDate,expectedDate);

        actualDate = parser.toDatabase("31.12.2017");
        expectedDate = "2017-12-31";
        assertEquals("Greška kod parsiranja datuma za bazu!", actualDate,expectedDate);

        actualDate = parser.toDatabase("15.6.2017");
        expectedDate = "2017-6-15";
        assertTrue("Greška kod parsiranja datuma za bazu!", actualDate.equals(expectedDate));

        actualDate = parser.toDatabase("8.7.2017");
        expectedDate = "2017-8-7";
        assertFalse("Greška kod parsiranja datuma za bazu!", actualDate.equals(expectedDate));

    }

}