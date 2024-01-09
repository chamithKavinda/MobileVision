package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.PlaceOrderDAO;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.PlaceOrderDto;
import lk.ijse.MobileVision.entity.PlaceOrder;
import lk.ijse.MobileVision.model.OrderDetailModel;
import lk.ijse.MobileVision.model.OrderModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {

    private final OrderModel orderModel = new OrderModel();
    private final OrderDetailModel orderDetailModel = new OrderDetailModel();

    @Override
    public List<PlaceOrder> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(PlaceOrder placeOrder) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PlaceOrder placeOrder) throws SQLException {
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
    public PlaceOrder search(String s) throws SQLException {
        return null;
    }

    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException {
        boolean result = false;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = OrderModel.saveOrder(placeOrderDto.getO_id(), placeOrderDto.getC_tel(), placeOrderDto.getDate());
            if (isOrderSaved) {
                boolean isOrderDetailSaved = orderDetailModel.saveOrderDetail(placeOrderDto.getO_id(), placeOrderDto.getTmList());
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
