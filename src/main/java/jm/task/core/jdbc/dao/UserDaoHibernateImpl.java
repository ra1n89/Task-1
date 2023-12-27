package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;

public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {

    }






    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
      /*  System.out.println("!!!!!!!!!!!!!!!");
        session.beginTransaction();
        session.persist(new User(name, lastName, age));*/
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

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
