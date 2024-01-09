package lk.ijse.MobileVision.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    private String p_id;
    private String c_tel;
    private String o_id;
    private String date;
    private String description;
    private String amount;
}
