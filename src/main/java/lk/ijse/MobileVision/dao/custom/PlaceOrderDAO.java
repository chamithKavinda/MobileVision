package lk.ijse.MobileVision.dao.custom;

import lk.ijse.MobileVision.dao.CrudDAO;
import lk.ijse.MobileVision.dto.PlaceOrderDto;
import lk.ijse.MobileVision.entity.PlaceOrder;

import java.sql.SQLException;

public interface PlaceOrderDAO extends CrudDAO<PlaceOrder> {
    boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;
}
