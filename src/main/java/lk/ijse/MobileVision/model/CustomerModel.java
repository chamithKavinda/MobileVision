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

    CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    public List<CustomerDto> getAllCustomers() throws SQLException{

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
        boolean isSaved = customerDAO.saveCustomer(new CustomerDto(dto.getTel(), dto.getName(), dto.getAddress(), dto.getId()));
        return isSaved;
    }

    public boolean updateCustomer(final CustomerDto dto) throws SQLException {
        boolean isUpdate = customerDAO.updateCustomer(new CustomerDto(dto.getTel(), dto.getName(), dto.getAddress(), dto.getId()));
        return isUpdate;
    }

    public boolean deleteCustomer(String tel) throws SQLException{
        boolean isDelete = customerDAO.deleteCustomer(tel);
        return isDelete;
    }

    public CustomerDto searchCustomer(String tel) throws SQLException {
        CustomerDto isSearch = customerDAO.searchCustomer(tel);
        return isSearch;
    }
}
