package com.sunrise.monetcafeapplicationapi.dto.outward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOSepettekiProduct {
    private Long id;
    private DTOProduct product;
    private Integer adet;
    private Integer price;
}
