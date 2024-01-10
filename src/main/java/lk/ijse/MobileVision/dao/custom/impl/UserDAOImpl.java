package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.UserDAO;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.entity.User;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private String Password;
    private String UserName;

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(User user) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO USER VALUES(?,?,?)",
                user.getUserName(),
                user.getEmail(),
                user.getPassword());
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException {
       return false;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }

    @Override
    public User search(String s) throws SQLException {
        return null;
    }

    public  String getEmail(String Email) throws SQLException , ClassNotFoundException{
        ResultSet resultSet = SQLUtil.crudUtil("SELECT Email FROM user WHERE Email=?",Email);

        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public boolean exist(String UserName, String Password) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT Password , UserName FROM user WHERE UserName=? and Password=?",UserName,Password);
        String dbUserName = null;
        String dbPassword = null;
        if(resultSet.next()){
            dbPassword = resultSet.getString(1);
            dbUserName = resultSet.getString(2);
            // DbConnection.Email = resultSet.getString(3);
        }
        return UserName.equals(dbUserName) && Password.equals(dbPassword);
    }
}
