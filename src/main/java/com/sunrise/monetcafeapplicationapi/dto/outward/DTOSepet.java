package com.sunrise.monetcafeapplicationapi.dto.outward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOSepet {
    private Long id;
    private Integer totalPrice;
    private List<DTOSepettekiProduct> sepettekiProducts = new ArrayList<>();
    private List<DTOSepettekiKampanya> sepettekiKampanyas = new ArrayList<>();
    private List<DTOSepettekiKuponProduct> sepettekiKuponProducts = new ArrayList<>();
}
