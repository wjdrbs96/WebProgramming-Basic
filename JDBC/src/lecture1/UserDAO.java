package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public static List<User> findUser() throws Exception {
		String sql = "select u.userid, u.name, u.email, d.departmentName, u.userType " + 
					 "From student1.user u " +
					 "Join student1.department d on d.departmentName = '소프트웨어공학과'";
		try (Connection connection = DB.getConnection("student1");
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
				List<User> list1 = new ArrayList<>();
				
				while (resultSet.next()) {
					User user = new User();
					user.setUserid(resultSet.getString("userid"));
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setDepartmentName(resultSet.getString("departmentName"));
					user.setUserType(resultSet.getString("userType"));
					list1.add(user);
					
				}
				return list1;
				
		}
	}

}
