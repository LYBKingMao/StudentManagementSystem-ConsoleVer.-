package dao;

import bean.User;
import jdbc.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao_Imp implements UserDao{
    //TODO: 数据库无限自增，需要实现手动读取id和分配id

    @Override
    public int login(User user) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // prepared statement
            preparedStatement = connection.prepareStatement("select type " +
                    "from user where uname = ? and upass = ?");
            preparedStatement.setString(1,user.getUname());
            preparedStatement.setString(2,user.getUpass());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt("type");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return -1;
    }

    @Override
    public boolean insert(User user) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into user (uname, upass, type) " +
                    "values (?, ?, 2)");
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpass());
            int result = preparedStatement.executeUpdate();
            return result > 0 ? true : false;
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean delete(String uname) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from user where uname = ?");
            preparedStatement.setString(1, uname);
            int result = preparedStatement.executeUpdate();
            return result > 0 ? true : false;
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
        return false;
    }

    // @param user: 现在登陆的用户
    // @param user2: 尝试被更新信息的用户
    // @param loginResult: 已登陆用户权限
    @Override
    public boolean update(User user, User user2, int loginResult) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            if(user != null && user2 != null){
                if(user.getUname().equals(user2.getUname()) || loginResult == 1){
                    preparedStatement = connection.prepareStatement("update user set upass = ? where uname = ? ");
                    preparedStatement.setString(1, user2.getUpass());
                    preparedStatement.setString(2, user2.getUname());
                    int result = preparedStatement.executeUpdate();
                    return result > 0 ? true : false;
                }else{
                    System.out.println("登录用户不符或没有权限");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public User select(String uname) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from user where uname = ? ");
            preparedStatement.setString(1, uname);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("uname");
                String pass = resultSet.getString("upass");
                int type = resultSet.getInt("type");
                return new User(id, name, pass, type);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
