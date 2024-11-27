package com.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    Connection con = null;

    public void connection() {
        try {
            String url = "jdbc:mysql://localhost:3306/Srinivas";
            String u = "root";
            String p = "12341234";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, u, p);
            System.out.println("Succesfully Builded Connection");

        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Failed to Build Connection");
        }
    }

    public Student retrieve_name(int user_id) {
        try {
            Student s = new Student();
            s.user_id = user_id;
            String query = "SELECT username FROM Student WHERE user_id = ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, s.user_id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                s.username = res.getString("username");
            } else {
                return null;
            }

            return s;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Student retrieve_id(String username) {
        try {
            Student s = new Student();
            s.username = username;
            String query = "SELECT user_id FROM Student WHERE username = ?";

            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, s.username);
            ResultSet res = st.executeQuery();

            if (res.next()) {
                s.user_id = res.getInt("user_id");
            } else {
                return null;
            }

            return s;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public void Insertion(Student s) {
    	try {
    		
    		String query = "INSERT INTO Student VALUES (?,?)";
    		
    		PreparedStatement pst = con.prepareStatement(query);
    		pst.setInt(1, s.user_id);
    		pst.setString(2, s.username);
    		
    		pst.executeUpdate();
    		
    		System.out.println("Successfuly Inserted ");
    		
    	} catch(Exception ex) {
    		System.out.println(ex);
    	}
    }
    
    public void Deletion(Student s) {
    	try {
    		String query = "DELETE FROM Student WHERE (user_id = ? or username = ?)";
    		PreparedStatement pst = con.prepareStatement(query);
    		pst.setInt(1, s.user_id);
    		pst.setString(2, s.username);
    		
    		pst.executeUpdate();
    		
    		System.out.println("Successfully Deleted One row");
    	} catch(Exception ex) {
    		System.out.println(ex);
    	}
    }
    
    public void showtable() {
    	try {
    		String query = "SELECT * FROM Student";
    		Statement st = con.createStatement();
    		ResultSet res = st.executeQuery(query);
    		
    		System.out.println("\n\n\n");
    		while(res.next()) {
    			System.out.println(" | " + res.getInt(1) + " | " + res.getString(2) + " | ");
    		}
    		System.out.println("\n\n\n");
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }
}