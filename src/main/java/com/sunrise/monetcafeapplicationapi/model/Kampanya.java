package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kampanya")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kampanya extends BaseEntity{
    private String title;

    private String description;

    @OneToMany(mappedBy = "kampanya" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<KampanyadakiProduct> kampanyadakiProducts = new ArrayList<>();

    @Column(name = "image_url")
    private String imageUrl;

    private Integer price;

}