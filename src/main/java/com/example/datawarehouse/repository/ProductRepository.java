package com.example.datawarehouse.repository;

import com.example.datawarehouse.domain.Customer;
import com.example.datawarehouse.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Optional<Product> findByOltpID(Long id);
}
