package lk.ijse.MobileVision.model;

import lk.ijse.MobileVision.dao.SalaryDAO;
import lk.ijse.MobileVision.dao.SalaryDAOImpl;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.ItemDto;
import lk.ijse.MobileVision.dto.SalaryDto;
import lk.ijse.MobileVision.dto.tm.SalaryTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryModel {

    public boolean deleteSalary(String s_id) throws SQLException {
        SalaryDAOImpl salaryDAO = new SalaryDAOImpl();
        boolean isDelete = salaryDAO.deleteSalary(s_id);
        return isDelete;
    }

    public boolean saveSalary(SalaryDto dto) throws SQLException {
        SalaryDAOImpl salaryDAO = new SalaryDAOImpl();
        boolean isSaved = salaryDAO.saveSalary(new SalaryDto(dto.getS_id(), dto.getE_id(), dto.getMonth(), dto.getAmount()));
        return isSaved;
    }

    public boolean updateSalary(SalaryDto dto) throws SQLException {
        SalaryDAOImpl salaryDAO = new SalaryDAOImpl();
        boolean isUpdate = salaryDAO.updateSalary(new SalaryDto(dto.getS_id(), dto.getE_id(), dto.getMonth(), dto.getAmount()));
        return isUpdate;
    }


    public SalaryDto searchSalary(String s_id) throws SQLException {
        SalaryDAOImpl salaryDAO = new SalaryDAOImpl();
        SalaryDto isSearch = salaryDAO.searchSalary(s_id);
        return isSearch;
    }

    public List<SalaryDto> getAllSalary() throws SQLException {
        SalaryDAOImpl salaryDAO = new SalaryDAOImpl();
        ArrayList<SalaryDto> allSalary = (ArrayList<SalaryDto>) salaryDAO.getAllSalary();

        for(SalaryDto dto : allSalary ){
            new SalaryTm(
                    dto.getS_id(),
                    dto.getE_id(),
                    dto.getMonth(),
                    dto.getAmount()
            );
        }
        return allSalary;
    }
}
