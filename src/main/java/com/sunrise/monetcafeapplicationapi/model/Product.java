package com.sunrise.monetcafeapplicationapi.model;

import com.sunrise.monetcafeapplicationapi.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer price;

    @Column(name = "image_url")
    private String imageUrl;
}
