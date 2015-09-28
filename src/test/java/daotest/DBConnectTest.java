package daotest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

/**
 * @author Mariana
 *
 */

public class DBConnectTest extends TestCase {
	public void testConnect(){

		String dbUrl = "jdbc:mysql://localhost/examhelper";
	    String dbClass = "com.mysql.jdbc.Driver";
	    String query = "SELECT * from `examhelper`.`question`";
	    String username = "ExamUser";
	    String password = "ExamHelperPass";
	    try {

	        Class.forName(dbClass);
	        Connection connection = DriverManager.getConnection(dbUrl, username, password);
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) {
	        String resultName = resultSet.getString(1);
	        System.out.println("Result : " + resultName);
	        }
	        connection.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    }

}