package com.sunrise.monetcafeapplicationapi.repository;

import com.sunrise.monetcafeapplicationapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer ,Long> {
    @Query("select c.phoneNumber from Customer c where c.id = :id")
    Optional<String> findPhoneNumberById(@Param("id") Long id);
}
