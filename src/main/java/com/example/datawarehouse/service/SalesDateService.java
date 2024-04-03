package com.example.datawarehouse.service;

import com.example.datawarehouse.domain.SalesDate;
import com.example.datawarehouse.repository.SalesDateRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.util.List;

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



}
