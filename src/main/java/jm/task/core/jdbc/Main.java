package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

      UserServiceImpl userService = new UserServiceImpl();



     /*   Configuration configuration =new Configuration();

        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();*/

        //userService.dropUsersTable();
        //userService.dropUsersTable();
        //userService.dropUsersTable();
        //userService.createUsersTable();
        userService.saveUser("Anton", "Ivanov", (byte)12);
        //userService.saveUser("Pete", "Vasilev", (byte)23);
        //userService.saveUser("Sergey", "Ponev", (byte)32);
        //userService.saveUser("Vanya", "Skorov", (byte)26);
        //userService.removeUserById(1);
        //userService.getAllUsers();
        //userService.cleanUsersTable();
        /*System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();*/
       // userService.dropUsersTable();

    }
}

/*Описание задачи:

Необходимо ознакомиться с заготовкой и доработать приложение, которое взаимодействует
 с базой оперируя пользователем ( класс User ) и проверить свои методы заранее написанными JUnit тестами.
  По итогу все тесты должны быть пройдены. Разрешается посмотреть реализацию тестов.

Для запуска теста необходимо найти класс в папке test ( показано в предыдущей лекции ) и
при нажатии на него правой кнопкой мыши запустить, выбрав Run "Имя класса"

Класс UserHibernateDaoImpl в рамках этой задачи не затрагивается (остаётся пустой)

User представляет из себя сущность с полями:

Long id

String name

String lastName

Byte age

Архитектура приложения создана с опорой на паттерн проектирования MVC (частично, у нас не WEB приложение)

Ознакомиться с паттерном можно здесь

Требования к классам приложения:

 Классы dao/service должны реализовывать соответствующие интерфейсы

 Класс dao должен иметь конструктор пустой/по умолчанию

 Все поля должны быть private

 service переиспользует методы dao

 Обработка всех исключений, связанных с работой с базой данных должна находиться в dao

 Класс Util должен содержать логику настройки соединения с базой данных

Необходимые операции:

 Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует

 Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует

 Очистка содержания таблицы

 Добавление User в таблицу

 Удаление User из таблицы ( по id )

 Получение всех User(ов) из таблицы

Алгоритм работы приложения:

         В методе main класса Main должны происходить следующие операции:

 Создание таблицы User(ов)

 Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )

 Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)

 Очистка таблицы User(ов)

 Удаление таблицы */