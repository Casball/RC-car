package com.example.myapplication;

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.net.Socket;

public class selec {
    String sel;
    String name;
    String pass;
    String ipd;
    Socket socket;

    public selec(String sel, String name, String pass) {
        this.sel=sel;
        this.name=name;
        this.pass=pass;
    }
    public selec(String sel, String name, String pass, String ipd) {
        this.sel=sel;
        this.name=name;
        this.pass=pass;
        this.ipd=ipd;
    }

    public String transip(Socket socket) {
        String re="err";
        try {
            byte[] bytes = null;
            String message = null;
            InputStream is = socket.getInputStream();
            OutputStream req = socket.getOutputStream();

            if(sel.contentEquals("login")) {

                bytes = new byte[10];
                bytes = sel.getBytes();
                req.write(bytes);
                req.flush();
                is.read();

                bytes = new byte[30];
                bytes = name.getBytes();
                req.write(bytes);
                req.flush();
                is.read();

                bytes = new byte[32];
                bytes = pass.getBytes();
                req.write(bytes);
                req.flush();
                is.read();
                bytes = new byte[30];
                int readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                re = message;
                is.close(); req.close();
                return re;

            }
            else {
                bytes = new byte[10];
                bytes = sel.getBytes();
                req.write(bytes);
                req.flush();
                is.read();

                bytes = new byte[30];
                bytes = name.getBytes();
                req.write(bytes);
                req.flush();
                is.read();

                bytes = new byte[32];
                bytes = pass.getBytes();
                req.write(bytes);
                req.flush();
                is.read();

                bytes = new byte[30];
                bytes = ipd.getBytes();
                req.write(bytes);
                req.flush();
                is.read();

                re = "com";
                is.close(); req.close(); socket.close();
                return re;

            }


        } catch(IOException e) {}
        if(!socket.isClosed()) {
            try {
                socket.close();
            } catch(Exception e) {}
        }
        return re;
    }
}
