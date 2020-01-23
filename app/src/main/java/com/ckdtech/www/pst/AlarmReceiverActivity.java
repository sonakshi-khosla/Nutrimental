package com.ckdtech.www.pst;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class AlarmReceiverActivity extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {

        //Get The Id And Message From The Intent.

        int notificationId = intent.getIntExtra("notificationId",0);
        String message = intent.getStringExtra("todo");

        //When Notification is Tapped, The main activity should be called .
        Intent mainIntent = new Intent(context,WaterReminderActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,0,mainIntent,0);

        NotificationManager myNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        //Now We Will Prepare For The Notification.

        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle("It's The Time!")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent);

        //Notify

        myNotificationManager.notify(notificationId,builder.build());
    }
}
