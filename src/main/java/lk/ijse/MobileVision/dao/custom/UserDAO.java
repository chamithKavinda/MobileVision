package lk.ijse.MobileVision.dao.custom;

import lk.ijse.MobileVision.dao.CrudDAO;
import lk.ijse.MobileVision.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
    String getEmail(String Email) throws SQLException, ClassNotFoundException;

    boolean exist(String UserName, String Password) throws SQLException;
}
