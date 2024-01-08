package lk.ijse.MobileVision.model;

import lk.ijse.MobileVision.dao.PaymentDAOImpl;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.PaymentDto;
import lk.ijse.MobileVision.dto.RepairDto;
import lk.ijse.MobileVision.dto.tm.PaymentTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentModel {

    PaymentDAOImpl paymentDAO = new PaymentDAOImpl();

    public boolean deletePayment(String p_id) throws SQLException {
        boolean isDelete = paymentDAO.deletePayment(p_id);
        return isDelete;
    }

    public boolean savePayment(PaymentDto dto) throws SQLException {
        boolean isSaved = paymentDAO.savePayment(new PaymentDto(dto.getP_id(), dto.getC_tel(), dto.getO_id(), dto.getDate(), dto.getDescription(), dto.getAmount()));
        return isSaved;
    }

    public List<PaymentDto> getAllPayment() throws SQLException {
        ArrayList<PaymentDto> allPayment = (ArrayList<PaymentDto>) paymentDAO.getAllPayment();

        for(PaymentDto dto : allPayment){
            new PaymentTm(
                    dto.getP_id(),
                    dto.getC_tel(),
                    dto.getO_id(),
                    dto.getDate(),
                    dto.getDescription(),
                    dto.getAmount()
            );
        }
        return allPayment;
    }

    public boolean updatePayment(PaymentDto dto) throws SQLException {
        boolean isUpdate = paymentDAO.updatePayment(new PaymentDto(dto.getP_id(), dto.getC_tel(), dto.getO_id(), dto.getDate(), dto.getDescription(), dto.getAmount()));
        return isUpdate;
    }
}
