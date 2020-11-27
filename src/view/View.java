package view;

import bean.User;

import java.util.Scanner;

public class View {
    private static Scanner scan = new Scanner(System.in);
    public static User indexView(){
        System.out.println("************************************************");
        System.out.println("*************\t\t学生信息管理系统\t\t*************");
        System.out.println("*************\t\t请根据提示操作\t\t*************");
        System.out.println("*************\t\t请输入账号:\t\t*************");
        String uname = scan.nextLine();
        System.out.println("*************\t\t请输入密码:\t\t*************");
        String upass = scan.nextLine();
        System.out.println("************************************************");
        return new User(uname, upass);
    }

    public static int managerMenuView(){
        System.out.println("************************************************");
        System.out.println("*************欢迎管理员回家*************");
        System.out.println("*************请根据提示操作*************");
        System.out.println("*************\t\t0.退出\t\t*************");
        System.out.println("*************\t\t1.增加学生信息\t\t*************");
        System.out.println("*************\t\t2.删除学生信息\t\t*************");
        System.out.println("*************\t\t3.修改学生信息\t\t*************");
        System.out.println("*************\t\t4.查询学生信息\t\t*************");
        System.out.println("************************************************");
        int input = Integer.parseInt(scan.nextLine());
        if(input < 0 || input > 4){
            System.out.println("输入错误，请重新输入");
            return managerMenuView();   // 回调
        }
        return input;
    }

    public static int studentMenuView(){
        System.out.println("************************************************");
        System.out.println("*************欢迎来到学生查询系统*************");
        System.out.println("*************\t\t0.退出\t\t*************");
        System.out.println("*************\t\t1.修改学生信息\t\t*************");
        System.out.println("************************************************");
        int input = Integer.parseInt(scan.nextLine());
        if(input < 0 || input > 1){
            System.out.println("输入错误，请重新输入");
            return studentMenuView();   // 回调
        }
        return input;
    }



    public static User addMenuView(){
        System.out.println("************************************************");
        System.out.println("*************\t\t请根据提示操作\t\t*************");
        System.out.println("*************\t\t请输入新添加的账号:\t\t*************");
        String uname = scan.nextLine();
        System.out.println("*************\t\t请输入新添加的密码:\t\t*************");
        String upass = scan.nextLine();
        System.out.println("************************************************");
        return new User(uname, upass);
    }

    public static String deleteMenuView(){
        System.out.println("************************************************");
        System.out.println("*************\t\t请根据提示操作\t\t*************");
        System.out.println("*************\t\t请输入要删除的账号:\t\t*************");
        String uname1 = scan.nextLine();
        System.out.println("************************************************");
        return uname1;
    }

    public static User updateMenuView(){
        System.out.println("************************************************");
        System.out.println("*************\t\t请根据提示操作\t\t*************");
        System.out.println("*************\t\t请输入要更新的账号:\t\t*************");
        String uname = scan.nextLine();
        System.out.println("*************\t\t请输入要更新的密码:\t\t*************");
        String upass = scan.nextLine();
        System.out.println("************************************************");
        return new User(uname, upass);
    }

    public static String selectMenuView(){
        System.out.println("************************************************");
        System.out.println("*************\t\t请根据提示操作\t\t*************");
        System.out.println("*************\t\t请输入要查询的账号:\t\t*************");
        String uname = scan.nextLine();
        System.out.println("************************************************");
        return uname;
    }
}
