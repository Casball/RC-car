package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnjoin, btnlogin;

        btnjoin = (Button) findViewById(R.id.join);
        btnlogin = (Button) findViewById(R.id.login);

        btnjoin.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), joinpage.class);
                    startActivity(intent);
                 }
             }
             );
        btnlogin.setOnClickListener(new Button.OnClickListener() {
                                       public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), loginstage.class);
                    startActivity(intent);
                            }
        }
        );
    }
}
