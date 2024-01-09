package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    List<CustomerDto> getAllCustomers() throws SQLException;
    boolean saveCustomer(final CustomerDto dto) throws SQLException;
    boolean updateCustomer(final CustomerDto dto) throws SQLException;
    boolean deleteCustomer(String tel) throws SQLException;
    CustomerDto searchCustomer(String tel) throws SQLException;
}
