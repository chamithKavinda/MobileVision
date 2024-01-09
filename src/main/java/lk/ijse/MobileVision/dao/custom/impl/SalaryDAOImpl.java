package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.SalaryDAO;
import lk.ijse.MobileVision.dto.SalaryDto;
import lk.ijse.MobileVision.entity.Salary;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public List<Salary> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("select * from salary");
        List<Salary> entityList = new ArrayList<>();
        while (resultSet.next()){
            String s_id = resultSet.getString(1);
            String e_id = resultSet.getString(2);
            String month = resultSet.getString(3);
            String amount = resultSet.getString(4);

            var dto = new Salary(s_id,e_id,month,amount);
            entityList.add(dto);
        }
        return entityList;
    }

    @Override
    public boolean save(Salary salary) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO salary VALUES(?,?,?,?)",
                salary.getS_id(),
                salary.getE_id(),
                salary.getMonth(),
                salary.getAmount());
    }

    @Override
    public boolean update(Salary salary) throws SQLException {
        return SQLUtil.crudUtil("UPDATE salary set e_id = ?,sal_month = ?,amount = ? WHERE sal_id = ?",
                salary.getE_id(),
                salary.getMonth(),
                salary.getAmount(),
                salary.getS_id());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM salary WHERE sal_id = ?",id);
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }

    @Override
    public Salary search(String s) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM salary WHERE sal_id = ?",s);
        Salary entity = null;
        if(resultSet.next()) {
            String sal_id = resultSet.getString(1);
            String e_id = resultSet.getString(2);
            String sal_month = resultSet.getString(3);
            String amount = resultSet.getString(4);

            entity = new Salary(sal_id,e_id,sal_month,amount);
        }
        return entity;
    }
}
