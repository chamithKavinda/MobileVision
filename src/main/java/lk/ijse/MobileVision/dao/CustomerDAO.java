package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
     boolean saveCustomer(final CustomerDto dto) throws SQLException ;

     boolean updateCustomer(final CustomerDto dto) throws SQLException;

     List<CustomerDto> getAllCustomers() throws SQLException;

}
