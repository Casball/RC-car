package iotserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class selctJoin {
	Socket socket;
	String named = null;
	String passdd = null;
	String ipd = null;
	InputStream is = null;
	OutputStream req = null;
	byte[] bytes;
	String re;
	
	public selctJoin(Socket socket) {
		this.socket = socket;
	}
	
	public void inJoin () {
		try {
			is = socket.getInputStream();
			req = socket.getOutputStream();
			bytes = new byte[30];
			is.read(bytes);
			named = new String(bytes, 0, bytes.length, "UTF-8");
			req.write(1);
			req.flush();
		
			byte[] bytes2 = new byte[32];
			is.read(bytes2);
			passdd = new String(bytes2, 0, bytes2.length, "UTF-8");
			req.write(1);
			req.flush();
		
			byte[] bytes3 = new byte[30];
			is.read(bytes3);
			ipd = new String(bytes3, 0, bytes3.length, "UTF-8");
			req.write(1);
			req.flush();
			
			logInc logi = new logInc(named, passdd, ipd);
			System.out.println("trans serverio suc1");
			re = logi.submit(1);
			System.out.println("trans serverio suc");
			is.close(); req.close();
			socket.close();
		} catch (IOException e) {}
	}
}
