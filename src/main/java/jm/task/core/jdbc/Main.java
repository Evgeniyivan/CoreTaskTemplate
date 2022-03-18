package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {

    static UserServiceImpl userServiceImpl = new UserServiceImpl();
    public static void main(String[] args) throws SQLException {

//       userServiceImpl.createUsersTable();
//       userServiceImpl.saveUser("Denis","Penis", (byte) 19);
//       userServiceImpl.saveUser("Anton","Gnoy", (byte) 26);
//       userServiceImpl.saveUser("Igor","Pidor", (byte) 34);
//        userServiceImpl.saveUser("Sergey","Sergeev", (byte) 55);

//       userServiceImpl.removeUserById(1);
//       userServiceImpl.getAllUsers();
//       userServiceImpl.cleanUsersTable();
       userServiceImpl.dropUsersTable();

    }

}