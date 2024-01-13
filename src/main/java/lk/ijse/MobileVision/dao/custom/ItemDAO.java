package lk.ijse.MobileVision.dao.custom;

import lk.ijse.MobileVision.dao.CrudDAO;
import lk.ijse.MobileVision.dto.tm.CartTm;
import lk.ijse.MobileVision.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {
    boolean update(List<CartTm> tmList) throws SQLException;
}
