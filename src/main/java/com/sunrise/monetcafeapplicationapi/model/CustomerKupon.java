package com.sunrise.monetcafeapplicationapi.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "customer_kupon")
public class CustomerKupon extends BaseEntity{

    @Column(name = "kahve_cekirdek")
    private Integer kahveCekirdek;
    @Column(name = "kupon_kahve")
    private Integer kuponKahve;
    @Column(name = "tatli_dilim")
    private Integer tatliDilim;
    @Column(name = "kupon_tatli")
    private Integer kuponTatli;

}
