package lk.ijse.MobileVision.model;

import lk.ijse.MobileVision.dao.SupplierDAOImpl;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.SupplierDto;
import lk.ijse.MobileVision.dto.tm.SupplierTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierModel {
    public boolean deleteSupplier(String tel) throws SQLException {
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        boolean isDelete = supplierDAO.deleteSupplier(tel);
        return isDelete;
    }

    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        boolean isSaved = supplierDAO.saveSupplier(new SupplierDto(dto.getTel(),dto.getName(),dto.getAddress(),dto.getId()));
        return isSaved;
    }

    public SupplierDto searchSupplier(String tel) throws SQLException {
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        SupplierDto isSearch = supplierDAO.searchSupplier(tel);
        return isSearch;
    }

    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        boolean isUpdate = supplierDAO.updateSupplier(new SupplierDto(dto.getTel(),dto.getName(),dto.getAddress(),dto.getId()));
        return isUpdate;
    }

    public List<SupplierDto> getAllSupplier() throws SQLException {
        SupplierDAOImpl supplierDAO = new SupplierDAOImpl();
        ArrayList<SupplierDto> allSupplier = (ArrayList<SupplierDto>) supplierDAO.getAllSupplier();

        for(SupplierDto dto : allSupplier){
            new SupplierTm(
                    dto.getTel(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getId()
            );
        }
        return allSupplier;
    }
}
