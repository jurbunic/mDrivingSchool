package com.bkl.air.foi.mdrivingschool.notifications;

/**
 * Created by Dalibor on 24.1.2017..
 */

public class NotificationBuilder {
    private String message;
    private String userId;
    private String token;

    private NotificationDataChangedListener mNotificationDataChangedListener;

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
     * Metoda pomoc NotificationSendera salje obavijest sa prosljedenom porukom prema uredjaju sa dobivenim tokenom
     *
     * @param notificationDataChangedListener poseban listener koji prati stanje poruke i userId-a za slanje obavijesti i prosljeduje ih NotificationBuilderu
     */
    public void sendNotification(NotificationDataChangedListener notificationDataChangedListener) {
        this.mNotificationDataChangedListener = notificationDataChangedListener;

        message = mNotificationDataChangedListener.getNotificationMessage();
        userId = mNotificationDataChangedListener.getUserId();

        getUserToken();

        NotificationSender notification = new NotificationSender(token, message);
        notification.execute();

    }
}
