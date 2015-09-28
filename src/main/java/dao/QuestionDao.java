/**
 * 
 */
package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Chapter;
import model.Question;

/**
 * @author Mariana
 *
 */
public class QuestionDao implements IQuestionDao<Question , Long> {

	public Question findByID(Long id) {
		Question que = new Question();
		String query = "SELECT * from `examhelper`.`pk_qid` = '" + id + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				while(rs.next()) {
					long ch_nb = rs.getLong("fk_chaid_answer");
					que.setChapter(Chapter.values()[(int)ch_nb]);
					que.setDescription(rs.getString("description"));
					que.setName(rs.getString("name"));
					que.setQuestionId(rs.getLong("pk_qid"));
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

	public Question findByName(String name) {
		Question que = new Question();
		String query = "SELECT * from `examhelper`.`question` WHERE name = '" + name + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				while(rs.next()) {
					long ch_nb = rs.getLong("fk_chaid_answer");
					que.setChapter(Chapter.values()[(int)ch_nb]);
					que.setDescription(rs.getString("description"));
					que.setName(rs.getString("name"));
					que.setQuestionId(rs.getLong("pk_qid"));
				}
			}
				s.close();
			}
			catch (SQLException e) {
		            System.err.println("in findByName " + e.getMessage());
				
				}
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Question> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void save(Question entity) {
		String query = "INSERT INTO `examhelper`.`question` (`pk_qid`, `name`, `description`, `fk_chaid_answer`) VALUES (" +
				entity.getQuestionId() + ", '" + entity.getName() + "' , '" + entity.getDescription() + "', " + entity.getChapter()+ ")";
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

	public void update(Question entity) {
		String query = "UPDATE `examhelper`.`question` SET `pk_qid`= " +entity.getQuestionId()+" , `name`='" + entity.getName() + "', `description`='" + 
				entity.getDescription() + "', `fk_chaid_answer`" + entity.getChapter()+ " WHERE `pk_qid` = " +entity.getQuestionId() + ";";
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

	public void saveOrUpdate(Question entity) {
		//if the entity is already in the database update it
		String query = "SELECT * from `examhelper`.`question` WHERE `pk_qid`= '" + entity.getQuestionId() + "'";
		Connection con = DBConnect.getConnection();
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if(rs != null){
				String query1 = "UPDATE `examhelper`.`question` SET `pk_qid`= " +entity.getQuestionId()+" , `name`='" + entity.getName() + "', `description`='" + 
				entity.getDescription() + "', `fk_chaid_answer`" + entity.getChapter()+ " WHERE `pk_qid` = " +entity.getQuestionId() + ";";
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
				String query2 = "INSERT INTO `examhelper`.`question` (`pk_qid`, `name`, `description`, `fk_chaid_answer`) VALUES (" +
						entity.getQuestionId() + ", '" + entity.getName() + "' , '" + entity.getDescription() + "', " + entity.getChapter()+ ")";
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

	public void delete(Question entity) {
		// TODO Auto-generated method stub DELETE
		
		String query = "DELETE FROM `examhelper`.`question`	WHERE `pk_qid`= " +entity.getQuestionId()+" ;";
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
		// TODO Auto-generated method stub
		String query = "DELETE FROM `examhelper`.`question`	WHERE `pk_qid`= " +id+" ;";
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

	public Question[] getRandomPair(long i) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
