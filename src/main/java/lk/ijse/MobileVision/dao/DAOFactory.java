package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dao.custom.impl.CustomerDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMER:
                new CustomerDAOImpl();
            default:
                return null;
        }
    }


}

