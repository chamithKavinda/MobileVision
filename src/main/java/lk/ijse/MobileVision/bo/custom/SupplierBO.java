package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {
    boolean deleteSupplier(String tel) throws SQLException;
    boolean saveSupplier(SupplierDto dto) throws SQLException;
    SupplierDto searchSupplier(String tel) throws SQLException;
    boolean updateSupplier(SupplierDto dto) throws SQLException;
    List<SupplierDto> getAllSupplier() throws SQLException;
}
