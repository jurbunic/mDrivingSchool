package com.bkl.air.foi.mdrivingschool.helpers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


import com.bkl.air.foi.mdrivingschool.R;

/**
 * Created by Bunic on 11.11.2016..
 */

public class StartFragment {
    /**
     * Metoda koja poziva novi fragment. Ako je samo jedan fragment na backstacku tada se stvara novi fragment,
     * a ako na backstacku postoji vise fragmenta tada se prethodni fragment briše i poziva se novi
     *
     * @param fragment fragment kojeg pozivamo
     * @param mActivity aktivnost iz koje pozivamo fragment
     */

    public static void StartNewFragment (Fragment fragment, Activity mActivity){
        FragmentManager fragmentManager = mActivity.getFragmentManager();
        if(fragmentManager.getBackStackEntryCount()<=1){
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.addToBackStack("2");
            ft.replace(R.id.fragment_container,fragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.commit();
        }else {
            fragmentManager.popBackStack("1", 0);
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack("2")
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
    }
    /**
     * Metoda prima tri parametra. Dobiveni fragment pokreće i sprema ga na BackStack pod prosljeđenim
     * tagom. Ova metoda ne briše prethodni framgent sa backstacka.
     *
     * @param fragment fragment kojeg pozivamo
     * @param mActivity aktivnost iz koje pozivamo fragment
     * @param tag   oznaka pod kojom spremamo fragment na backstack
     */
    public static void StartNewFragment(Fragment fragment, Activity mActivity, String tag){
        FragmentTransaction fm = mActivity.getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, fragment);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack(tag);
        fm.commit();
    }
}
