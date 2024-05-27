package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        User one = new User( "Bob", "Sidorov", (byte) 21);
        User too = new User("John", "Lasov", (byte) 22);
        User tree = new User("Alex", "Sumbuk", (byte) 23);
        User four = new User("Lufi", "busic", (byte) 24);

        UserServiceImpl userService = new UserServiceImpl();
        //userService.createUsersTable();

        //userService.dropUsersTable();

        //userService.saveUser(one.getName(), one.getLastName(), one.getAge());
        //userService.saveUser(too.getName(), too.getLastName(), too.getAge());
        //userService.saveUser(tree.getName(), tree.getLastName(), tree.getAge());
        //userService.saveUser(four.getName(), four.getLastName(), four.getAge());
        //userService.removeUserById(2);

       // List<User> allUsers = userService.getAllUsers();
       // allUsers.forEach(System.out::println);
        // userService.cleanUsersTable();

    }
}