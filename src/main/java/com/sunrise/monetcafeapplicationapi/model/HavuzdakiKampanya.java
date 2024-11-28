package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "havuzdaki_kampanya")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HavuzdakiKampanya extends BaseEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kampanya_id")
    private Kampanya kampanya;

    @ManyToOne
    @JoinColumn(name = "havuz_id")
    private Havuz havuz;

    private Integer adet;
    private Integer price;
}
