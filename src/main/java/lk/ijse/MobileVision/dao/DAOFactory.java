package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.MobileVision.dao.custom.impl.EmployeeDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,EMPLOYEE
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMER:
                new CustomerDAOImpl();
            case EMPLOYEE:
                new EmployeeDAOImpl();
            default:
                return null;
        }
    }


}

