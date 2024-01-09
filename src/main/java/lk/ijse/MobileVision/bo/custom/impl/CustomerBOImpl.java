package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.CustomerBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.CustomerDAO;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMERS);

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {
        System.out.println("hi");
        List<Customer> entityList = customerDAO.getAll();

        List<CustomerDto> dtoList = new ArrayList<>();

        for (Customer customer:entityList){
            dtoList.add(new CustomerDto(
                    customer.getTel(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getId()));
        }
        return dtoList;
    }

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.save(new Customer(
                dto.getTel(),
                dto.getName(),
                dto.getAddress(),
                dto.getId()));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.update(new Customer( dto.getTel(),
                dto.getName(),
                dto.getAddress(),
                dto.getId()));
    }

    @Override
    public boolean deleteCustomer(String tel) throws SQLException {
        return customerDAO.delete(tel);
    }

    @Override
    public CustomerDto searchCustomer(String tel) throws SQLException {
        Customer customer=customerDAO.search(tel);
        return new CustomerDto(customer.getTel(),customer.getName(),customer.getAddress(),customer.getId());
    }
}

