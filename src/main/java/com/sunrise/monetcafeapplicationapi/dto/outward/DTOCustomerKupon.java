package com.sunrise.monetcafeapplicationapi.dto.outward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOCustomerKupon {
    private Integer kahveCekirdek;
    private Integer kuponKahve;
    private Integer tatliDilim;
    private Integer kuponTatli;
}
