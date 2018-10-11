package net.ozero.timertaskpractice.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import net.ozero.timertaskpractice.R;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends IntentService {

    public TimerService() {
        super("TimerService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.i(getClass().getName(), "onHandleIntent");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                sendNotification();
            }
        };
        timer.schedule(
                task,
                new Date(System.currentTimeMillis() + 10*1000)
        );

        Log.i(getClass().getName(), "task set");
    }

    private void sendNotification() {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Title")
                        .setContentText("Notification text");

        Notification notification = builder.build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        assert notificationManager != null;
        notificationManager.notify(1, notification);

        Log.i(getClass().getName(), "notification sent");
    }

    @Override
    public void onDestroy() {

        Log.i(getClass().getName(), "onDestroy");

        super.onDestroy();
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {

        Log.i(getClass().getName(), "onTaskRemoved");

        super.onTaskRemoved(rootIntent);
    }
}
