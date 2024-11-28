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
public class DTOKampanyaIU {
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private List<DTOKampanyadakiProductIU> kampanyadakiProducts = new ArrayList<>();
}
