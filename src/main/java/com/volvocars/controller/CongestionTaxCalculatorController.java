package com.volvocars.controller;

import com.volvocars.exception.CongestionTaxRulesNotDefined;
import com.volvocars.exception.VehicleTypeNotDefinedException;
import com.volvocars.model.dto.TaxCalculationParamsDTO;
import com.volvocars.model.dto.TaxCalculationResultDTO;
import com.volvocars.service.CongestionTaxCalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/congestion-tax-calculator")
public class CongestionTaxCalculatorController {

    CongestionTaxCalculatorService congestionTaxCalculatorService;

    public CongestionTaxCalculatorController(CongestionTaxCalculatorService congestionTaxCalculatorService) {
        this.congestionTaxCalculatorService = congestionTaxCalculatorService;
    }

    @PostMapping
    public TaxCalculationResultDTO getTaxCalculationResult(@Valid @RequestBody TaxCalculationParamsDTO taxCalculationParamsDTO) throws VehicleTypeNotDefinedException, CongestionTaxRulesNotDefined {
        return congestionTaxCalculatorService.getTaxCalculationResult(taxCalculationParamsDTO);
    }
}
