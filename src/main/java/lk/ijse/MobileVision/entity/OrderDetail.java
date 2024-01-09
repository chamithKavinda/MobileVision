package lk.ijse.MobileVision.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetail {
    private String o_id;
    private String i_code;
    private String qty;
    private String unit_price;
}
