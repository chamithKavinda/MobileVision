package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.CustomerDAO;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.entity.Customer;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Customer> getAll() throws SQLException{
        ResultSet resultSet = SQLUtil.crudUtil("select * from customer");
        List<Customer> entityList= new ArrayList<>();
        while (resultSet.next()){
            String c_contact = resultSet.getString(1);
            String c_name = resultSet.getString(2);
            String c_address = resultSet.getString(3);
            String c_id = resultSet.getString(4);

            var dto = new Customer(c_contact,c_name,c_address,c_id);
            entityList.add(dto);
        }
        return entityList;
    }

    @Override
    public boolean save(Customer customer) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO customer VALUES(?,?,?,?)",
                customer.getTel(),
                customer.getName(),
                customer.getAddress(),
                customer.getId());
    }

    @Override
    public boolean update(Customer customer) throws SQLException{
        return SQLUtil.crudUtil("UPDATE customer set c_name = ?,c_address = ?, c_id = ? WHERE c_contact = ?",
                customer.getName(),
                customer.getAddress(),
                customer.getId(),
                customer.getTel());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM customer WHERE c_contact = ?",id);
    }

    @Override
    public boolean exist(String id) throws SQLException{
        return false;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }

    @Override
    public Customer search(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.crudUtil("SELECT * FROM customer WHERE c_contact = ?",s);
        Customer entity = null;
        if(resultSet.next()) {
            String c_tel = resultSet.getString(1);
            String c_name = resultSet.getString(2);
            String c_address = resultSet.getString(3);
            String c_id= resultSet.getString(4);
            entity = new Customer(c_tel, c_name, c_address, c_id);
        }
        return  entity;
    }
}

