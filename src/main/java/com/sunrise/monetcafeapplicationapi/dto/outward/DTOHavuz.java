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
public class DTOHavuz {
    private List<DTOHavuzdakiProduct> havuzdakiProducts = new ArrayList<>();
    private List<DTOHavuzdakiKampanya> havuzdakiKampanyas = new ArrayList<>();
    private List<DTOHavuzdakiKuponProduct> havuzdakiKuponProducts = new ArrayList<>();
}
