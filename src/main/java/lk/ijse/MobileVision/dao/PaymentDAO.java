package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dto.PaymentDto;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDAO {

    boolean deletePayment(String p_id) throws SQLException;

    boolean savePayment(PaymentDto dto) throws SQLException;

    List<PaymentDto> getAllPayment() throws SQLException;

    boolean updatePayment(PaymentDto dto) throws SQLException;
}
