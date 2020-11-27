package dao;

import bean.User;

public interface UserDao {

    // 返回-1登录失败 1管理员登录 2学生登陆
    public int login(User user);

    // 用于添加学生的方法，成功返回true，失败返回false
    public boolean insert(User user);

    // 用于删除学生信息的方法，成功返回true，失败返回false
    public boolean delete(String uname);

    // 用于修改学生信息的方法，成功返回true，失败返回false
    public boolean update(User user, User user1, int loginResult);

    // 用于查询学生信息的方法，成功返回User，失败返回null
    public User select(String uname);
}
