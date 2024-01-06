package lk.ijse.MobileVision.model;

import lk.ijse.MobileVision.dao.RepairDAOImpl;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.RepairDto;
import lk.ijse.MobileVision.dto.tm.RepairTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairModel {
    public boolean deleteRepair(String id) throws SQLException {
        RepairDAOImpl repairDAO = new RepairDAOImpl();
        boolean isDelete = repairDAO.deleteRepair(id);
        return isDelete;
    }

    public boolean updateRepair(RepairDto dto) throws SQLException {
        RepairDAOImpl repairDAO = new RepairDAOImpl();
        boolean isUpdate = repairDAO.updateRepair(new RepairDto(dto.getR_id(), dto.getE_id(), dto.getDescription(), dto.getPrice(), dto.getDate(), dto.getC_tel()));
        return isUpdate;
    }

    public boolean saveRepair(RepairDto dto) throws SQLException {
        RepairDAOImpl repairDAO = new RepairDAOImpl();
        boolean isSaved = repairDAO.saveRepair(new RepairDto(dto.getR_id(), dto.getE_id(), dto.getDescription(), dto.getPrice(), dto.getDate(), dto.getC_tel()));
        return isSaved;
    }

    public List<RepairDto> getAllRepair() throws SQLException {
        RepairDAOImpl repairDAO = new RepairDAOImpl();
        ArrayList<RepairDto> allRepair = (ArrayList<RepairDto>) repairDAO.getAllRepair();

        for(RepairDto dto : allRepair){
            new RepairTm(
                    dto.getR_id(),
                    dto.getE_id(),
                    dto.getC_tel(),
                    dto.getDescription(),
                    dto.getPrice(),
                    dto.getDate()
            );
        }
        return allRepair;
    }

/*
    public RepairDto searchRepair(String r_id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM repair_details WHERE r_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, r_id);

        ResultSet resultSet = pstm.executeQuery();

        RepairDto dto = null;

        if(resultSet.next()) {
            String r_id = resultSet.getString(1);
            String e_id = resultSet.getString(2);
            String description = resultSet.getString(3);
            String price = resultSet.getString(4);
            String date = resultSet.getString(5);
            String c_tel = resultSet.getString(6);


            dto = new RepairDto(r_id,e_id,description,price,date,c_tel);
        }

        return dto;
    }*/
}
