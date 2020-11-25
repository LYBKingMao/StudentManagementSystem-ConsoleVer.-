package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 静态代码块
    static {
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("" +
                "db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            Class.forName(driver);
            System.out.println("驱动加载成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cfe){
            cfe.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            System.out.println("数据库连接成功");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            System.out.println("数据流连接失败");
            throwables.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if(statement != null){  // 如果抛出异常先检查此处
                statement.close();
                resultSet = null;
                statement = null;
            }
            if(resultSet != null){
                resultSet.close();
                resultSet = null;
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
