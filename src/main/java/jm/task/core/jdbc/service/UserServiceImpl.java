package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoJDBCImpl();



    public void createUsersTable() {
        userDao.createUsersTable();
    }

    /**
     * Удалить таблицу Users
     */
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    /**
     * Сохранить в таблицу Users пользователя
     */
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    /**
     * Удалить пользователя из таблицы по его ID
     */
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    /**
     * Получить всех пользователей из таблицы Users
     */
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    /**
     * Очистить таблицу Users не удаляя её
     */
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
