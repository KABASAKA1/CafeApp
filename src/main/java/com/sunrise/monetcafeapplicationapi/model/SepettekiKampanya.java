package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sepetteki_kampanya")
public class SepettekiKampanya extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "sepet_id")
    private Sepet sepet;

    @ManyToOne
    @JoinColumn(name = "kampanya_id")
    private Kampanya kampanya;

    private Integer adet;
    private Integer price;

}
