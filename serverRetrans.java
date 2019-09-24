package iotserver;

import java.io.IOException;


public class serverRetrans {
	String userip;
	String co = "D:\\gstreamer\\1.0\\x86_64\\bin\\camrecive2.bat";
	public serverRetrans() {}
	
	public void retrans() {
	//		Process p = Runtime.getRuntime().exec("C:\\Program Files\Java\jdk1.8.0_211\bin\camrecive.bat")
			try {
				System.out.println("servvv");
				Runtime.getRuntime().exec(co);
			} catch (IOException e) {}

		
	}
}
