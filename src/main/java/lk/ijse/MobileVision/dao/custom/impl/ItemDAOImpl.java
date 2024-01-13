package lk.ijse.MobileVision.dao.custom.impl;

import lk.ijse.MobileVision.dao.custom.ItemDAO;
import lk.ijse.MobileVision.dto.ItemDto;
import lk.ijse.MobileVision.dto.tm.CartTm;
import lk.ijse.MobileVision.entity.Employee;
import lk.ijse.MobileVision.entity.Item;
import lk.ijse.MobileVision.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public List<Item> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("select * from item");
        List<Item> entityList = new ArrayList<>();
        while (resultSet.next()){
            String i_id = resultSet.getString(1);
            String i_description = resultSet.getString(2);
            String i_unit_price  = resultSet.getString(3);
            String qty_on_hand = resultSet.getString(4);

            var dto = new Item(i_id,i_description,i_unit_price,qty_on_hand);
            entityList.add(dto);
        }
        return entityList;
    }

    @Override
    public boolean save(Item item) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO item VALUES(?,?,?,?)",
                item.getId(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand());
    }

    @Override
    public boolean update(Item item) throws SQLException {
        return SQLUtil.crudUtil("UPDATE item set i_description = ?,i_unit_price = ?,i_qty_on_hand = ? WHERE i_code = ?",
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand(),
                item.getId());
    }

    public boolean update(List<CartTm> tm) throws SQLException {

        for (CartTm cartTm : tm) {
            if(!updateQty(cartTm)) {
                return false;
            }
        }
        return true;
    }

    private boolean updateQty(CartTm cartTm) throws SQLException {
        return SQLUtil.crudUtil("UPDATE item SET i_qty_on_hand = i_qty_on_hand - ? WHERE i_code = ?",cartTm.getQty(),cartTm.getCode());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM item WHERE i_code = ?",id);
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
    public Item search(String s) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("select * from item where i_code =  ?",s);
        Item entity = null;

        while(resultSet.next()){
            String i_id = resultSet.getString(1);
            String i_description = resultSet.getString(2);
            String i_unit_price = resultSet.getString(3);
            String i_qty_on_hand = resultSet.getString(4);

            entity = new Item(i_id,i_description,i_unit_price,i_qty_on_hand);
        }
        return entity;
    }
}
