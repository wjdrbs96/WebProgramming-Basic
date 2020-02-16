package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO2 {

	public static Student createStudent(ResultSet resultSet) throws SQLException {
	    Student student = new Student();
       student.setId(resultSet.getInt("id"));
       student.setStudentNumber(resultSet.getString("studentNumber"));
       student.setName(resultSet.getString("name"));
       student.setDepartmentId(resultSet.getInt("departmentId"));
       student.setYear(resultSet.getInt("year"));
       student.setDepartmentName(resultSet.getString("departmentName"));
       return student;
		
	}
	
    public static List<Student> findByName(String name, int currentPage, int pageSize) throws Exception {

    	String sql = "select s.*, d.departmentName " +
    				 "from student s Join department d on s.departmentId = d.id " + 
    				 "where name Like ?" +
    				 "limit ?, ?";

        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
        	    statement.setString(1, name + "%");
        	    statement.setInt(2, (currentPage - 1) * pageSize);
                statement.setInt(3, pageSize);
              
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Student> list = new ArrayList<Student>();
                while (resultSet.next()) {
                	list.add(createStudent(resultSet));
                }
                return list;
            }
        }
    }

    public static int count(String name) throws Exception {

    	String sql = "select count(name) " +
    				 "from student " +
    				 "where name Like ?";
        // query ¿€º∫
        
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next())
                    return resultSet.getInt(1);
            }
        }
        return 0;
    }
}
