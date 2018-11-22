package com.valencia.ambulanceroute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setContentView(R.layout.activity_splash);
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ActivitySplash.this, ActivityIniciarSesion.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(tarea,2000);
    }

}

