package lk.ijse.MobileVision.entity;

import java.time.LocalDate;

public class PlaceOrder {
    private String o_id;
    private String c_tel;
    private LocalDate date;

    public PlaceOrder(String o_id,String c_tel,LocalDate date){
        this.o_id = o_id;
        this.c_tel = c_tel;
        this.date = date;
    }

    public PlaceOrder(){}

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getC_tel() {
        return c_tel;
    }

    public void setC_tel(String c_tel) {
        this.c_tel = c_tel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
