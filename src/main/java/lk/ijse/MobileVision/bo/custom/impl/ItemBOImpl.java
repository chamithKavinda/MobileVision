package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.BOFactory;
import lk.ijse.MobileVision.bo.custom.ItemBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.ItemDAO;
import lk.ijse.MobileVision.dto.ItemDto;
import lk.ijse.MobileVision.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean deleteItem(String id) throws SQLException {
        return itemDAO.delete(id);
    }

    @Override
    public boolean saveItem(ItemDto dto) throws SQLException {
        return itemDAO.save(new Item(
                dto.getId(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()));
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException {
        return itemDAO.update(new Item(
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand(),
                dto.getId()));
    }

    @Override
    public List<ItemDto> getAllItems() throws SQLException {
        List<Item> entityList = itemDAO.getAll();
        List<ItemDto> dtoList = new ArrayList<>();

        for(Item item : entityList){
            dtoList.add(new ItemDto(
                    item.getId(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand()));
        }
        return dtoList;
    }

    @Override
    public ItemDto searchItem(String code) throws SQLException {
        Item item = itemDAO.search(code);
        return new ItemDto(
                item.getId(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand());
    }
}
