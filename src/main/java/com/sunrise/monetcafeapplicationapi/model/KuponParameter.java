package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kupon_parameter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KuponParameter extends BaseEntity{
    @Column(name = "kahve_parameter")
    private Integer kahveParameter;

    @Column(name = "tatli_parameter")
    private Integer tatliParameter;
}
