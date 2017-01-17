package com.bkl.air.foi.mdrivingschool.notifications;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Jurica Bunić on 27.12.2016..
 */

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "mDrivingSchool";
    private static final String FCM_TOKEN = "FCM_TOKEN";
    @Override
    public void onTokenRefresh() {
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"New Token:"+refreshToken);
        saveToken(refreshToken);
    }

    private void saveToken(String token){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString(FCM_TOKEN, token).apply();
    }
}
