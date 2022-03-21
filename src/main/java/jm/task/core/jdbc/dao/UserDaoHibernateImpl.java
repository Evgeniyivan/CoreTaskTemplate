package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.bl.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    private final UserDao userDao = new UserDaoJDBCImpl();
    Session session = getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    @Override
    public void createUsersTable() {

        userDao.createUsersTable();
        transaction.commit();
        session.close();


    }

    @Override
        public void dropUsersTable() {

        userDao.dropUsersTable();
        transaction.commit();
        session.close();
        }
    @Override
    public void saveUser(String name, String lastName, byte age) {

        userDao.saveUser(name,lastName,age);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {

        userDao.removeUserById(id);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {

        transaction.commit();
        session.close();
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {

        userDao.cleanUsersTable();
        transaction.commit();
        session.close();
    }
}

