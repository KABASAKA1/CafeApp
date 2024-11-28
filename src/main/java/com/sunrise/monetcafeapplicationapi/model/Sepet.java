package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sepet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sepet extends BaseEntity {
    @OneToMany
    @JoinTable(name = "sepet_products" ,
    joinColumns = @JoinColumn(name = "sepet_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @OneToOne
    private Customer customer;

    private Integer price;
}
