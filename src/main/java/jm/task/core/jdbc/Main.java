package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        User one = new User( "Bob", "Sidorov", (byte) 21);
        User too = new User("Bedam", "Lasov", (byte) 22);
        User tree = new User("Abdurozik", "Sumbuk", (byte) 23);
        User four = new User("Hasbic", "busic", (byte) 24);

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser(one.getName(), one.getLastName(), one.getAge());
        System.out.println("Пользователь : " + one.toString() + " добавлен");
        userService.saveUser(too.getName(), too.getLastName(), too.getAge());
        System.out.println("Пользователь : " + too.toString() + " добавлен");
        userService.saveUser(tree.getName(), tree.getLastName(), tree.getAge());
        System.out.println("Пользователь : " + tree.toString() + " добавлен");
        userService.saveUser(four.getName(), four.getLastName(), four.getAge());
        System.out.println("Пользователь : " + four.toString() + " добавлен");

        List<User> allUsers = userService.getAllUsers();
        for(User us : allUsers) {
            System.out.println(us.toString());
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}