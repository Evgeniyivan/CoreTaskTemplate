package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {

    static UserServiceImpl userServiceImpl = new UserServiceImpl();
    static UserDaoHibernateImpl UDHI = new UserDaoHibernateImpl();

    public static void main(String[] args) throws SQLException {
//        UserService userService = new UserServiceImpl();
//        UDHI.dropUsersTable();
//        UDHI.createUsersTable();
        UDHI.saveUser("Denis","Penis", (byte) 19);
//        UDHI.removeUserById(1);
//        UDHI.cleanUsersTable();
//        userServiceImpl.createUsersTable();
//        userServiceImpl.saveUser("Denis","Penis", (byte) 19);


}

}