package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Properties;


import static jm.task.core.jdbc.util.Util.sessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    Session session;
    public UserDaoHibernateImpl() {


    }

    @Override
    public void createUsersTable() {
        session = sessionFactory.openSession();

        String sql = """
                CREATE TABLE IF NOT EXISTS Users (
                id SERIAL PRIMARY KEY,
                name VARCHAR not null,
                lastName VARCHAR not null,
                age SMALLINT
                );
                
                """;

        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql);
            query.executeUpdate();
            //session.flush();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Попытка создать существующую таблицу");
        } finally {
            //session.flush();
            session.close();
        }


    }

    @Override
    public void dropUsersTable() {
        session = sessionFactory.openSession();

        String sql = """
                DROP TABLE  Users;
                """;
        try {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sql);
            query.executeUpdate();
            //session.flush();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Попытка удалить несуществующую таблицу");
        } finally {
            //session.flush();
            session.close();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        session = sessionFactory.openSession();
        session.beginTransaction();

        User user = new User(name, lastName, age);
        session.persist(user);
        session.getTransaction().commit();


    }

    @Override
    public void removeUserById(long id) {
        User user;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        user = (User) session.load(User.class,id);
        System.out.println(user);
        session.delete(user);
        session.flush();
        session.getTransaction().commit();

    }

    @Override
    public List<User> getAllUsers() {
        session = sessionFactory.openSession();
        List entities = null;
        session.beginTransaction();
        entities = session.createQuery("from User").list();
        session.getTransaction().commit();
        //System.out.println(entities);
        return entities;
    }

    @Override
    public void cleanUsersTable() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
    }
}

/*
PP 1.1.4 Задача
        В этом задании мы познакомимся с фреймворком Hibernate и научимся взаимодействовать
        с помощью него с базой данных.

        Для выполнения задания необходимо:

        Ознакомиться с Hibernate. Подробнее узнать о Hibernate можно Здесь

        Готовая прошлая задача ( работа будет происходить в этом же проекте )



        Описание задачи:

        В прошлой задаче мы познакомились с Maven и JDBC, доработали приложение, взаимодействующее
         с базой данных.

        На этот раз обратим внимание на класс UserHibernateDaoImpl, который реализует тот же интерефейс,
         что и UserDaoJdbcImpl.

        В рамках этой задачи необходимо реализовать взаимодействие с базой данных с помощью Hibernate и
        дописать методы в классе UserHibernateDaoImpl, проверить свои методы заранее написанными JUnit
        тестами из заготовки.



        Требования к классам приложения:

        UserHibernateDaoImpl должен реализовывать интерефейс UserDao

        В класс Util должна быть добавлена конфигурация для Hibernate ( рядом с JDBC), без использования xml.

        Service на этот раз использует реализацию dao через Hibernate

        Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl
        должны быть реализованы с помощью SQL.



        Алгоритм приложения и операции не меняются в сравнении с предыдущим заданием.
*/
