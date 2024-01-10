package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.RepairBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.RepairDAO;
import lk.ijse.MobileVision.dto.RepairDto;
import lk.ijse.MobileVision.entity.Repair;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairBOImpl implements RepairBO {

    RepairDAO repairDAO = (RepairDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REPAIR);

    @Override
    public boolean deleteRepair(String id) throws SQLException {
        return repairDAO.delete(id);
    }

    @Override
    public boolean updateRepair(RepairDto dto) throws SQLException {
        return repairDAO.update(new Repair(
                dto.getR_id(),
                dto.getE_id(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getDate(),
                dto.getC_tel()));
    }

    @Override
    public boolean saveRepair(RepairDto dto) throws SQLException {
        return repairDAO.save(new Repair(
                dto.getR_id(),
                dto.getE_id(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getDate(),
                dto.getC_tel()));
    }

    @Override
    public List<RepairDto> getAllRepair() throws SQLException {
        List<Repair> entityList = repairDAO.getAll();
        List<RepairDto> dtoList = new ArrayList<>();

        for (Repair repair:entityList){
            dtoList.add(new RepairDto(
                    repair.getR_id(),
                    repair.getE_id(),
                    repair.getC_tel(),
                    repair.getDescription(),
                    repair.getPrice(),
                    repair.getDate()));
        }
        return dtoList;
    }
}
