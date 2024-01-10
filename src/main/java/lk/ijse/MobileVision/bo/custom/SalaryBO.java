package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.SalaryDto;

import java.sql.SQLException;
import java.util.List;

public interface SalaryBO extends SuperBO {
    boolean deleteSalary(String s_id) throws SQLException;
    boolean saveSalary(SalaryDto dto) throws SQLException;
    boolean updateSalary(SalaryDto dto) throws SQLException;
    SalaryDto searchSalary(String s_id) throws SQLException;
    List<SalaryDto> getAllSalary() throws SQLException;
}
