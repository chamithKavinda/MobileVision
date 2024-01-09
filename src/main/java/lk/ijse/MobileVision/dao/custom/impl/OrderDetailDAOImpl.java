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
        return SQLUtil.crudUtil("INSERT INTO order_details VALUES(?, ?, ?, ?)",
                orderDetail.getO_id(),
                orderDetail.getI_code(),
                orderDetail.getQty(),
                orderDetail.getUnit_price());
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

    public boolean saveOrderDetail(String o_id, List<CartTm> tmList) throws SQLException {
        for (CartTm cartTm : tmList) {
            if(!saveOrderDetail(o_id, (List<CartTm>) cartTm)) {
                return false;
            }
        }
        return true;
    }
}
