package lk.ijse.MobileVision.model;

import lk.ijse.MobileVision.dao.CustomerDAOImpl;
import lk.ijse.MobileVision.dao.EmployeeDAO;
import lk.ijse.MobileVision.dao.EmployeeDAOImpl;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.EmployeeDto;
import lk.ijse.MobileVision.dto.tm.CustomerTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    public boolean deleteEmployee(String id) throws SQLException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        boolean isDelete = employeeDAO.deleteEmployee(id);
        return isDelete;
    }

    public List<EmployeeDto> getAllEmployee() throws SQLException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        ArrayList<EmployeeDto> allEmployee = (ArrayList<EmployeeDto>) employeeDAO.getAllEmployee();

        for (EmployeeDto dto : allEmployee){
            new EmployeeDto(
                    dto.getTel(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getId()
            );
        }
        return allEmployee;
    }

    public boolean saveEmployee(final EmployeeDto dto) throws SQLException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        boolean isSaved = employeeDAO.saveEmployee(new EmployeeDto(dto.getId(), dto.getName(), dto.getAddress(), dto.getTel()));
        return isSaved;
    }

    public boolean updateEmployee(final EmployeeDto dto) throws SQLException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        boolean isUpdate = employeeDAO.updateEmployee(new EmployeeDto(dto.getId(), dto.getName(), dto.getAddress(), dto.getTel()));
        return isUpdate;
    }

    public CustomerDto searchCustomer(String id) throws SQLException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        CustomerDto isSearch = employeeDAO.searchCustomer(id);
        return isSearch;
    }


}
