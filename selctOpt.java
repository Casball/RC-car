package iotserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class selctOpt {
	byte[] bytes = null;
	String message = null;
	Socket socket;
	InputStream is = null;
	
	public selctOpt (Socket socket) {
		this.socket = socket;
	}
	
	public void submitLog () {
		try {
			is = socket.getInputStream();
			OutputStream req = socket.getOutputStream();
			
				bytes = new byte[10];
				int len = is.read(bytes);
				message = new String(bytes, 0, len, "UTF-8");
				req.write(1);
				req.flush();
				System.out.println("optstart");
				if(message.contentEquals("join")) {
					selctJoin sjoin = new selctJoin(socket);
					sjoin.inJoin();
				}
				
				else if(message.contentEquals("login")) {
					selectLogin slogin = new selectLogin(socket);
					slogin.inLogin();
				}
		} catch (IOException e) {}
	}
}
