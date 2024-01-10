package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.OrderDetailDAO;
import lk.ijse.MobileVision.dto.tm.CartTm;
import lk.ijse.MobileVision.entity.OrderDetail;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public List<OrderDetail> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(OrderDetail orderDetail) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws SQLException {
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
    public OrderDetail search(String s) throws SQLException {
        return null;
    }

    @Override
    public boolean saveOrderDetail(String o_id, List<CartTm> tmList) throws SQLException {
        for (CartTm cartTm : tmList) {
            if(!save(o_id,cartTm)) {
                return false;
            }
        }
        return true;
    }

    private boolean save(String o_id, CartTm cartTm) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO order_details VALUES(?, ?, ?, ?)", o_id,cartTm.getCode(),cartTm.getQty(),cartTm.getUnitPrice());


    }


}
