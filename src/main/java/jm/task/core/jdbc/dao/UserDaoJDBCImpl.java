package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection;
    public UserDaoJDBCImpl() {
        try {
            this.connection = Util.ConnectToUrl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sqlCreat = "CREATE TABLE IF NOT EXISTS users (" + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " + "name VARCHAR(30), " + "last_name VARCHAR(40), " + "age INT NOT NULL)";

            statement.execute(sqlCreat);
            System.out.println("Таблица users создана успешно!");
        } catch (SQLException e) {
            System.err.println("Произошла ошибка при создании таблицы");
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sqlDrop = "DROP TABLE IF EXISTS users";
            statement.execute(sqlDrop);
            System.out.println("Таблица успешно удалена!");
        } catch (SQLException e) {
            System.out.println("Произошла ошибка при удалении таблицы!");
            e.printStackTrace();
        }

    }

    public void saveUser(String userName, String lastName, byte age) {
            String sqlSave = "INSERT INTO users (name,last_name, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSave)){
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Произошла ошибка при добовлении пользователя в таблицу!");
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlRemove = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRemove)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Пользователь по id успешно удален!");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении по id");
            e.printStackTrace();
        }


    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sqlGet = "SELECT * FROM users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlGet);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                byte age = resultSet.getByte("age");

                user.setId(id);
                user.setName(name);
                user.setLastName(lastName);
                user.setAge(age);
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sqlClean = "DELETE FROM users";
            statement.execute(sqlClean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
