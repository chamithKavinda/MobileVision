package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.SupplierBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.SupplierDAO;
import lk.ijse.MobileVision.dto.SupplierDto;
import lk.ijse.MobileVision.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean deleteSupplier(String tel) throws SQLException {
        return supplierDAO.delete(tel);
    }

    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.save(new Supplier(
                dto.getTel(),
                dto.getName(),
                dto.getAddress(),
                dto.getId()));
    }

    @Override
    public SupplierDto searchSupplier(String tel) throws SQLException {
        Supplier supplier = supplierDAO.search(tel);
        return new SupplierDto(supplier.getTel(),supplier.getName(),supplier.getAddress(),supplier.getId());
    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.update(new Supplier(
                dto.getTel(),
                dto.getName(),
                dto.getAddress(),
                dto.getId()));
    }

    @Override
    public List<SupplierDto> getAllSupplier() throws SQLException {
        List<Supplier> entityList = supplierDAO.getAll();
        List<SupplierDto> dtoList = new ArrayList<>();

        for (Supplier supplier:entityList){
            dtoList.add(new SupplierDto(
                    supplier.getTel(),
                    supplier.getName(),
                    supplier.getAddress(),
                    supplier.getId()));
        }
        return dtoList;
    }
}
