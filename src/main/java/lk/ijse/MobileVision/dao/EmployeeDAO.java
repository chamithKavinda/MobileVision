package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    boolean saveEmployee(final EmployeeDto dto) throws SQLException;
    boolean deleteEmployee(String id) throws SQLException;
    List<EmployeeDto> getAllEmployee() throws SQLException;
    boolean updateEmployee(final EmployeeDto dto) throws SQLException;
    CustomerDto searchCustomer(String id) throws SQLException;
}
