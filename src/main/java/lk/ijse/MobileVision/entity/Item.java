package lk.ijse.MobileVision.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private String id;
    private String description;
    private String unitPrice;
    private String qtyOnHand;
}
