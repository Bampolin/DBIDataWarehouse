package com.example.datawarehouse.service;

import com.example.datawarehouse.domain.Store;
import com.example.datawarehouse.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void save(Store store) {
        storeRepository.save(store);
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}
