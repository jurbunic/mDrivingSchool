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

    public static void StartNewFragment (Fragment fragment, Activity mActivity){
        /*

        */

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
    /**StartFragment
     * Metoda prima tri parametra. Dobiveni fragment pokreće i sprema ga na BackStack pod prosljeđenim
     * tagom
     *
     * @param fragment tip Fragment
     * @param mActivity tip Activity
     * @param tag   tip String
     */
    public static void StartNewFragment(Fragment fragment, Activity mActivity, String tag){
        FragmentTransaction fm = mActivity.getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, fragment);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack(tag);
        fm.commit();
    }
}
