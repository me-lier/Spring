package com.Srinivas;

import java.util.Scanner;

public class Operations_CRUD {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        dao.connection();
        
        boolean flag=true;
        Student s = new Student();
        while(flag) {
        	System.out.print("Choose\n 0 for -> EXIT; \n 1 for -> To show the Entire Table Data; \n 2 for -> To find username of userid; \n 3 for -> To find userid of username; \n 4 for -> To Insert a row into Table; \n 5 for -> To Delete a row into table;\nEnter:->");
        	
        		int n = sc.nextInt();
        		switch(n) {
        			case 0:
        				flag = false;
        				System.out.println("\nExiting..... \n BYE..");
        				break;
        			case 1:
        				dao.showtable();
        				break;
        			case 2:
        				System.out.print("\nEnter User ID to retrieve the Username:-> ");
        				int x = sc.nextInt();
        				s = dao.retrieve_name(x);
        				System.out.println("\n\n\n"+s.username+"\n\n\n");
        				break;
        			case 3:
        				System.out.print("\nEnter Username to retrieve the User ID:-> ");
        				String name = sc.next();
        				s = dao.retrieve_id(name);
        				System.out.println("\n\n\n"+s.user_id+"\n\n\n");
        				break;
        			case 4:
        				System.out.print("\nEnter The Username to Insert:-> ");
        				String username = sc.next();
        				System.out.print("\nEnter The User Id to Insert:-> ");
        				int userid = sc.nextInt();
        				s.user_id = userid;
        				s.username = username;
        				dao.Insertion(s);
        				break;
        			case 5:
        				System.out.println("By Username Choose 1 or UserID Choose 2");
        				int x1 =sc.nextInt();
        				String username1 = "";
        				int userid1 = 0;
        				if(x1==1) {
        					System.out.print("\nEnter The Username to Delete:-> ");
        					username1 = sc.next();
        				}else if(x1==2) {
        					System.out.print("\nEnter The User Id to Delete:-> ");
        					userid1 = sc.nextInt();
        				}
        				s.user_id = userid1;
        				s.username = username1;
        				dao.Deletion(s);
        				break;
        			default:
        				System.out.println("Try Again...\n Enter only between (0 to 5) :- > \n");
        		}
        }
        try {
        		dao.con.close();
        		System.out.println("Connection Closed");
        }catch (Exception ex) {
        		System.out.println(ex);
        }
        sc.close();
        return;
    }
}