package iotserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logInc {
	String name;
	String pass;
	String ip_num2;
	String rej="fail";
	String name2;
	String passwd2;
	private static String driver = "org.mariadb.jdbc.Driver";
	private static String url = "jdbc:mariadb://127.0.0.1:3306/iot";
	private static String username = "root";
	private static String password = "system";
	srtn ssr = new srtn();
	Connection con;
	public logInc (String name, String pass) {
		this.name = name;
		this.pass = ssr.sha256(pass);
	}
	
	public logInc (String name, String pass, String ip_num2) {
		this.name = name;
		this.pass = ssr.sha256(pass);
		this.ip_num2 = ip_num2;
	}
	
	public String submit (int a) {
		System.out.println("submit start");
		if( a == 0) { //login
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url,username,password);
				String sql = "SELECT * FROM iot WHERE ID = ?";
				java.sql.PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				while(rs.next() ) {
					name2 = rs.getString("ID");
					passwd2 = rs.getString("passwd");
					ip_num2 = rs.getString("ip_num");
				}
				if (name2.contentEquals(name) && passwd2.contentEquals(pass)) {
					stmt.close();
					rs.close();
					return ip_num2;
				}
				else {
					stmt.close();
					rs.close();
					return rej;
				}} catch(ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}}
		else { //join
			try {
				System.out.println("db join start");
				System.out.println(name);
				Class.forName(driver);
				con = DriverManager.getConnection(url,username,password);
				String sql = "INSERT INTO iot(ID, passwd, ip_num) VALUES(?,?,?)";
				java.sql.PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2,pass);
				stmt.setString(3,ip_num2);
				stmt.executeUpdate();
				System.out.println("join finish");
				stmt.close();
				return ip_num2;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return rej;
	} 
}
