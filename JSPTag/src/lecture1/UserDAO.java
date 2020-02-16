package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public static User createUser(ResultSet resultSet) throws SQLException {
	   User user = new User();
	   user.setId(resultSet.getInt("id"));
	   user.setUserid(resultSet.getString("userid"));
	   user.setPassword(resultSet.getString("password"));
	   user.setName(resultSet.getString("name"));
	   user.setEmail(resultSet.getString("email"));
	   user.setDepartmentId(resultSet.getInt("departmentId"));
	   user.setDepartmentName(resultSet.getString("departmentName"));
       return user;
		
	}

   public static List<User> findAll(int currentPage, int pageSize) throws Exception {

       String sql = "select s.*, d.departmentName " +
       			    "from User s Join department d on s.departmentId = d.id " +
       			    "Limit ?, ?";
       
       try (Connection connection = DB.getConnection("student1");
            PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.setInt(1, (currentPage - 1) * pageSize);
           statement.setInt(2, pageSize);
           try (ResultSet resultSet = statement.executeQuery()) {
               List<User> list = new ArrayList<User>();
               while (resultSet.next()) {
                   User user = createUser(resultSet);
                   list.add(user);
               }
               return list;
           }
       }
   }

   public static int count() throws Exception {
       String sql = "SELECT COUNT(*) FROM User";
       try (Connection connection = DB.getConnection("student1");
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next())
                   return resultSet.getInt(1);
       }
       return 0;
   }
}
