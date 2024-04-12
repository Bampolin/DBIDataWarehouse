package com.example.datawarehouse.repository;

import com.example.datawarehouse.domain.SalesFacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesFactsRepository extends JpaRepository<SalesFacts, Long> {
}
