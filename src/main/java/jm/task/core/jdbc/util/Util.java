package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    // реализуйте настройку соединения с БД
    public static Connection connection  = open();



    private static final String  URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String  USER = "postgres";
    private static final String  PASSWORD = "root";

    public static Connection open(){
        try {
            return  DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static  Configuration configuration =new Configuration().addAnnotatedClass(User.class);
    public static SessionFactory sessionFactory = configuration.buildSessionFactory();



}
