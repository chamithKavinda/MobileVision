package lk.ijse.MobileVision.model;

import lk.ijse.MobileVision.dao.ItemDAOImpl;
import lk.ijse.MobileVision.db.DbConnection;
import lk.ijse.MobileVision.dto.CustomerDto;
import lk.ijse.MobileVision.dto.ItemDto;
import lk.ijse.MobileVision.dto.tm.ItemTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {
    public boolean deleteItem(String id) throws SQLException {
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        boolean isDelete = itemDAO.deleteItem(id);
        return isDelete;
    }

    public boolean saveItem(ItemDto dto) throws SQLException {
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        boolean isSaved = itemDAO.saveItem(new ItemDto(dto.getId(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
        return isSaved;
    }

    public boolean updateItem(final ItemDto dto) throws SQLException {
       ItemDAOImpl itemDAO = new ItemDAOImpl();
       boolean isUpdate = itemDAO.updateItem(new ItemDto(dto.getId(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
       return isUpdate;
    }

    public List<ItemDto> getAllItems() throws SQLException {
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        ArrayList<ItemDto> allItem = (ArrayList<ItemDto>) itemDAO.getAllItems();

        for (ItemDto dto : allItem){
            new ItemTm(
                    dto.getId(),
                    dto.getDescription(),
                    dto.getUnitPrice(),
                    dto.getQtyOnHand()
            );
        }
        return allItem;
    }

    public static ItemDto searchItem(String code) throws SQLException {
        ItemDAOImpl itemDAO  = new ItemDAOImpl();
        ItemDto isSearch = itemDAO.searchItem(code);
        return isSearch;
    }

}
