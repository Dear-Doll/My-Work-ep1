package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;

public class CallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        Intent intent =getIntent();
        intent.putExtra("data","Call back for time.\n"+
                Calendar.getInstance().getTime());
        setResult(200,intent);
        finish();
    }
}