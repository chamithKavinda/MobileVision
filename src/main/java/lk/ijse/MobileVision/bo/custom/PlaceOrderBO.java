package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.PlaceOrderDto;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;
}
