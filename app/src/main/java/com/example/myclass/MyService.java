package com.example.myclass;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    private  Mybinder binder;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("dolly","Start service......");
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.thescientist);
        mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("dolly","Destroy service......");
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("dolly","onBind service......");
        binder=new Mybinder();
        return binder;

    }
    class Mybinder extends Binder{
        public void myPlay(){
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.thescientist);
            mediaPlayer.start();
        }
    }
}