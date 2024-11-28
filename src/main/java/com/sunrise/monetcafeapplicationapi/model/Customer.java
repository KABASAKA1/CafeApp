package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

    @Column(name = "first_name" , nullable = false , length = 50)
    private String firstName;

    @Column(name = "last_name" , nullable = false , length = 50)
    private String lastName;

    @Column(name = "phone_number" , nullable = false , length = 11)
    private String phoneNumber;

    @OneToMany
    @JoinTable(name = "customer_products" ,
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Column(name = "sepetteki_kahve")
    private Integer sepettekiKahve;

    @Column(name = "hediye_kahve")
    private Integer hediyeKahve;

    @Column(name = "sepetteki_tatli")
    private Integer sepettekiTatli;

    @Column(name = "hediye_tatli")
    private Integer hediyeTatli;

}
