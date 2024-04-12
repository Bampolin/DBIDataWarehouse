package com.example.datawarehouse.controller;

import com.example.datawarehouse.domain.*;
import com.example.datawarehouse.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
    @Autowired
    private final SalesFactsService salesFactsService;

    public DataWarehouseController(CustomerService customerService, ProductService productService, SalesDateService salesDateService, StoreService storeService, SalesFactsService salesFactsService) {
        this.customerService = customerService;
        this.productService = productService;
        this.salesDateService = salesDateService;
        this.storeService = storeService;
        this.salesFactsService = salesFactsService;
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
    ) throws ParseException {
        System.out.println("\n\n\n\n\n\n\n\n\n\n------------------------------------------------------------\n\n\n\n\n\n\n\n\n\n");

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

        System.out.println("Daten gesetzt");

        if (storeService.findByOltpId(storeID).isPresent()) {
            store.setId(storeService.findByOltpId(storeID).get().getId());
        }

        storeService.save(store);


        System.out.println("Store Saved");

        if (productService.findByOltpId(productID).isPresent()) {
            product.setId(productService.findByOltpId(productID).get().getId());
        }

        productService.save(product);

        System.out.println("Product Saved");

        if (customerService.findByOltpId(customerID).isPresent()) {
            customer.setId(customerService.findByOltpId(customerID).get().getId());
        }

        customerService.saveCustomer(customer);

        System.out.println("Customer Saved");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        salesDateObj.setDate(formatter.parse(salesDate));


        System.out.println("Datum:");
        System.out.println(salesDateObj.getDate());
        System.out.println("-------------------------------------------");
        salesDateService.save(salesDateObj);

        SalesFacts salesFacts = new SalesFacts();

        salesFacts.setQuantity(quantity);
        salesFacts.setSalesPrice(price);

        salesFacts.setCustomer(customerService.findByOltpId(customerID).get());
        salesFacts.setProduct(productService.findByOltpId(productID).get());
        salesFacts.setStore(storeService.findByOltpId(storeID).get());
        salesFacts.setSalesDate(salesDateObj);

        salesFactsService.save(salesFacts);






        return null;
    }

    @GetMapping("/all")
    public List<SalesFacts> getAll() {
        return salesFactsService.findAll();
    }
}