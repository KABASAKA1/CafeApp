package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sepet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sepet extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "total_price")
    private Integer totalPrice;

    @OneToMany(mappedBy = "sepet" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<SepettekiProduct> sepettekiProducts = new ArrayList<>();

    @OneToMany(mappedBy = "sepet" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<SepettekiKampanya> sepettekiKampanyas = new ArrayList<>();

    @OneToMany(mappedBy = "sepet" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<SepettekiKuponProduct> sepettekiKuponProducts = new ArrayList<>();
}
