package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends AppCompatActivity {

    Button button1,button2,button3,button4;
    private MediaPlayer mediaPlayer;
    private MyService.Mybinder mybinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        button1=findViewById(R.id.buttonmusic1);
        button2=findViewById(R.id.buttonmusic2);
        button3=findViewById(R.id.buttonbind);
        button4=findViewById(R.id.buttonunbind);

        Intent intent=new Intent(this,MyService.class);

        ServiceConnection connection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mybinder=(MyService.Mybinder)iBinder;
                mybinder.myPlay();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                mybinder=null;
            }
        };

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(intent,connection, Context.BIND_AUTO_CREATE);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("dolly","unbind service......");
                unbindService(connection);
            }
        });


    }
}