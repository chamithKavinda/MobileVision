package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.PlaceOrderBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.OrderDAO;
import lk.ijse.MobileVision.dao.custom.OrderDetailDAO;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.PlaceOrderDto;
import lk.ijse.MobileVision.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    OrderDAO orderDAO =(OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);

    @Override
    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException {
        boolean result = false;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = orderDAO.save(new Order(placeOrderDto.getO_id(), placeOrderDto.getC_tel(), placeOrderDto.getDate()));
            if (isOrderSaved) {
                boolean isOrderDetailSaved = orderDetailDAO.saveOrderDetail(placeOrderDto.getO_id(), placeOrderDto.getTmList());
                if (isOrderDetailSaved) {
                    connection.commit();
                    result = true;
                }
            }
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);

            }
        }
        return result;
    }
}
