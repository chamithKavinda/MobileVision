package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dto.UserDto;

import java.sql.SQLException;

public interface UserDAO {
    boolean saveUser(UserDto dto) throws SQLException;
    String getEmail(String Email) throws SQLException , ClassNotFoundException;
    boolean isExistUser(String UserName,String Password) throws SQLException,ClassNotFoundException;
}
