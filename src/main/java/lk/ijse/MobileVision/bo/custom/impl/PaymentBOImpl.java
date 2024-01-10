package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.PaymentBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.PaymentDAO;
import lk.ijse.MobileVision.dto.PaymentDto;
import lk.ijse.MobileVision.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);

    @Override
    public boolean deletePayment(String p_id) throws SQLException {
        return paymentDAO.delete(p_id);
    }

    @Override
    public boolean savePayment(PaymentDto dto) throws SQLException {
        return paymentDAO.save(new Payment(
                dto.getP_id(),
                dto.getC_tel(),
                dto.getO_id(),
                dto.getDate(),
                dto.getDescription(),
                dto.getAmount()));
    }

    @Override
    public List<PaymentDto> getAllPayment() throws SQLException {
        List<Payment> entityList = paymentDAO.getAll();
        List<PaymentDto> dtoList = new ArrayList<>();

        for (Payment payment:entityList){
            dtoList.add(new PaymentDto(
                    payment.getP_id(),
                    payment.getC_tel(),
                    payment.getO_id(),
                    payment.getDate(),
                    payment.getDescription(),
                    payment.getAmount()));
        }
         return dtoList;
    }

    @Override
    public boolean updatePayment(PaymentDto dto) throws SQLException {
        return paymentDAO.update(new Payment(
                dto.getC_tel(),
                dto.getO_id(),
                dto.getDate(),
                dto.getDescription(),
                dto.getAmount(),
                dto.getP_id()));
    }
}
