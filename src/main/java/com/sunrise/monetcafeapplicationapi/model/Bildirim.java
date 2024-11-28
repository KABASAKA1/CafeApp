package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @Column(nullable = false)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

}
