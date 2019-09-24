package com.example.myapplication;

import java.io.IOException;
import java.net.Socket;

public class inputjoin {
    String join="join";
    String named=null;
    String pass=null;
    String ip=null;
    String iotip;

    public inputjoin(String named, String pass, String ip) {
        this.named = named;
        this.pass = pass;
        this.ip = ip;
    };

    public String inJoin(Socket socket) throws IOException {
        selec se = new selec(join, named, pass, ip);
        iotip = se.transip(socket);
        if(iotip.contentEquals("com"))
            return "suc";
        return iotip;
    }
}
