package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.tm.CartTm;

import java.sql.SQLException;

public interface OrderDetailBO extends SuperBO {
    boolean saveOrderDetail(String o_id, CartTm cartTm) throws SQLException;
}
