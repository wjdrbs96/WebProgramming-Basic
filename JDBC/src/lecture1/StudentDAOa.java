package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

// try ~ with ~ resource 문법을 사용하지 않으니 코드가 더 길고 가독성이 좋지 않다. 

public class StudentDAOa {
	public static List<Student> findAll() throws SQLException, NamingException {
		String sql = "SELECT s.*, d.departmentName " +
                "FROM student s LEFT JOIN department d ON s.departmentId = d.id";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<>();
		
		try {
			connection = DB.getConnection("student1");
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setStudentNumber(resultSet.getString("studentNumber"));
                student.setName(resultSet.getString("name"));
                student.setDepartmentId(resultSet.getInt("departmentId"));
                student.setYear(resultSet.getInt("year"));
                student.setDepartmentName(resultSet.getString("departmentName"));
                list.add(student);

			}
		} finally {
			if (connection != null) connection.close();
			if (statement != null) statement.close();
			if (resultSet != null) resultSet.close();
		}
		
		return list;

	}

}
