package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Choice;


public class ChoiceDao implements IChoiceDao<Choice, Long> {

	public Choice findByID(Long id) {
		Choice cho = new Choice();
		String query = "SELECT * from question WHERE pk_choid = '" + id + "'";
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
		// TODO Auto-generated method stub
		return null;
	}

	public Choice findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Choice> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void save(Choice entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(Choice entity) {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(Choice entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Choice entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Choice> getChoicesForQuestion(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
