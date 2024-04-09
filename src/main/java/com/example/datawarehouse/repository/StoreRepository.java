package com.example.datawarehouse.repository;

import com.example.datawarehouse.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    public Optional<Store> findByOltpID(Long id);
}
