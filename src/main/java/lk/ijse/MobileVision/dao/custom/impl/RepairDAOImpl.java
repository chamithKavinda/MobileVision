package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.RepairDAO;
import lk.ijse.MobileVision.dto.RepairDto;
import lk.ijse.MobileVision.entity.Repair;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairDAOImpl implements RepairDAO {
    @Override
    public List<Repair> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("select * from repair_details");
        List<Repair> entityList = new ArrayList<>();
        while (resultSet.next()){
            String r_id = resultSet.getString(1);
            String e_id = resultSet.getString(2);
            String c_tel = resultSet.getString(3);
            String description = resultSet.getString(4);
            String price = resultSet.getString(5);
            String date = resultSet.getString(6);

            var dto = new Repair(r_id,e_id,c_tel,description,price,date);
            entityList.add(dto);
        }
        return entityList;
    }

    @Override
    public boolean save(Repair repair) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO repair_details VALUES(?,?,?,?,?,?)",
                repair.getR_id(),
                repair.getE_id(),
                repair.getDescription(),
                repair.getPrice(),
                repair.getDate(),
                repair.getC_tel());
    }

    @Override
    public boolean update(Repair repair) throws SQLException {
        return SQLUtil.crudUtil("UPDATE repair_details set e_id = ?,r_description = ? ,r_price = ?,r_date = ?, c_contact = ?  WHERE r_id = ?",
                repair.getE_id(),
                repair.getDescription(),
                repair.getPrice(),
                repair.getDate(),
                repair.getC_tel(),
                repair.getR_id());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM repair_details WHERE r_id = ?",id);
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
    public Repair search(String s) throws SQLException {
        return null;
    }
}
