package com.bkl.air.foi.mdrivingschool.notifications;

import android.os.AsyncTask;

/**
 * Created by Dalibor on 24.1.2017..
 */

public class NotificationBuilder {
    private String notificationMessage;
    private String userId;
    private String token;
    private String email;
    private boolean isMail;

    private NotificationDataChangedListener mNotificationDataChangedListener;
    private NotificationSenderInterface senderInterface;

    /**
     * Metoda pomocu TokerFetchera dobavlja token preko danog user id-a
     */
    private void getUserToken(){
        TokenFetcher fetcher = new TokenFetcher(userId);
        try{
            token = fetcher.execute().get().toString();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metoda pomocu EmailFetchera dohvaca email pojedinog polaznika preko user id-a
     */
    private void getUserEmail(){
        EmailFetcher emailFetcher = new EmailFetcher(userId);
        try{
            email = emailFetcher.execute().get().toString();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metoda pomoc NotificationSendera salje obavijest sa prosljedenom porukom prema uredjaju sa dobivenim tokenom
     *
     * @param notificationDataChangedListener poseban listener koji prati stanje poruke i userId-a za slanje obavijesti i prosljeduje ih NotificationBuilderu
     */
    public void sendNotification(NotificationDataChangedListener notificationDataChangedListener) {
        this.mNotificationDataChangedListener = notificationDataChangedListener;

        notificationMessage = mNotificationDataChangedListener.getNotificationMessage();
        userId = mNotificationDataChangedListener.getUserId();
        isMail = mNotificationDataChangedListener.getUserPreference();

        if(isMail){
            getUserEmail();
            senderInterface = new NotificationSenderMail(email, notificationMessage);
        }else{
            getUserToken();
            senderInterface = new NotificationSender(token, notificationMessage);
        }

        AsyncTask task = new AsyncTask<Object, Object, Void>() {
            @Override
            protected Void doInBackground(Object... params) {
                senderInterface.send();
                return null;
            }
        };
        task.execute();

    }
}
