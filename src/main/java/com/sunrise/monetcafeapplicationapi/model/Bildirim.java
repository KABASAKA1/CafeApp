package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bildirim")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bildirim extends BaseEntity {

    private String title;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "bildirim_gecmisi_id")
    private BildirimGecmisi bildirimGecmisi;

}
