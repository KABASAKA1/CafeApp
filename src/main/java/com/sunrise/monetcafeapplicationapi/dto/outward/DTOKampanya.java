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
public class DTOKampanya {
    private Long id;
    private String title;
    private String description;
    private List<DTOKampanyadakiProduct> kampanyadakiProducts = new ArrayList<>();
    private Integer price;
}
