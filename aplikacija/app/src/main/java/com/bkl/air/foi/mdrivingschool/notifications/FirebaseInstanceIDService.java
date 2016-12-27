package com.bkl.air.foi.mdrivingschool.notifications;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Jurica Bunić on 27.12.2016..
 */

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "";

    @Override
    public void onTokenRefresh() {
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"New Token:"+refreshToken);
    }
}
