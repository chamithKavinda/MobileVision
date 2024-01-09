package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        CUSTOMERS,EMPLOYEE,ITEM,ORDER_DETAIL,ORDER,PAYMENT,REPAIR,SALARY,SUPPLIER,USER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMERS:
                return  new CustomerDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case ITEM:
               return new ItemDAOImpl();
            case ORDER_DETAIL:
               return new OrderDetailDAOImpl();
            case ORDER:
                return new OrderDetailDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case REPAIR:
               return new RepairDAOImpl();
            case SALARY:
                return new SalaryDAOImpl();
            case SUPPLIER:
               return new SupplierDAOImpl();
            case USER:
               return new UserDAOImpl();
            default:
                return null;
        }
    }
}
