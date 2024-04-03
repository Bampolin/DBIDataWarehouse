package com.example.datawarehouse.repository;

import com.example.datawarehouse.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
