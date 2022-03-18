package jm.task.core.jdbc.bl;


import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("все заебись");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("хуй тебе");
        }
        return connection;
    }
}
