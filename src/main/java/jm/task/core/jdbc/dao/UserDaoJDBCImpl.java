package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.connection;

public class UserDaoJDBCImpl implements UserDao {

    public Statement st;
    public UserDaoJDBCImpl() {
        try {
            st = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS Users (
                id SERIAL PRIMARY KEY,
                name VARCHAR not null,
                lastName VARCHAR not null,
                age SMALLINT
                );
                
                """;
        try {
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println("Вы пытаетесь создать существующу таблицу");
        }
    }

    public void dropUsersTable() {
        String sql = """
                DROP TABLE Users;
                """;
        try {
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println("Вы пытаетесь удалить несуществующу таблицу");
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        String sql = "INSERT INTO Users (name, lastname, age)" +
                "VALUES ('" + name + "', '" + lastName + "', '" + age + "')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {

        String sql = "DELETE FROM Users WHERE id = " + id + ";";
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM Users";
        ResultSet resultSet;
        List <User> users = new ArrayList<>();
        try {
            resultSet = st.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                byte age = (byte)resultSet.getInt("age");
                User newUser = new User(name, lastName, age);
                newUser.setId(id);
                users.add(newUser);
                System.out.println("User с именем " + name + " добавлен в таблицу");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE Users";
        try {
            st.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
