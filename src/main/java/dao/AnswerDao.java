package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Answer;

public class AnswerDao implements IAnswerDao<Answer, Long> {

	public Answer findByID(Long id) {
		Answer answ = new Answer();
		/*`answer`.`pk_aid`,
	    `answer`.`fk_qid_answer`,
	    `answer`.`fk_choid_answer`,
	    `answer`.`description`*/
		String query = "SELECT * from `examhelper`.`answer` WHERE pk_aid = '" + id + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				while(rs.next()) {
					long ch_nb = rs.getLong("fk_choid_answer");
					answ.setChoiceId(ch_nb);
					answ.setDescription(rs.getString("description"));
					answ.setQuestionId(rs.getLong("fk_qid_choice"));
					long ch_nb1 = rs.getLong("fk_qid_answer");
					answ.setAnswerId(ch_nb1);
				}
			}
				s.close();
			}
			catch (SQLException e) {
		            System.err.println("in findByID " + e.getMessage());
				
				}	
		
		// TODO Auto-generated method stub
		return null;
	}

	public Answer findByName(String name) {
		Answer answ = new Answer();
		String query = "SELECT * from `examhelper`.`answer` WHERE description = '" + name + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				while(rs.next()) {
					long ch_nb = rs.getLong("fk_choid_answer");
					answ.setChoiceId(ch_nb);
					answ.setDescription(rs.getString("description"));
					answ.setQuestionId(rs.getLong("fk_qid_choice"));
					long ch_nb1 = rs.getLong("fk_qid_answer");
					answ.setAnswerId(ch_nb1);
				}
			}
				s.close();
			}
			catch (SQLException e) {
		            System.err.println("in findByID " + e.getMessage());
				
				}	
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Answer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void save(Answer entity) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO `examhelper`.`answer` (`pk_aid`, `fk_qid_answer`, `fk_choid_answer`, `description`) VALUES (" +
				entity.getAnswerId() + ", "+entity.getQuestionId() +", "+ entity.getChoiceId()+"'" + entity.getDescription() + "')";
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

	public void update(Answer entity) {
		String query = "UPDATE `examhelper`.`answer` SET `pk_aid` = " +entity.getAnswerId()+" , `description`='" + entity.getDescription() + "', " + 
				 "', `fk_qid_answer` =" + entity.getQuestionId()+",`fk_choid_answer` ="+ entity.getChoiceId()+ " WHERE `pk_aid` = " +entity.getAnswerId() + ";";
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
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(Answer entity) {
		String query = "SELECT * from `examhelper`.`answer` WHERE `pk_aid` = '" + entity.getAnswerId() + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				String query1 = "UPDATE `examhelper`.`answer` SET `pk_aid` = " +entity.getAnswerId()+" , `description`='" + entity.getDescription() + "', " + 
						 "', `fk_qid_answer` =" + entity.getQuestionId()+",`fk_choid_answer` ="+ entity.getChoiceId()+ " WHERE `pk_aid` = " +entity.getAnswerId() + ";";
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
				String query2 = "INSERT INTO `examhelper`.`answer` (`pk_aid`, `fk_qid_answer`, `fk_choid_answer`, `description`) VALUES (" +
						entity.getAnswerId() + ", "+entity.getQuestionId() +", "+ entity.getChoiceId()+"'" + entity.getDescription() + "')";
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
		// TODO Auto-generated method stub
		
	}

	public void delete(Answer entity) {
		String query = "DELETE FROM `examhelper`.`answer` WHERE `pk_qid`= " +entity.getAnswerId()+" ;";
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
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) {
		String query = "DELETE FROM `examhelper`.`answer` WHERE `pk_qid`= " +id+" ;";
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
		// TODO Auto-generated method stub
		
	}

	public Answer answerForQuestion(Long questionID) {
		// TODO Auto-generated method stub
		return null;
	}


}
