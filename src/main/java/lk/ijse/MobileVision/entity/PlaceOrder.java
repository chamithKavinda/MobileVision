package lk.ijse.MobileVision.entity;

import lk.ijse.MobileVision.dto.tm.CartTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaceOrder {
    private String o_id;
    private String c_tel;
    private LocalDate date;
    private List<CartTm> tmList=new ArrayList<>();
}
