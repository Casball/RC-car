package iotserver;

import java.security.*;

public class srtn {

	public String sha256 (String msg) {
		//String sRtn = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(msg.getBytes());
			byte dataa[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<dataa.length;i++) {
				sb.append(Integer.toString((dataa[i] & 0xff) + 0x100, 16).substring(1));
			}
			StringBuffer hexString = new StringBuffer();
			for(int i=0;i<dataa.length;i++) {
				String hex = Integer.toHexString(0xff & dataa[i]);
				if (hex.length()==1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
			//sRtn = String.format("%064x", new java.math.BigInteger(1, md.digest()));
		} catch (Exception e) {
			//sRtn="";
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
