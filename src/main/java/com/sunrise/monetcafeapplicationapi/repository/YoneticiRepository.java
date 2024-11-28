package com.sunrise.monetcafeapplicationapi.repository;

import com.sunrise.monetcafeapplicationapi.model.Yonetici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YoneticiRepository extends JpaRepository<Yonetici,Long> {
}
