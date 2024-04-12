package com.example.datawarehouse.service;

import com.example.datawarehouse.domain.SalesFacts;
import com.example.datawarehouse.repository.SalesFactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesFactsService {
    @Autowired
    private final SalesFactsRepository salesFactsRepository;

    @Autowired
    public SalesFactsService(SalesFactsRepository salesFactsRepository) {
        this.salesFactsRepository = salesFactsRepository;
    }

    public List<SalesFacts> findAll() {
        return salesFactsRepository.findAll();
    }

    public void save(SalesFacts salesFacts) {
        salesFactsRepository.save(salesFacts);
    }

}
