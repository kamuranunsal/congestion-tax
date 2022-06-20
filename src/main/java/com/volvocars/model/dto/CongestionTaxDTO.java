package com.volvocars.model.dto;

import com.volvocars.model.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CongestionTaxDTO {

    private Long id;

    private String startTime;

    private String endTime;

    private double amount;

    private City city;
}
