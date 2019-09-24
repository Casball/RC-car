package iotserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class selectLogin {
	Socket socket;
	String named = null;
	String passdd = null;
	InputStream is = null;
	OutputStream req = null;
	byte[] bytes;
	String re;
	
	public selectLogin (Socket socket) {
		this.socket = socket;
	}
	
	public void inLogin() {
		try {
			is = socket.getInputStream();
			req = socket.getOutputStream();
			bytes = new byte[30];
			is.read(bytes);
			named = new String(bytes, 0, bytes.length, "UTF-8");
			req.write(1);
			req.flush();
			System.out.println("loginstart");
			bytes = new byte[32];
			is.read(bytes);
			passdd = new String(bytes, 0, bytes.length, "UTF-8");
			req.write(1);
			req.flush();
			
			logInc logi = new logInc(named, passdd);
			re = logi.submit(0);
			if(re.contentEquals("fail")) {
				System.out.println(re);
				inLogin();
			}
			else {
				re = re.trim();
				System.out.println(re);
				bytes = new byte[30];
				bytes = re.getBytes("UTF-8");
				req.write(bytes);
				req.flush();
				req.close(); is.close();
				socket.close();
			}
		} catch (IOException e) {}
	}
}
