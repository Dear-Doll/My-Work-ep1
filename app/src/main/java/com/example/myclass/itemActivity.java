package com.example.myclass;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class itemActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Log.d("dolly>","on create.........");
        if(getSupportActionBar()!=null){getSupportActionBar().hide();}
        textView=findViewById(R.id.textView7);
        button=findViewById(R.id.buttoncall);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(itemActivity.this,CallbackActivity.class);
                test.launch(intent);
            }
        });
    }

    public ActivityResultLauncher test= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==200){
                        Log.d("dolly","onActivityResult called back....");
                        textView.setText(result.getData().getStringExtra("data"));

                    };
                }
            });

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("dolly>","on start.........");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("dolly>","on stop.........");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("dolly>","on destroy.........");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("dolly>","on pause.........");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("dolly>","on resume.........");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("dolly>","on restart.........");
    }

}