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
public class SalesDate {
    @Id
    private Date date;

    @Column
    private Integer quartal;

    @Column
    private Integer dayOfWeek;

    @Column
    private Integer month;

    @OneToMany(mappedBy = "salesDate", orphanRemoval = true)
    private Set<SalesFacts> salesFactses = new LinkedHashSet<>();

}