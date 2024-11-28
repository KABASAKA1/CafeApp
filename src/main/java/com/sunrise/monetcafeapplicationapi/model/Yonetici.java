package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "yonetici")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Yonetici extends BaseEntity {

    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

}
