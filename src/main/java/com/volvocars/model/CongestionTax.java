package com.volvocars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CongestionTax {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String startTime;

    @Column(nullable = false)
    String endTime;

    @Column(nullable = false)
    double amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    City city;

    public CongestionTax(String startTime, String endTime, double amount, City city) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
        this.city = city;
    }
}
