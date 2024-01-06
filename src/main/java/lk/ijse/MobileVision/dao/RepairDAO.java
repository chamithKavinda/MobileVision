package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dto.RepairDto;

import java.sql.SQLException;
import java.util.List;

public interface RepairDAO {
    boolean deleteRepair(String id) throws SQLException;
    boolean updateRepair(RepairDto dto) throws SQLException;
    boolean saveRepair(RepairDto dto) throws SQLException;
    List<RepairDto> getAllRepair() throws SQLException;
}
