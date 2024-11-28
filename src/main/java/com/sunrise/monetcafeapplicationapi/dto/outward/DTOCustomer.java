package com.sunrise.monetcafeapplicationapi.dto.outward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOCustomer {
    private Long id;
    private String name;
    private String phoneNumber;
    private DTOCustomerKupon customerKupon;
}
