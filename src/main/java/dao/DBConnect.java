/**
 * 
 */
package dao;

import java.sql.*;

/**
 * @author Mariana
 *
 */
public class DBConnect {
private static Connection con = null;
	
	private DBConnect(){		
	}
	public static Connection getConnection(){		
		//If instance has not been created yet, create it
		if(DBConnect.con == null){
			initConnection();
		}
		return DBConnect.con;
	}
	private static void initConnection(){			
		try{		
			Class.forName("com.mysql.jdbc.Driver");		
			
			String url = "jdbc:mysql://localhost/examhelper";
			String user = "ExamUser";
			String pw = "ExamHelperPass";
			//I have used fiction username and password today, maybe tomorrow we can make to be the same on each computer
			DBConnect.con = DriverManager.getConnection(url, user, pw);		
		}
		catch (ClassNotFoundException e){		
			System.out.println("class not found " + e.getMessage());
			System.exit(0);
		}
		catch (SQLException e){			
			System.out.println("sql exception " + e.getMessage());
			System.exit(0);
		}
		catch (Exception e){	
			System.out.println("exception " +e.getMessage());
		}		
	}
}
