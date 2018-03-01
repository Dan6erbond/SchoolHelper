package com.dan6erbond.schoolhelper;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Calendar;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SUNDAY)
            Log.i("TAG", "No Homework today!");
        if (day == Calendar.SATURDAY)
            Log.i("TAG", "No Homework today!");
        if (day == Calendar.MONDAY)
            Log.i("TAG", "Monday has been cancelled.");
        if (day == Calendar.WEDNESDAY)
            Log.i("TAG", "It's Wednesday my dudes.");
        if (day == Calendar.FRIDAY)
            Log.i("TAG", "Thank God it's Friday.");
        if(day != Calendar.SUNDAY && day != Calendar.SATURDAY){
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setContentTitle(context.getResources().getString(R.string.add_homework_notification_title))
                    .setContentText(context.getResources().getString(R.string.add_homework_notification_text));
            mBuilder.setDefaults(Notification.DEFAULT_SOUND);
            mBuilder.setAutoCancel(true);
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, mBuilder.build());
        }
    }
}
