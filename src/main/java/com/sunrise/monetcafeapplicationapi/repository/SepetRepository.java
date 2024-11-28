package com.sunrise.monetcafeapplicationapi.repository;

import com.sunrise.monetcafeapplicationapi.model.Sepet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SepetRepository extends JpaRepository<Sepet,Long> {
}
