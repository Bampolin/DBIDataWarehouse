package com.example.datawarehouse.repository;

import com.example.datawarehouse.domain.SalesDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDateRepository extends JpaRepository<SalesDate, Long> {
}
