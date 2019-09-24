package com.example.myapplication;

import android.os.StrictMode;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class opt {
    Socket socket=new Socket();
    public opt() { };
    public Socket sjoin() {
        try {
            SocketAddress sock = new InetSocketAddress("192.168.0.14", 5000);
            socket.connect(sock, 3000);

        } catch (IOException e) {} // 소켓이상
        return socket;
    }

    public Socket sjoin(String IOTip) {
        try {
            SocketAddress sock = new InetSocketAddress(IOTip, 5001);
            socket.connect(sock, 3000);
        } catch (IOException e) {} // 소켓이상
        return socket;
    }
}
