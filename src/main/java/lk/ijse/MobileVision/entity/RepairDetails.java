package lk.ijse.MobileVision.entity;

public class RepairDetails {
    private String r_id;
    private String e_id;
    private String description;
    private String price;
    private String date;
    private String c_tel;

    public RepairDetails(String r_id,String e_id,String description,String price,String date,String c_tel){
        this.r_id = r_id;
        this.e_id = e_id;
        this.description = description;
        this.price = price;
        this.date = date;
        this.c_tel = c_tel;
    }

    public RepairDetails(){}

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getC_tel() {
        return c_tel;
    }

    public void setC_tel(String c_tel) {
        this.c_tel = c_tel;
    }
}
