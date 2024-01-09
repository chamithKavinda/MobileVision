package lk.ijse.MobileVision.bo.custom;

import lk.ijse.MobileVision.bo.SuperBO;
import lk.ijse.MobileVision.dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {
    boolean deleteItem(String id) throws SQLException;
    boolean saveItem(ItemDto dto) throws SQLException;
    boolean updateItem(final ItemDto dto) throws SQLException;
    List<ItemDto> getAllItems() throws SQLException;
    ItemDto searchItem(String code) throws SQLException;
}
