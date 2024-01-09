package lk.ijse.MobileVision.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Repair {
    private String r_id;
    private String e_id;
    private String description;
    private String price;
    private String date;
    private String c_tel;
}
