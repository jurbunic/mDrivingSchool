package com.bkl.air.foi.mdrivingschool.helpers;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Dalibor on 11.11.2016..
 */

public class EmailSender{
    /**
     * Metoda je zaduzena za slanje e-maila autoskoli sa naslovom i porukom koje joj se proslijede
     *
     * @param poruka Prosljedena poruka
     * @param naslov Prosljedjen naslov
     * @param mActivity Prosljeden activity kako bi se znao context (zbog startActivity-a i Toasta)
     */
    public void posaljiMail(String poruka, String naslov, Activity mActivity){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"info.autoskola.premuz@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, naslov);
        i.putExtra(Intent.EXTRA_TEXT, poruka);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            mActivity.startActivity(Intent.createChooser(i, "Odaberite e-mail client..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mActivity, "Nažalost, nije pronađen e-mail client na vašem uređaju.", Toast.LENGTH_LONG).show();
        }
    }

}
