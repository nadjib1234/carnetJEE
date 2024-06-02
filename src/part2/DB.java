package part2;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DB {
	final static String DB_URL="jdbc:mysql://localhost:3306/msdtp1";
	final static String USER="root";
	final static String PASS="";
	
	public static Connection con()  {
		
        Connection conn = null;

        try {
        	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS );

            System.out.println("You are successfully connected to the PostgreSQL database server.");

        } catch (SQLException e) 

        {

            System.out.println(e.getMessage());

        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            System.out.println(e.getMessage());
		}



        return conn;

    }


}
