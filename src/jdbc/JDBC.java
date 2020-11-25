package jdbc;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) {
        // 加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");

        // 连接数据库
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root",
                    "root");

        // 使用PreparedStatement防止SQL注入
            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "select * from info");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id")); // 根据字段类型获取值
                System.out.print(resultSet.getString("uname"));
                System.out.print(resultSet.getString("upass"));
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        } catch (SQLException se){
            se.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}
