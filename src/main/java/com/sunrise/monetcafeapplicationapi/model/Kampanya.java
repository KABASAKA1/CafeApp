package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kampanya")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kampanya extends BaseEntity{
    @Column(nullable = false)
    private String description;

    @OneToMany
    @JoinTable(name = "kampanya_products" ,
            joinColumns = @JoinColumn(name = "kampanya_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private Integer price;

}