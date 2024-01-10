package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.SalaryBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.SalaryDAO;
import lk.ijse.MobileVision.dto.SalaryDto;
import lk.ijse.MobileVision.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryBOImpl implements SalaryBO {

    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SALARY);

    @Override
    public boolean deleteSalary(String s_id) throws SQLException {
        return salaryDAO.delete(s_id);
    }

    @Override
    public boolean saveSalary(SalaryDto dto) throws SQLException {
        return salaryDAO.save(new Salary(
                dto.getS_id(),
                dto.getE_id(),
                dto.getMonth(),
                dto.getAmount()));
    }

    @Override
    public boolean updateSalary(SalaryDto dto) throws SQLException {
        return salaryDAO.update(new Salary(
                dto.getS_id(),
                dto.getE_id(),
                dto.getMonth(),
                dto.getAmount()));
    }

    @Override
    public SalaryDto searchSalary(String s_id) throws SQLException {
        Salary salary = salaryDAO.search(s_id);
        return new SalaryDto(salary.getS_id(),salary.getE_id(),salary.getMonth(),salary.getAmount());
    }

    @Override
    public List<SalaryDto> getAllSalary() throws SQLException {
        List<Salary> entityList = salaryDAO.getAll();
        List<SalaryDto> dtoList = new ArrayList<>();

        for (Salary salary:entityList){
            dtoList.add(new SalaryDto(
               salary.getS_id(),
               salary.getE_id(),
               salary.getMonth(),
               salary.getAmount()));
        }
        return dtoList;
    }
}
