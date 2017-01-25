package com.bkl.air.foi.mdrivingschool.notifications;

/**
 * Created by Dalibor on 24.1.2017..
 */

public class NotificationBuilder {
    private String message;
    private String userId;
    private String token;

    private NotificationDataChangedListener mNotificationDataChangedListener;

    private void getUserToken(){

        TokenFetcher fetcher = new TokenFetcher(userId);
        try{
            token = fetcher.execute().get().toString();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendNotification(NotificationDataChangedListener notificationDataChangedListener) {
        this.mNotificationDataChangedListener = notificationDataChangedListener;

        message = mNotificationDataChangedListener.getNotificationMessage();
        userId = mNotificationDataChangedListener.getUserId();

        getUserToken();

        NotificationSender notification = new NotificationSender(token, message);
        notification.execute();

    }
}
