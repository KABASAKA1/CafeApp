package com.sunrise.monetcafeapplicationapi.repository;

import com.sunrise.monetcafeapplicationapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer ,Long> {
}
