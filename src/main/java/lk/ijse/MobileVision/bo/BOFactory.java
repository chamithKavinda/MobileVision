package lk.ijse.MobileVision.bo;

import lk.ijse.MobileVision.bo.custom.impl.CustomerBOImpl;
import lk.ijse.MobileVision.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory bOFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return (bOFactory==null)?bOFactory=new BOFactory():bOFactory;
    }

    public enum BOTypes{
        CUSTOMER_BO,PLACE_ORDER_BO
    }

    public SuperBO getBO(BOTypes boTypes){
        switch(boTypes){
            case CUSTOMER_BO:
                return new CustomerBOImpl();
            case PLACE_ORDER_BO:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }

}

