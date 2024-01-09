package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.MobileVision.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.MobileVision.dao.custom.impl.ItemDAOImpl;
import lk.ijse.MobileVision.dao.custom.impl.OrderDetailDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,EMPLOYEE,ITEM,ORDER_DETAIL
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMER:
                new CustomerDAOImpl();
            case EMPLOYEE:
                new EmployeeDAOImpl();
            case ITEM:
                new ItemDAOImpl();
            case ORDER_DETAIL:
                new OrderDetailDAOImpl();
            default:
                return null;
        }
    }


}

