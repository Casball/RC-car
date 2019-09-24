package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class loginstage extends AppCompatActivity {
    Socket socket;
    Socket isocket;
    int sin;
    String IOTip;
    OutputStream os;
    InetAddress IADD;
    byte[] moved = new byte[5];
    int port = 5000;
 //   MediaController mc = new MediaController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginstage);


        final EditText idd, passd, ipd;
        Button sub, can, up, back, left, right;
        final WebView wview;
        idd = (EditText) findViewById(R.id.idl);
        passd = (EditText) findViewById(R.id.passl);

        sub = (Button) findViewById(R.id.submitl);
        can = (Button) findViewById(R.id.canBtnl);
        up = (Button) findViewById(R.id.up);
        back = (Button) findViewById(R.id.back);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);

        wview = (WebView) this.findViewById(R.id.webView);

        sub.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       sin = 1;
                                       String id = idd.getText().toString();
                                       String pass = passd.getText().toString();
                                       opt OPT = new opt();
                                       socket = OPT.sjoin();
                                       selec se = new selec("login", id, pass);
                                       IOTip = se.transip(socket);
                                       opt OPT2 = new opt();
                                       try {
                                           isocket = OPT2.sjoin(IOTip);
                                           os = isocket.getOutputStream();
                                       } catch (IOException e1) {
                                       }
                                       wview.setPadding(0,0,0,0);
                                       //webView.setInitialScale(100);
                                       wview.getSettings().setBuiltInZoomControls(false);
                                       wview.getSettings().setJavaScriptEnabled(true);
                                       wview.getSettings().setLoadWithOverviewMode(true);
                                       wview.getSettings().setUseWideViewPort(true);
                                       try {
                                           Thread.sleep(200);
                                       } catch(Exception e) { }
                                       String url ="http://"+IOTip+":8080/javascript_simple.html";
                                       wview.loadUrl(url);
                                   }
                               }
        );

        can.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       try {
                                           if (sin == 1) {
                                               try {
                                                   moved = "f".getBytes();
                                                   os.write(moved);
                                                   os.close();
                                                   socket.close();
                                                   isocket.close();
                                               } catch (IOException e) {
                                               }
                                           }
                                           Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                           startActivity(intent);
                                       } catch (Exception e) {
                                       }
                                   }
                               }
        );
        up.setOnTouchListener(new View.OnTouchListener() {
                                  public boolean onTouch(View v, MotionEvent event) {
                                      moved = "w".getBytes();
                                      switch (event.getAction()) {
                                          case MotionEvent.ACTION_DOWN:
                                              try {
                                                  os.write(moved);
                                                  os.flush();
                                              } catch (Exception e) {
                                              }
                                              break;
                                          case MotionEvent.ACTION_UP:
                                              try {
                                                  moved = "f".getBytes();
                                                  os.write(moved);
                                                  os.flush();
                                              } catch (Exception e) {
                                              }
                                              v.performClick();
                                              break;
                                          default:
                                              break;
                                      }
                                      return true;
                                  }
                              }
        );

        back.setOnTouchListener(new View.OnTouchListener() {
                                    public boolean onTouch(View v, MotionEvent event) {
                                        moved = "s".getBytes();

                                        switch (event.getAction()) {
                                            case MotionEvent.ACTION_DOWN:
                                                try {
                                                    os.write(moved);
                                                    os.flush();
                                                } catch (Exception e) {
                                                }
                                                break;
                                            case MotionEvent.ACTION_UP:
                                                try {
                                                    moved = "f".getBytes();
                                                    os.write(moved);
                                                    os.flush();
                                                } catch (Exception e) {
                                                }
                                                v.performClick();
                                                break;
                                            default:
                                                break;
                                        }
                                        return true;
                                    }
                                }
        );

        left.setOnTouchListener(new View.OnTouchListener() {
                                    public boolean onTouch(View v, MotionEvent event) {
                                        moved = "a".getBytes();

                                        switch (event.getAction()) {
                                            case MotionEvent.ACTION_DOWN:
                                                try {
                                                    os.write(moved);
                                                    os.flush();
                                                } catch (Exception e) {
                                                }
                                                break;
                                            case MotionEvent.ACTION_UP:
                                                try {
                                                    moved = "f".getBytes();
                                                    os.write(moved);
                                                    os.flush();
                                                } catch (Exception e) {
                                                }
                                                v.performClick();
                                                break;
                                            default:
                                                break;
                                        }
                                        return true;
                                    }
                                }
        );

        right.setOnTouchListener(new View.OnTouchListener() {
                                     public boolean onTouch(View v, MotionEvent event) {
                                         moved = "d".getBytes();

                                         switch (event.getAction()) {
                                             case MotionEvent.ACTION_DOWN:
                                                 try {
                                                     os.write(moved);
                                                     os.flush();
                                                 } catch (Exception e) {
                                                 }
                                                 break;
                                             case MotionEvent.ACTION_UP:
                                                 try {
                                                     moved = "f".getBytes();
                                                     os.write(moved);
                                                     os.flush();
                                                 } catch (Exception e) {
                                                 }
                                                 v.performClick();
                                                 break;
                                             default:
                                                 break;
                                         }
                                         return true;
                                     }
                                 }
        );
    }
}
