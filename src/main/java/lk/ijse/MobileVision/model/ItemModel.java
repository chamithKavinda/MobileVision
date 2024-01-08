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
    ItemDAOImpl itemDAO = new ItemDAOImpl();

    public boolean deleteItem(String id) throws SQLException {
        boolean isDelete = itemDAO.deleteItem(id);
        return isDelete;
    }

    public boolean saveItem(ItemDto dto) throws SQLException {
        boolean isSaved = itemDAO.saveItem(new ItemDto(dto.getId(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
        return isSaved;
    }

    public boolean updateItem(final ItemDto dto) throws SQLException {
       boolean isUpdate = itemDAO.updateItem(new ItemDto(dto.getId(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
       return isUpdate;
    }

    public List<ItemDto> getAllItems() throws SQLException {
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
