package com.volvocars.service;

import com.volvocars.exception.CongestionTaxRulesNotDefined;
import com.volvocars.exception.VehicleTypeNotDefinedException;
import com.volvocars.model.dto.TaxCalculationParamsDTO;
import com.volvocars.model.dto.TaxCalculationResultDTO;

public interface CongestionTaxCalculatorService {

    TaxCalculationResultDTO getTaxCalculationResult(TaxCalculationParamsDTO taxCalculationParamsDTO) throws VehicleTypeNotDefinedException, CongestionTaxRulesNotDefined;
}
