package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO4 {
	 public static User findById(int id) throws Exception {
	        String sql = "SELECT u.*, d.departmentName " +
	                     "FROM User u LEFT JOIN department d ON u.departmentId = d.id " +
	                     "WHERE u.id = ?";
	        try (Connection connection = DB.getConnection("student1");
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	             statement.setInt(1, id);
	             
	             try (ResultSet resultSet = statement.executeQuery()) {
	                 if (resultSet.next()) {
	                	 User user1 = new User();
	                     user1.setId(resultSet.getInt("id"));
	                     user1.setUserid(resultSet.getString("userid"));
	                     user1.setName(resultSet.getString("name"));
	                     user1.setDepartmentId(resultSet.getInt("departmentId"));
	                     return user1;
	                 }  
	                 else
	                     return null;
	             }
	         }
	     }

}
