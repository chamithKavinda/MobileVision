package lk.ijse.MobileVision.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private String tel;
    private String name;
    private String address;
    private String id;
}
