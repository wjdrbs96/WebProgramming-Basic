package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lecture1.DB;

public class StudentDAO {

    public static List<Student> findAll() throws Exception {
        String sql = "SELECT s.*, d.departmentName " +
                     "FROM student s LEFT JOIN department d ON s.departmentId = d.id";
        try (Connection connection = DB.getConnection("student1");                          // student1�� ã�ƿ´�.
             PreparedStatement statement = connection.prepareStatement(sql);                // PreparedStatement�� sql�� �����Ų��.
             ResultSet resultSet = statement.executeQuery()) {                              // ResultSet�� sql�� ����� ���̺� ���·� �����Ѵ�. 
             List<Student> list = new ArrayList<Student>();
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
            return list;
        }
    }
}