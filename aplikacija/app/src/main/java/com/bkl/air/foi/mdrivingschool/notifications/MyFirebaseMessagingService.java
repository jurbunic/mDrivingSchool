package com.bkl.air.foi.mdrivingschool.notifications;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.bkl.air.foi.mdrivingschool.MainActivity;
import com.bkl.air.foi.mdrivingschool.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

/**
 * Created by Jurica Bunić on 27.12.2016..
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"From:"+remoteMessage.getFrom());

        if(remoteMessage.getData().size()>0){
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null){
            Log.d(TAG, "Message NotificationDataChangedListener Body: " + remoteMessage.getNotification().getBody());
        }

        openNotification(remoteMessage.getData().toString());
    }

    /**
     * Metoda za prikaz primljene notifikacije.
     *
     * @param messageBody podaci notifikacije (tip String)
     */
    private void openNotification(String messageBody){
        // Podaci su zapisani u JSON obliku, pa ih je potrebno parsirati
        String body = "";
        try {
            JSONObject jobject = new JSONObject(messageBody);
            body = jobject.getString("message");
        }catch(Exception e){
            e.printStackTrace();
        }
        // Notifikacije šaljemo koristeći _ umjesto razmaka, pa je za prikaz notifikacije
        // potrebno zamijeniti _ sa razmakom.
        String full=body.replace('_',' ').replace('$',':');

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("body",messageBody);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSounduri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("Autoškola Premuž")
                .setContentText(full)
                .setAutoCancel(true)
                .setSound(defaultSounduri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0,notificationBuilder.build());
    }

}
