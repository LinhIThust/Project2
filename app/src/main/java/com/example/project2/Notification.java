package com.example.project2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.project2.account.Login;


import java.util.Calendar;

import static com.example.project2.GeneralProperties.checkLogOut;

public class Notification extends Service {

    public Notification() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this, Login.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Máy Lọc Nước")
                .setSmallIcon(R.drawable.ic_warning_black_24dp)
                .setContentText("Bạn có Bộ Lọc cần Thay!!!")
                .setAutoCancel(true)
                .setVisibility(android.app.Notification.VISIBILITY_PUBLIC)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent);

        if (checkLogOut == false) {
            int n = sharedPreferences.getInt("soLuong", 0);
            Log.d("aa", "onStartCommand: " + n);
            Calendar calendar = Calendar.getInstance();
            Log.d("a", "onStartCommand: " + calendar.getTimeInMillis());
            for (int i = 0; i < n; i++) {
                Log.d("aaaa", "onStartCommand: " + sharedPreferences.getLong("time" + i, -1L));
                if (calendar.getTimeInMillis() > sharedPreferences.getLong("time" + i, -1)) {
                    Log.d("aaaaaa", "onStartCommand: " + sharedPreferences.getLong("time" + i, -1L));
                    notificationManager.notify(0, builder.build());

                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
