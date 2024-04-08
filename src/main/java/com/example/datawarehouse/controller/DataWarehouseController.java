package com.example.datawarehouse.controller;

import com.example.datawarehouse.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salesfacts")
public class DataWarehouseController {

    @PostMapping("/save")
    public ResponseEntity<?> saveFact(
            @RequestBody List<SalesFacts> salesFacts
            ) {

        Customer customer = new Customer();
        Product product = new Product();
        SalesDate salesDateObj = new SalesDate();
        Store store = new Store();






        return null;
    }



}