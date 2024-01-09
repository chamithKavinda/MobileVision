package lk.ijse.MobileVision.dao.custom;

import lk.ijse.MobileVision.dao.CrudDAO;
import lk.ijse.MobileVision.dto.tm.CartTm;
import lk.ijse.MobileVision.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderDetail> {
    boolean saveOrderDetail(String o_id, List<CartTm> tmList) throws SQLException;
}
