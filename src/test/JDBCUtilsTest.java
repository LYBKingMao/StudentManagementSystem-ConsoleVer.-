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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
