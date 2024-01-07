package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO {
    boolean deleteSupplier(String tel) throws SQLException;
    boolean saveSupplier(SupplierDto dto) throws SQLException;
    SupplierDto searchSupplier(String tel) throws SQLException;
    boolean updateSupplier(SupplierDto dto) throws SQLException;
    List<SupplierDto> getAllSupplier() throws SQLException;
}
