package lk.ijse.MobileVision.bo;

import lk.ijse.MobileVision.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory bOFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return (bOFactory==null)?bOFactory=new BOFactory():bOFactory;
    }

    public enum BOTypes{
        CUSTOMER_BO,PLACE_ORDER_BO,EMPLOYEE_BO,ITEM_BO,PAYMENT_BO,REPAIR_BO,SALARY_BO
    }

    public SuperBO getBO(BOTypes boTypes){
        switch(boTypes){
            case CUSTOMER_BO:
                return new CustomerBOImpl();
            case PLACE_ORDER_BO:
                return new PlaceOrderBOImpl();
            case EMPLOYEE_BO:
                return new EmployeeBOImpl();
            case ITEM_BO:
                return new ItemBOImpl();
            case PAYMENT_BO:
                return new PaymentBOImpl();
            case REPAIR_BO:
                return new RepairBOImpl();
            case SALARY_BO:
                return new SalaryBOImpl();
            default:
                return null;
        }
    }

}

