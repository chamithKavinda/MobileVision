package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    boolean deleteEmployee(String id) throws SQLException;
    List<EmployeeDto> getAllEmployee() throws SQLException;
    boolean saveEmployee(final EmployeeDto dto) throws SQLException;
    boolean updateEmployee(final EmployeeDto dto) throws SQLException;
    CustomerDto searchCustomer(String id) throws SQLException;

}
