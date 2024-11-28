package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "havuz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Havuz extends BaseEntity {
    @OneToMany(mappedBy = "havuz" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    List<HavuzdakiProduct> havuzdakiProducts = new ArrayList<>();

    @OneToMany(mappedBy = "havuz" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    List<HavuzdakiKampanya> havuzdakiKampanyas = new ArrayList<>();

    @OneToMany(mappedBy = "havuz" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    List<HavuzdakiKuponProduct> havuzdakiKuponProducts = new ArrayList<>();
}
