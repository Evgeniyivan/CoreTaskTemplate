package jm.task.core.jdbc.service;

import jm.task.core.jdbc.bl.Util;
import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {

    private final Connection connection = Util.getConnection();

    @Override
    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS queers " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";

            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS queers";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveUser(String name, String lastName, byte age) {

        String sql = "INSERT INTO queers (name , lastName, age) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void removeUserById(long id) {

        String sql = "DELETE FROM queers WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        String sql = "SELECT ID, name, lastName, age FROM queers ";
        try (Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("AGE"));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {

        String sql = "TRUNCATE TABLE queers";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    }

