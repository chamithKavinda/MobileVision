package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.OrderBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.OrderDAO;
import lk.ijse.MobileVision.entity.Order;

import java.sql.SQLException;
import java.time.LocalDate;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public String generateNextOrderId() throws SQLException {
        return orderDAO.generateId();
    }
}
