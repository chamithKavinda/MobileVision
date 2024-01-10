package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.RepairDto;

import java.sql.SQLException;
import java.util.List;

public interface RepairBO extends SuperBO {
    boolean deleteRepair(String id) throws SQLException;
    boolean updateRepair(RepairDto dto) throws SQLException;
    boolean saveRepair(RepairDto dto) throws SQLException;
    List<RepairDto> getAllRepair() throws SQLException;

}
