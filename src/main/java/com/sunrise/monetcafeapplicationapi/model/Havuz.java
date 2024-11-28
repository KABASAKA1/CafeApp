package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "havuz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Havuz extends BaseEntity {
    @OneToMany
    @JoinTable(name = "havuz_products" ,
            joinColumns = @JoinColumn(name = "havuz_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;
}
