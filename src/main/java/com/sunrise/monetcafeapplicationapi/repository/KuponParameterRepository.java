package com.sunrise.monetcafeapplicationapi.repository;

import com.sunrise.monetcafeapplicationapi.model.KuponParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KuponParameterRepository extends JpaRepository<KuponParameter,Long> {
}
