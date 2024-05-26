package com.example.e_commerce;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService2 extends Service {
    MediaPlayer mp;

    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        mp = MediaPlayer.create(this, R.raw.add);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mp.isPlaying()) {
            mp.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.release();
        super.onDestroy();
    }
}
