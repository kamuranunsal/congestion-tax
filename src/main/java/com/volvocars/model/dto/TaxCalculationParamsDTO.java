package com.volvocars.model.dto;

import com.volvocars.model.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaxCalculationParamsDTO {
    VehicleType vehicleType;
    List<String> dateList;
}
