package com.example.datawarehouse.controller;

import com.example.datawarehouse.domain.*;
import com.example.datawarehouse.service.CustomerService;
import com.example.datawarehouse.service.ProductService;
import com.example.datawarehouse.service.SalesDateService;
import com.example.datawarehouse.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salesfacts")
public class DataWarehouseController {
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final ProductService productService;
    @Autowired
    private final SalesDateService salesDateService;
    @Autowired
    private final StoreService storeService;

    public DataWarehouseController(CustomerService customerService, ProductService productService, SalesDateService salesDateService, StoreService storeService) {
        this.customerService = customerService;
        this.productService = productService;
        this.salesDateService = salesDateService;
        this.storeService = storeService;
    }

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
            @RequestParam(required = false) Integer storePLZ,
            @RequestParam(required = false) String storeCountry,

            @RequestParam(required = false) String salesDate,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Double price
    ) {
        Customer customer = new Customer();
        Product product = new Product();
        SalesDate salesDateObj = new SalesDate();
        Store store = new Store();

        customer.setOltpID(customerID);
        customer.setName(customerName);
        customer.setCity(customerCity);
        customer.setPlz(customerPLZ);
        customer.setStreet(storeStreet);
        customer.setStreet(customerStreet);
        customer.setCountry(customerCountry);

        product.setOltpID(productID);
        product.setName(productName);
        product.setCategory(productCategory);
        product.setBuyingPrice(productBuyingPrice);

        store.setOltpID(storeID);
        store.setCity(storeCity);
        store.setPlz(storePLZ);
        store.setCountry(storeCountry);
        store.setStreet(storeStreet);

        if (storeService.findByOltpId(storeID).isPresent()) {
            store.setId(storeService.findByOltpId(storeID).get().getId());
        }

        storeService.save(store);

        if (productService.findByOltpId(productID).isPresent()) {
            product.setId(productService.findByOltpId(productID).get().getId());
        }

        productService.save(product);




        return null;
    }



}