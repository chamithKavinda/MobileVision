package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.UserBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.UserDAO;
import lk.ijse.MobileVision.dto.UserDto;
import lk.ijse.MobileVision.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDto dto) throws SQLException {
        return userDAO.save(new User(
                dto.getUserName(),
                dto.getEmail(),
                dto.getPassword()));
    }

    @Override
    public String getEmail(String Email) throws SQLException, ClassNotFoundException {
        return userDAO.getEmail(Email);
    }

    @Override
    public boolean isExistUser(String UserName, String Password) throws SQLException, ClassNotFoundException {
        return userDAO.exist(UserName);
    }
}
