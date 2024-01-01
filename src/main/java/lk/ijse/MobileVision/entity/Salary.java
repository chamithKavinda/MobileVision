package lk.ijse.MobileVision.entity;

public class Salary {
    private String s_id;
    private String e_id;
    private String month;
    private String amount;

    public Salary(String s_id,String e_id,String month,String amount){
        this.s_id = s_id;
        this.e_id = e_id;
        this.month = month;
        this.amount = amount;
    }

    public Salary(){}

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
