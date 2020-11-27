import bean.User;
import dao.UserDao_Imp;
import jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.*;

public class JDBCUtilsTest {
    @Test
    public void jdbcConnectionTest(){
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from info");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id")); // 根据字段类型获取值
                System.out.print(resultSet.getString("uname"));
                System.out.print(resultSet.getString("upass"));
                System.out.println();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Test
    public void loginTest(){
        UserDao_Imp userDao_imp = new UserDao_Imp();
        User user = new User("admin","admin");
        System.out.println(userDao_imp.login(user));
    }

    @Test
    public void insertTest(){
        UserDao_Imp userDao_imp = new UserDao_Imp();
        User user = new User("金毛毛","jinmaomao");
        System.out.println(userDao_imp.insert(user));
    }

    @Test
    public void deleteTest(){
        UserDao_Imp userDao_imp = new UserDao_Imp();
        String uname = "金毛毛";
        System.out.println(userDao_imp.delete(uname));
    }

    @Test
    public void updateTest(){
        UserDao_Imp userDao_imp = new UserDao_Imp();
        User Testuser = new User("丽丽桑","lilisang", 2);
        User user = new User("金毛毛","jinmaomaonb");
        System.out.println(userDao_imp.update(user, Testuser, Testuser.getType()));
    }

    @Test
    public void selectTest(){
        UserDao_Imp userDao_imp = new UserDao_Imp();
        String uname = "金毛毛";
        System.out.println(userDao_imp.select(uname));
    }
}
