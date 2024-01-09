package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.PaymentDAO;
import lk.ijse.MobileVision.dto.PaymentDto;
import lk.ijse.MobileVision.entity.Payment;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public List<Payment> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("select * from payments");
        List<Payment> entityList = new ArrayList<>();
        while (resultSet.next()){
            String p_id = resultSet.getString(1);
            String c_tel = resultSet.getString(2);
            String o_id = resultSet.getString(3);
            String date = resultSet.getString(4);
            String description = resultSet.getString(5);
            String amount = resultSet.getString(6);

            var dto = new Payment(p_id,c_tel,o_id,date,description,amount);
            entityList.add(dto);
        }
        return entityList;

    }

    @Override
    public boolean save(Payment payment) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO payments VALUES(?,?,?,?,?,?)",
                payment.getP_id(),
                payment.getC_tel(),
                payment.getO_id(),
                payment.getDate(),
                payment.getDescription(),
                payment.getAmount());
    }

    @Override
    public boolean update(Payment payment) throws SQLException {
        return SQLUtil.crudUtil("UPDATE payments set c_contact = ?, o_id = ? , date=? ,p_description = ?, Amount = ?  WHERE p_id = ?",
                payment.getC_tel(),
                payment.getO_id(),
                payment.getDate(),
                payment.getDescription(),
                payment.getAmount(),
                payment.getP_id());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM payments WHERE p_id = ?",id);
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
    public Payment search(String s) throws SQLException {
        return null;
    }
}
