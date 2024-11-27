//package com.Srinivas;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.SQLException;
//
//class Student {
//    private String username;
//    private int user_id;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }
//}
//
//public class Read {
//    Connection con = null;
//
//    public void connection() {
//        try {
//            String url = "jdbc:mysql://localhost:3306/Srinivas";
//            String u = "root";
//            String p = "12341234";
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection(url, u, p);
//            System.out.println("Successfully Established Connection");
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//            System.out.println("Failed to Establish Connection");
//        }
//    }
//
//    public void showTable() {
//        try {
//            String query = "SELECT * FROM Student";
//            Statement st = con.createStatement();
//            ResultSet res = st.executeQuery(query);
//            
//            System.out.println("\n\n\nStudent Data:");
//            System.out.println(" | ID | Username | ");
//            System.out.println("-------------------");
//
//            while (res.next()) {
//                System.out.println(" | " + res.getInt(1) + " | " + res.getString(2) + " | ");
//            }
//
//            System.out.println("\n\n\n");
//
//            res.close();
//            st.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void closeConnection() {
//        try {
//            if (con != null && !con.isClosed()) {
//                con.close();
//                System.out.println("Connection Closed");
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public static void main(String[] args) {
//        Read readObj = new Read();
//        readObj.connection();
//        readObj.showTable();
//        readObj.closeConnection();
//    }
//}