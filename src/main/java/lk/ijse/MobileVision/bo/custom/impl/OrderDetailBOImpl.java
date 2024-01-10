package lk.ijse.MobileVision.bo.custom.impl;

import lk.ijse.MobileVision.bo.custom.OrderBO;
import lk.ijse.MobileVision.bo.custom.OrderDetailBO;
import lk.ijse.MobileVision.dao.DAOFactory;
import lk.ijse.MobileVision.dao.custom.OrderDetailDAO;
import lk.ijse.MobileVision.dto.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailBOImpl implements OrderDetailBO {

    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);

    @Override
    public boolean saveOrderDetail(String o_id, CartTm cartTm) throws SQLException {
        return orderDetailDAO.saveOrderDetail(o_id, (List<CartTm>) cartTm);
    }
}
