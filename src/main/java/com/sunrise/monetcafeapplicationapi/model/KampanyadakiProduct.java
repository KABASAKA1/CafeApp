package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kampanyadaki_product")
public class KampanyadakiProduct extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "kampanya_id")
    private Kampanya kampanya;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer price;
    private Integer adet;
}
