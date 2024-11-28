package com.sunrise.monetcafeapplicationapi.dto.outward;

import com.sunrise.monetcafeapplicationapi.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOProduct {
    private Long id;
    private String name;
    private String description;
    private Category category;
    private Integer price;
}
