package com.example.datawarehouse.service;

import com.example.datawarehouse.domain.SalesDate;
import com.example.datawarehouse.repository.SalesDateRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SalesDateService {

    private final SalesDateRepository salesDateRepository;

    public SalesDateService(SalesDateRepository salesDateRepository) {
        this.salesDateRepository = salesDateRepository;
    }

    public List<SalesDate> getAll(){
        return salesDateRepository.findAll();
    }

    public void save(SalesDate salesDate){
        salesDateRepository.save(salesDate);
    }

    public Optional<SalesDate> findByDate(Date date) {
        return salesDateRepository.findByDate(date);
    }

}
