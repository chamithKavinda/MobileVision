package lk.ijse.MobileVision.model;

import lk.ijse.MobileVision.dao.UserDAOImpl;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static boolean saveUser(UserDto dto) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        boolean isSaved = userDAO.saveUser(new UserDto(dto.getUserName(), dto.getEmail(), dto.getPassword()));
        return isSaved;
    }

    public static String getEmail(String Email) throws SQLException , ClassNotFoundException{
        UserDAOImpl userDAO = new UserDAOImpl();
        String e = userDAO.getEmail(Email);
        return e;
    }

    public static boolean isExistUser(String UserName,String Password) throws SQLException,ClassNotFoundException{
        UserDAOImpl userDAO = new UserDAOImpl();
        boolean isExist = userDAO.isExistUser(UserName, Password);
        return isExist;
    }
}



