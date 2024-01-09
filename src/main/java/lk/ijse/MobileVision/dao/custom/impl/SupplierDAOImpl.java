package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.SupplierDAO;
import lk.ijse.MobileVision.dto.SupplierDto;
import lk.ijse.MobileVision.entity.Supplier;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public List<Supplier> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("select * from supplier");
        List<Supplier> entityList = new ArrayList<>();
        while (resultSet.next()){
            String sup_contact = resultSet.getString(1);
            String sup_name = resultSet.getString(2);
            String sup_address= resultSet.getString(3);
            String sup_id = resultSet.getString(4);

            var dto = new Supplier(sup_contact,sup_name,sup_address,sup_id);
            entityList.add(dto);
        }
        return entityList;
    }

    @Override
    public boolean save(Supplier supplier) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO supplier VALUES(?,?,?,?)",
                supplier.getTel(),
                supplier.getName(),
                supplier.getAddress(),
                supplier.getId());
    }

    @Override
    public boolean update(Supplier supplier) throws SQLException {
        return SQLUtil.crudUtil("UPDATE supplier set sup_name = ?,sup_address = ?, sup_id = ? WHERE sup_contact = ?",
                supplier.getName(),
                supplier.getAddress(),
                supplier.getId(),
                supplier.getTel());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM supplier WHERE sup_contact = ?",id);
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
    public Supplier search(String s) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM supplier WHERE sup_contact = ?",s);
        Supplier entity = null;
        if(resultSet.next()) {
            String sup_tel = resultSet.getString(1);
            String sup_name = resultSet.getString(2);
            String sup_address = resultSet.getString(3);
            String sup_id = resultSet.getString(4);

            entity = new Supplier(sup_tel,sup_name,sup_address,sup_id);
        }

        return entity;
    }
}
