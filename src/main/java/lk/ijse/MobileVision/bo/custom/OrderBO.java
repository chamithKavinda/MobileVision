package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderBO extends SuperBO {
    String generateNextOrderId() throws SQLException;
}
