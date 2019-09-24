package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.Socket;

public class joinpage extends AppCompatActivity {
    Socket socket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinpage);

        final EditText idd, passd, ipd;
        Button sub, can;
        idd = (EditText) findViewById(R.id.idd);
        passd = (EditText) findViewById(R.id.pass);
        ipd = (EditText) findViewById(R.id.ipd);

        sub = (Button) findViewById(R.id.submit);
        can = (Button) findViewById(R.id.cancel);

        sub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String id = idd.getText().toString();
                String pass = passd.getText().toString();
                String ip = ipd.getText().toString();
                opt inputopt = new opt();
                socket = inputopt.sjoin();
                inputjoin inputjoin = new inputjoin(id, pass, ip);

                try {
                    String aa = inputjoin.inJoin(socket);
                    if(aa.contentEquals("suc")) {
                        try{
                            socket.close();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }catch(Exception e){
                            e.printStackTrace();
                        }}
                    else {};
                } catch (IOException e) {}
            }
        }
        );

        can.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                           Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                           startActivity(intent);
                                   }
                               }
            );
}
}
