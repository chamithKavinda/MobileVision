package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
    boolean deleteItem(String id) throws SQLException;
    boolean saveItem(ItemDto dto) throws SQLException;
    boolean updateItem(final ItemDto dto) throws SQLException;
    List<ItemDto> getAllItems() throws SQLException;
    ItemDto searchItem(String code) throws SQLException;
}
