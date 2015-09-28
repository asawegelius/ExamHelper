/**
 * 
 */
package dao;

import java.io.Serializable;
import java.util.*;
import java.lang.reflect.*;
import java.sql.*;

/**
 * @author Mariana
 *
 */
@SuppressWarnings("hiding")
public abstract class ExamHelperDao<T extends Serializable, Long> implements IExamHelperDao<T, Long> {

	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public ExamHelperDao(){
		type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public abstract T findByID(Long id);
	/*	String table = type.getSimpleName();
		//I should have a variable which stores the name of the ID from each table
		String query = "SELECT * from " + table + " WHERE pk_qid = " + id;
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				while(rs.next()) {
					//price = rs.getDouble("cottagePrice");
				}
			}
			s.close();
		}
		catch (SQLException e) {
	            System.err.println("in findByID " + e.getMessage());
	        } */
		// TODO Auto-generated method stub


	public abstract T findByName(String name) ;

	public abstract ArrayList<T> getAll(); 

	public int count() {
		int i=0;
		String table = type.getSimpleName();
		String query = "SELECT * from `examhelper`.`"+ table+"`" ;
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				while(rs.next()) {
					i++;
				}
			}
			
			s.close();
		}
		catch (SQLException e) {
	            System.err.println("in count " + e.getMessage());
	        }
		return i;
			// TODO Auto-generated method stub
	}

	public abstract void save(T entity); 

	public abstract void update(T entity); 

	public abstract void saveOrUpdate(T entity); 

	public abstract void delete(T entity); 

	public abstract void delete(Long id); 


}
