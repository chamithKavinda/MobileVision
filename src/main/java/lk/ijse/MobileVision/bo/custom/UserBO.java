package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.UserDto;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDto dto) throws SQLException;
    String getEmail(String Email) throws SQLException , ClassNotFoundException;
    boolean isExistUser(String UserName,String Password) throws SQLException,ClassNotFoundException;

}

