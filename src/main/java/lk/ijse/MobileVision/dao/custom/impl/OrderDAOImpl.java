package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.OrderDAO;
import lk.ijse.MobileVision.entity.Order;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public List<Order> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(Order order) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO orders VALUES(?, ?, ?)",
                order.getO_id(),
                order.getC_tel(),
                order.getDate());
    }

    @Override
    public boolean update(Order order) throws SQLException {
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
         ResultSet resultSet = SQLUtil.crudUtil("SELECT o_id FROM orders ORDER BY o_id DESC LIMIT 1");

        String currentOrderId = null;

        if(resultSet.next()) {
            currentOrderId = resultSet.getString(1);
            return splitOrderId(currentOrderId);
        }
        return splitOrderId(null);

    }

    @Override
    public Order search(String s) throws SQLException {
        return null;
    }

    private String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] split = currentOrderId.split("O");
            int id = Integer.parseInt(split[1]);    //008
            id ++;  //9
            return "O00" + id;
        }
        return "O001";
    }
}
