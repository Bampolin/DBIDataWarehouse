package com.example.datawarehouse.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long oltpID;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private Integer plz;

    @Column
    private String country;

    @Column
    private Date dateOfBirth;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<SalesFacts> salesFactses = new LinkedHashSet<>();
}