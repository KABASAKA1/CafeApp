package com.sunrise.monetcafeapplicationapi.model;

import com.sunrise.monetcafeapplicationapi.enums.Yetki;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity  {
    @Column(name = "phone_number" , length = 30 , nullable = false , unique = true)
    private String phoneNumber;

    @Column(length = 20)
    private String token;

    @Enumerated(EnumType.STRING)
    private Yetki yetki;

    @Column(name = "password" , length = 30)
    private String password;

}
