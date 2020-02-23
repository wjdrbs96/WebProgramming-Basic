package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

public class ProfessorDAO {
	
	private static Professor getStudentFrom(ResultSet resultSet) throws SQLException {
		Professor professor = new Professor();
		professor.setId(resultSet.getInt("id"));
		professor.setProfessorName(resultSet.getString("professorName"));
		professor.setDeparmentId(resultSet.getInt("departmentId"));
		
		return professor;
	}
	
	public static void insert(Professor professor) throws SQLException, NamingException {
		String sql = "insert professor(id, professorName, departmentId) " + 
					 "values(?, ?, ?)";
		try (Connection connection = DB.getConnection("student1");
			PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, professor.getId());
			statement.setString(2, professor.getProfessorName());
			statement.setInt(3, professor.getDeparmentId());
			statement.executeUpdate();
			
			
		}
	}
	
	public static List<Professor> findAll() throws SQLException, NamingException {
		String sql = "select * " +
					 "from professor";
		
		try (Connection connection = DB.getConnection("student1");
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery()) {
			List<Professor> list = new ArrayList<>();
			
			while(resultSet.next()) {
				list.add(getStudentFrom(resultSet));
			}
			
			return list;
		}
				
	}

}
