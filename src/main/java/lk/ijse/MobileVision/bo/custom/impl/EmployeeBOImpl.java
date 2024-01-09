package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.EmployeeBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.EmployeeDAO;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.EmployeeDto;
import lk.ijse.MobileVision.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        return employeeDAO.delete(id);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() throws SQLException {
        List<Employee> entityList = employeeDAO.getAll();
        List<EmployeeDto> dtoList = new ArrayList<>();

        for (Employee employee : entityList){
            dtoList.add(new EmployeeDto(
                    employee.getId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getTel()));
        }
        return dtoList;
    }

    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException {
        return employeeDAO.save(new Employee(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getTel()));
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        return employeeDAO.update(new Employee(
                dto.getName(),
                dto.getAddress(),
                dto.getTel(),
                dto.getId()));
    }

    @Override
    public CustomerDto searchCustomer(String id) throws SQLException {
        Employee employee = employeeDAO.search(id);
        return new CustomerDto(
                employee.getId(),
                employee.getName(),
                employee.getAddress(),
                employee.getTel());
    }
}
