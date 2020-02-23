package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO1 {

    public static List<Department> findAll() throws Exception {
        String sql = "SELECT * FROM department";
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
             List<Department> list = new ArrayList<Department>();
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("id"));
                department.setDepartmentName(resultSet.getString("departmentName"));
                list.add(department);
            }
            return list;
        }
    }

    public static void insert(Department department) throws Exception {

        // query ¿€º∫
    	String sql = "insert department(departmentName) " +
    				 "values(?)";
   
    
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, department.getDepartmentName());
            statement.executeUpdate();
        }
    }

}

