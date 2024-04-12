package com.example.datawarehouse.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SalesDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private Integer quartal;

    @Column
    private Integer dayOfWeek;

    @Column
    private Integer monthNumber;

    @OneToMany(mappedBy = "salesDate", orphanRemoval = true)
    private Set<SalesFacts> salesFactses = new LinkedHashSet<>();

    public void setDate(Date date) {
        this.date = date;
        updateDateDetails();
    }

    private void updateDateDetails() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.date);

        this.monthNumber = cal.get(Calendar.MONTH) + 1; // Januar = 0, deshalb +1
        this.dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        this.quartal = (cal.get(Calendar.MONTH) / 3) + 1;
    }
}