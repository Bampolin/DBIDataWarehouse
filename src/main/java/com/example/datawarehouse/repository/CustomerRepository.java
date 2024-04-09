package com.example.datawarehouse.repository;

import com.example.datawarehouse.domain.Customer;
import com.example.datawarehouse.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Optional<Customer> findByOltpID(Long id);
}