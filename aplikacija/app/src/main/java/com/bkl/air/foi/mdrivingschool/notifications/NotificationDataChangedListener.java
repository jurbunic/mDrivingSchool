package com.bkl.air.foi.mdrivingschool.notifications;

/**
 * Created by Jurica Bunić on 20.1.2017..
 */

public interface NotificationDataChangedListener {
    public String getNotificationMessage();
    public String getUserId();
    public boolean getUserPreference();

}
