package controller;

import bean.User;
import dao.UserDao_Imp;
import view.View;

public class Control {
    public static void managerServer(User user, int loginResult){
        UserDao_Imp userDao_imp = new UserDao_Imp();
        while(true){
            int choice = View.managerMenuView();
            boolean success;
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    User user1 = View.addMenuView();
                    success = userDao_imp.insert(user1);
                    if(success){
                        System.out.println("添加成功");
                    }else{
                        System.out.println("添加失败");
                    }
                    break;
                case 2:
                    String name1 = View.deleteMenuView();
                    success = userDao_imp.delete(name1);
                    if(success){
                        System.out.println("删除成功");
                    }else{
                        System.out.println("删除失败");
                    }
                    break;
                case 3:
                    User user2 = View.updateMenuView();
                    success = userDao_imp.update(user, user2, loginResult);
                    if(success){
                        System.out.println("更新成功");
                    }else{
                        System.out.println("更新失败");
                    }
                    break;
                case 4:
                    String name2 = View.selectMenuView();
                    User user3 = userDao_imp.select(name2);
                    if(user3 != null){
                        System.out.println(user3.toString());
                    }else{
                        System.out.println("查询失败");
                    }
                    break;
                default: break;
            }
        }
    }

    public static void studentServer(User user, int loginResult){
        UserDao_Imp userDao_imp = new UserDao_Imp();
        while(true){
            int choice = View.studentMenuView();
            boolean success;
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    User user1 = View.updateMenuView();
                    success = userDao_imp.update(user, user1, loginResult);
                    if(success){
                        System.out.println("更新成功");
                    }else{
                        System.out.println("更新失败");
                    }
                    break;
                default: break;
            }
        }
    }

    public static void main(String[] args) {
        User user = View.indexView();
        UserDao_Imp userDao_imp = new UserDao_Imp();
        int loginResult = 1;
        while(loginResult != -1){
            loginResult = userDao_imp.login(user);
            if(loginResult == -1){
                System.out.println("登录失败，请重新登录");
                loginResult = 1;
                Control.main(null);  // 回调
            }
            switch (loginResult){
                case 1: managerServer(user, loginResult); break;
                case 2: studentServer(user, loginResult); break;
                default: break;
            }
        }
    }
}
