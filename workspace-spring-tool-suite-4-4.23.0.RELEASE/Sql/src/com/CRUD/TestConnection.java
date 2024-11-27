package com.CRUD;

import java.sql.*;

public class TestConnection {
	public static void main(String[] args)throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/Srinivas";
		String u = "root";
		String p = "12341234";
		String q = "SELECT * FROM Student";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, u, p);
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(q);
		
		while(rs.next()){
			String res = rs.getInt(1)+" "+rs.getString(2);
			System.out.println(res);
		}
		
		st.close();
		con.close();
	}
}