/**
 * 
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import model.Chapter;
import model.Question;

/**
 * @author Mariana
 *
 */
public class QuestionDao extends ExamHelperDao<Question, Long> implements
		IQuestionDao<Question, Long> {

	public Question findByID(Long id) {
		Question que = new Question();
		String query = "SELECT * from `examhelper`.`question` WHERE `question`.`pk_qid` = '"
				+ id + "'";
		Connection con = DBConnect.getConnection();
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if (rs != null) {
				while (rs.next()) {
					long ch_nb = rs.getLong("fk_chaid_answer");
					que.setChapter(Chapter.values()[(int) ch_nb]);
					que.setDescription(rs.getString("description"));
					que.setName(rs.getString("name"));
					que.setQuestionId(rs.getLong("pk_qid"));
				}
			}
			s.close();
		} catch (SQLException e) {
			System.err.println("in findByID " + e.getMessage());

		}
		return que;
	}

	public Question findByName(String name) {
		Question que = new Question();
		String query = "SELECT * from `examhelper`.`question` WHERE name = '"
				+ name + "'";
		Connection con = DBConnect.getConnection();
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if (rs != null) {
				while (rs.next()) {
					long ch_nb = rs.getLong("fk_chaid_answer");
					que.setChapter(Chapter.values()[(int) ch_nb]);
					que.setDescription(rs.getString("description"));
					que.setName(rs.getString("name"));
					que.setQuestionId(rs.getLong("pk_qid"));
				}
			}
			s.close();
		} catch (SQLException e) {
			System.err.println("in findByName " + e.getMessage());

		}
		return que;
	}

	public void save(Question entity) {
		String query = "INSERT INTO `examhelper`.`question` (`pk_qid`, `name`, `description`, `fk_chaid_answer`) VALUES ("
				+ entity.getQuestionId()
				+ ", '"
				+ entity.getName()
				+ "' , '"
				+ entity.getDescription() + "', " + entity.getChapter() + ")";
		System.out.println(query);
		Connection con = DBConnect.getConnection();
		try {
			Statement s = con.createStatement();
			s.execute(query);

			s.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void update(Question entity) {
		String query = "UPDATE `examhelper`.`question` SET `pk_qid`= "
				+ entity.getQuestionId() + " , `name`='" + entity.getName()
				+ "', `description`='" + entity.getDescription()
				+ "', `fk_chaid_answer`" + entity.getChapter()
				+ " WHERE `pk_qid` = " + entity.getQuestionId() + ";";
		System.out.println(query);
		Connection con = DBConnect.getConnection();
		try {
			Statement s = con.createStatement();
			s.execute(query);

			s.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void saveOrUpdate(Question entity) {
		// if the entity is already in the database update it
		String query = "SELECT * from `examhelper`.`question` WHERE `pk_qid`= '"
				+ entity.getQuestionId() + "'";
		Connection con = DBConnect.getConnection();
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if (rs != null) {
				String query1 = "UPDATE `examhelper`.`question` SET `pk_qid`= "
						+ entity.getQuestionId() + " , `name`='"
						+ entity.getName() + "', `description`='"
						+ entity.getDescription() + "', `fk_chaid_answer`"
						+ entity.getChapter() + " WHERE `pk_qid` = "
						+ entity.getQuestionId() + ";";
				System.out.println(query1);
				try {
					s.execute(query1);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			} else {
				String query2 = "INSERT INTO `examhelper`.`question` (`pk_qid`, `name`, `description`, `fk_chaid_answer`) VALUES ("
						+ entity.getQuestionId()
						+ ", '"
						+ entity.getName()
						+ "' , '"
						+ entity.getDescription()
						+ "', "
						+ entity.getChapter() + ")";
				System.out.println(query2);
				try {
					s.execute(query2);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
			s.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void delete(Question entity) {
		String query = "DELETE FROM `examhelper`.`question`	WHERE `pk_qid`= "
				+ entity.getQuestionId() + " ;";
		System.out.println(query);
		Connection con = DBConnect.getConnection();
		try {
			Statement s = con.createStatement();
			s.execute(query);

			s.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public void delete(Long id) {
		String query = "DELETE FROM `examhelper`.`question`	WHERE `pk_qid`= "
				+ id + " ;";
		System.out.println(query);
		Connection con = DBConnect.getConnection();
		try {
			Statement s = con.createStatement();
			s.execute(query);

			s.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public Question[] getRandomPair(long i) {
		ArrayList<Question> allQuestions = getAll();
		Question[] pair = new Question[2];
		Random random = new Random();
		int first = random.nextInt(allQuestions.size());
		int seccond = random.nextInt(allQuestions.size());
		while (seccond == first) {
			seccond = random.nextInt(allQuestions.size());
		}
		pair[0] = allQuestions.get(first);
		pair[1] = allQuestions.get(seccond);
		return pair;
	}

	@Override
	public ArrayList<Question> getAll() {
		ArrayList<Question> allQuestions = new ArrayList<Question>();
		String query = "SELECT * from `examhelper`.`question`";
		Connection con = DBConnect.getConnection();
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			if (!(!rs.isBeforeFirst() && rs.getRow() == 0)) {
				while (rs.next()) {
					allQuestions.add(new Question(rs.getLong("pk_qid"), Chapter
							.values()[(int) rs.getLong("fk_chaid_answer")], rs
							.getString("name"), rs.getString("description")));
				}
			}
			s.close();
		} catch (SQLException e) {
			System.err.println("in getAll " + e.getMessage());
		}
		return allQuestions;
	}

}
