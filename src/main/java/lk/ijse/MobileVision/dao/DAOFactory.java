package lk.ijse.MobileVision.dao;

import lk.ijse.MobileVision.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,EMPLOYEE,ITEM,ORDER_DETAIL,ORDER,PAYMENT,PLACE_ORDER,REPAIR,SALARY,SUPPLIER
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
            case ORDER:
                new OrderDetailDAOImpl();
            case PAYMENT:
                new PaymentDAOImpl();
            case PLACE_ORDER:
                new PlaceOrderDAOImpl();
            case REPAIR:
                new RepairDAOImpl();
            case SALARY:
                new SalaryDAOImpl();
            case SUPPLIER:
                new SupplierDAOImpl();
            default:
                return null;
        }
    }


}

