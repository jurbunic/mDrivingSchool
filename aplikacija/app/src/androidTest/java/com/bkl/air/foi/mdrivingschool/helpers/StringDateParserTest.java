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
    @Test
    public void toUserForm() throws Exception {
        String actualDate = parser.toUserForm("2017-01-01");
        String expectedDate = "01.01.2017";
        assertEquals("Greška kod parsiranja datuma za korisničko sučelje!",actualDate,expectedDate);
        actualDate = parser.toUserForm("2017-12-31");
        expectedDate = "31.12.2017";
        assertEquals("Greška kod parsiranja datuma za korisničko sučelje!",actualDate,expectedDate);

    }

    @Test
    public void toDatabase() throws Exception {
        String actualDate = parser.toDatabase("1.1.2017");
        String expectedDate = "2017-1-1";
        assertEquals("Greška kod parsiranja datuma za bazu!", actualDate,expectedDate);
        actualDate = parser.toDatabase("31.12.2017");
        expectedDate = "2017-12-31";
        assertEquals("Greška kod parsiranja datuma za bazu!", actualDate,expectedDate);

    }

}