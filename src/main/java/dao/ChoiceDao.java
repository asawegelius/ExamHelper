package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Choice;


public class ChoiceDao extends ExamHelperDao<Choice, Long> implements IChoiceDao<Choice, Long> {

	public Choice findByID(Long id) {
		Choice cho = new Choice();
		String query = "SELECT * from `examhelper`.`choice` WHERE `pk_choid` = '" + id + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				while(rs.next()) {
					long ch_nb = rs.getLong("fk_qid_choid");
					cho.setChoiceId(ch_nb);
					cho.setDescription(rs.getString("description"));
					cho.setQuestionId(rs.getLong("fk_qid_choice"));
				}
			}
				s.close();
			}
			catch (SQLException e) {
		            System.err.println("in findByID " + e.getMessage());
				
				}	
		return cho;
	}

	public Choice findByName(String name) {
		Choice cho = new Choice();
		String query = "SELECT * from `examhelper`.`choice` WHERE description = '" + name + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				while(rs.next()) {
					long ch_nb = rs.getLong("fk_qid_choid");
					cho.setChoiceId(ch_nb);
					cho.setDescription(rs.getString("description"));
					cho.setQuestionId(rs.getLong("fk_qid_choice"));
				}
			}
				s.close();
			}
			catch (SQLException e) {
		            System.err.println("in findByName " + e.getMessage());
				
				}	
		return cho;
	}

	public ArrayList<Choice> getAll() {
		ArrayList<Choice> allChoices = new  ArrayList<Choice>();
		String query = "SELECT * from `examhelper`.`choice`" ;
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(!(!rs.isBeforeFirst() && rs.getRow() == 0)){
				while(rs.next()) {
					allChoices.add(new Choice(rs.getLong("pk_choid"), rs.getLong("fk_qid_choice"), rs.getString("description")));
				}
			}
			s.close();
		}
		catch (SQLException e) {
	            System.err.println("in getAll " + e.getMessage());
	        }
		return allChoices ;
	}

	public void save(Choice entity) {
		String query = "INSERT INTO `examhelper`.`choice` (`pk_choid`, `description`, `fk_qid_choice`) VALUES (" +
				entity.getChoiceId() + ", '" + entity.getDescription() + "', " + entity.getQuestionId()+ ")";
		System.out.println(query);
		Connection con = DBConnect.getConnection();	
		try{
			Statement s = con.createStatement();
			s.execute(query);
			
			s.close();
		}
		catch (SQLException e) {
            System.err.println(e.getMessage());
        }		
	}

	public void update(Choice entity) {
		String query = "UPDATE `examhelper`.`choice` SET `pk_choid` = " +entity.getChoiceId()+" , `description`='" + entity.getDescription() + "', " + 
				 "', `fk_qid_choice`" + entity.getQuestionId()+ " WHERE `pk_choid` = " +entity.getChoiceId() + ";";
		System.out.println(query);
		Connection con = DBConnect.getConnection();	
		try{
			Statement s = con.createStatement();
			s.execute(query);
			
			s.close();
		}
		catch (SQLException e) {
            System.err.println(e.getMessage());
        }
	}

	public void saveOrUpdate(Choice entity) {
		String query = "SELECT * from `examhelper`.`choice` WHERE `pk_choid` = '" + entity.getChoiceId() + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				String query1 = "UPDATE `examhelper`.`choice` SET `pk_choid` = " +entity.getChoiceId()+" , `description`='" + entity.getDescription() + "', " + 
						 "', `fk_qid_choice`" + entity.getQuestionId()+ " WHERE `pk_choid` = " +entity.getChoiceId() + ";";
				System.out.println(query1);
				try{
					s.execute(query1);
				}
				catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
			else
			{
				String query2 = "INSERT INTO `examhelper`.`choice` (`pk_choid`, `description`, `fk_qid_choice`) VALUES (" +
						entity.getChoiceId() + ", '" + entity.getDescription() + "', " + entity.getQuestionId()+ ")";
				System.out.println(query2);
				try{
					s.execute(query2);
				}
				catch (SQLException e) {
		            System.err.println(e.getMessage());
		        }
			}
			s.close();
		}
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void delete(Choice entity) {
		String query = "DELETE FROM `examhelper`.`choice` WHERE `pk_choid`= " +entity.getChoiceId()+" ;";
		System.out.println(query);
		Connection con = DBConnect.getConnection();	
		try{
			Statement s = con.createStatement();
			s.execute(query);
			
			s.close();
		}
		catch (SQLException e) {
            System.err.println(e.getMessage());
        }
		
	}

	public void delete(Long id) {
		String query = "DELETE FROM `examhelper`.`choice` WHERE `pk_choid`= " +id+" ;";
		System.out.println(query);
		Connection con = DBConnect.getConnection();	
		try{
			Statement s = con.createStatement();
			s.execute(query);
			
			s.close();
		}
		catch (SQLException e) {
            System.err.println(e.getMessage());
        }
		
	}

	public ArrayList<Choice> getChoicesForQuestion(Long id) {
		ArrayList<Choice> choices = new  ArrayList<Choice>();
		String query = "SELECT * from `examhelper`.`choice` WHERE `fk_qid_choice` = " + id ;		
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(!(!rs.isBeforeFirst() && rs.getRow() == 0)){
				while(rs.next()) {
					choices.add(new Choice(rs.getLong("pk_choid"), rs.getLong("fk_qid_choice"), rs.getString("description")));
				}
			}
			s.close();
		}
		catch (SQLException e) {
	            System.err.println("in getAll " + e.getMessage());
	        }
		return choices ;
	}

}
