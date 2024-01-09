package lk.ijse.MobileVision.bo;

import lk.ijse.MobileVision.bo.custom.impl.CustomerBOImpl;

public class BOFactory {
    private static BOFactory bOFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return (bOFactory==null)?bOFactory=new BOFactory():bOFactory;
    }

    public enum BOTypes{
        CUSTOMER_BO
    }

    public SuperBO getBO(BOTypes boTypes){
        switch(boTypes){
            case CUSTOMER_BO:
                return new CustomerBOImpl();
            default:
                return null;
        }
    }

}

