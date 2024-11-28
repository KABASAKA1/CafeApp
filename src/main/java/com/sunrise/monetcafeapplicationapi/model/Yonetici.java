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

    @Column(name = "first_name" , nullable = false , length = 50)
    private String firstName;

    @Column(name = "last_name" , nullable = false , length = 50)
    private String lastName;

    @Column(name = "phone_number" , nullable = false , length = 11)
    private String phoneNumber;

}
