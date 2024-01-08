package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.EmployeeDAO;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.EmployeeDto;
import lk.ijse.MobileVision.entity.Employee;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("select * from employee");
        List<Employee> entityList = new ArrayList<>();
        while (resultSet.next()){
            String e_id = resultSet.getString(1);
            String e_name = resultSet.getString(2);
            String e_address = resultSet.getString(3);
            String e_contact = resultSet.getString(4);

            var dto = new Employee(e_id,e_name,e_address,e_contact);
            entityList.add(dto);
        }
        return entityList;
    }

    @Override
    public boolean save(Employee employee) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO employee VALUES(?,?,?,?)",
                employee.getId(),
                employee.getName(),
                employee.getAddress(),
                employee.getTel());
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        return SQLUtil.crudUtil("UPDATE employee set e_name = ?,e_address = ?,e_contact = ? WHERE e_id = ?",
                employee.getName(),
                employee.getAddress(),
                employee.getTel(),
                employee.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM employee WHERE e_id = ?",id);
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
    public Employee search(String s) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM employee WHERE e_id = ?",s);
        Employee entity = null;

        if(resultSet.next()) {
            String e_id = resultSet.getString(1);
            String e_name = resultSet.getString(2);
            String e_address = resultSet.getString(3);
            String e_tel = resultSet.getString(4);

            entity = new Employee(e_id, e_name, e_address, e_tel);
        }
        return entity;
    }
}
