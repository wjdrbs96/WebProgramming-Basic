package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO3 {
	public static List<User> findByName(String name) throws Exception {
		String sql = "SELECT u.*, d.departmentName " + 
				     "FROM User u LEFT JOIN department d ON u.departmentId = d.id " + 
				     "WHERE u.departmentId = ?";
        
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
        		statement.setString(1, name);
        		ResultSet resultSet = statement.executeQuery();
                List<User> list = new ArrayList<User>();
                while (resultSet.next()) {
                    User user1 = new User();
                    user1.setId(resultSet.getInt("id"));
                    user1.setUserid(resultSet.getString("userid"));
                    user1.setName(resultSet.getString("name"));
                    user1.setDepartmentId(resultSet.getInt("departmentId"));
                    list.add(user1);
                }
                return list;
            }
       }

}
