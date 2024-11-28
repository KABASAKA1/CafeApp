package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sepetteki_kupon_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SepettekiKuponProduct extends BaseEntity{
    @ManyToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "sepet_id")
    private Sepet sepet;

    private Integer adet;
}
