package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dto.SalaryDto;

import java.sql.SQLException;
import java.util.List;

public interface SalaryDAO {
    boolean deleteSalary(String s_id) throws SQLException;
    boolean saveSalary(SalaryDto dto) throws SQLException;
    boolean updateSalary(SalaryDto dto) throws SQLException;
    SalaryDto searchSalary(String s_id) throws SQLException;
    List<SalaryDto> getAllSalary() throws SQLException;
}
