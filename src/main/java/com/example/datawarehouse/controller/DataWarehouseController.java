package com.example.datawarehouse.controller;

import com.example.datawarehouse.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salesfacts")
public class DataWarehouseController {

    @PostMapping
    public ResponseEntity<?> saveFact(
            @RequestParam(required = false) Long customerID,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String customerCity,
            @RequestParam(required = false) String customerStreet,
            @RequestParam(required = false) Integer customerPLZ,
            @RequestParam(required = false) String customerCountry,

            @RequestParam(required = false) Long productID,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String productCategory,
            @RequestParam(required = false) Double productBuyingPrice,

            @RequestParam(required = false) Long storeID,
            @RequestParam(required = false) String storeCity,
            @RequestParam(required = false) String storeStreet,
            @RequestParam(required = false) String storePLZ,
            @RequestParam(required = false) String storeCountry,

            @RequestParam(required = false) String salesDate,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Double price
    ) {
        Customer customer = new Customer();




        return null;
    }



}