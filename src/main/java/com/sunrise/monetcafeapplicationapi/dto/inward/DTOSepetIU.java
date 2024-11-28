package com.sunrise.monetcafeapplicationapi.dto.inward;

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
public class DTOSepetIU {
    List<DTOSepettekiProductIU> sepettekiProducts = new ArrayList<>();
    List<DTOSepettekiKampanyaIU> sepettekiKampanyas = new ArrayList<>();
    List<DTOSepettekiKuponProductIU> sepettekiKuponProducts = new ArrayList<>();
}
