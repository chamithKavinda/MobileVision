package lk.ijse.MobileVision.entity;

public class Customer {
    private String tel;
    private String name;
    private String address;
    private String id;

    public Customer(String tel,String name,String address,String id){
        this.tel = tel;
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public Customer(){}

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
