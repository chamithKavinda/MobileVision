package lk.ijse.MobileVision.model;

import lk.ijse.MobileVision.dao.CustomerDAOImpl;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.RepairDto;
import lk.ijse.MobileVision.dto.tm.CustomerTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    public List<CustomerDto> getAllCustomers() throws SQLException{
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        ArrayList<CustomerDto> allCustomer = (ArrayList<CustomerDto>) customerDAO.getAllCustomers();

        for (CustomerDto dto : allCustomer){
            new CustomerTm(
                    dto.getTel(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getId()
            );
        }
        return allCustomer;
    }

    public boolean saveCustomer(final CustomerDto dto) throws SQLException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        boolean isSaved = customerDAO.saveCustomer(new CustomerDto(dto.getTel(), dto.getName(), dto.getAddress(), dto.getId()));
        return isSaved;
    }

    public boolean updateCustomer(final CustomerDto dto) throws SQLException {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        boolean isUpdate = customerDAO.updateCustomer(new CustomerDto(dto.getTel(), dto.getName(), dto.getAddress(), dto.getId()));
        return isUpdate;
    }


    public boolean deleteCustomer(String tel) throws SQLException{
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE c_contact = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,tel);

        return pstm.executeUpdate()>0;
    }


    public CustomerDto searchCustomer(String tel) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer WHERE c_contact = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, tel);

        ResultSet resultSet = pstm.executeQuery();

        CustomerDto dto = null;

        if(resultSet.next()) {
            String c_tel = resultSet.getString(1);
            String c_name = resultSet.getString(2);
            String c_address = resultSet.getString(3);
            String c_id= resultSet.getString(4);

            dto = new CustomerDto(c_tel, c_name, c_address, c_id);
        }

        return dto;
    }


}
