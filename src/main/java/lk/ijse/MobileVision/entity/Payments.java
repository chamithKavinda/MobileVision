package lk.ijse.MobileVision.entity;

public class Payments {
    private String p_id;
    private String c_tel;
    private String o_id;
    private String date;
    private String description;
    private String amount;

    public Payments(String p_id,String c_tel,String o_id,String date,String description,String amount){
        this.p_id = p_id;
        this.c_tel = c_tel;
        this.o_id = o_id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public Payments(){}

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getC_tel() {
        return c_tel;
    }

    public void setC_tel(String c_tel) {
        this.c_tel = c_tel;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
