package com.volvocars.controller;


import com.volvocars.controller.converter.CongestionTaxMapper;
import com.volvocars.exception.CongestionTaxRulesNotDefined;
import com.volvocars.model.dto.CongestionTaxDTO;
import com.volvocars.service.CongestionTaxRulesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/congestion-tax-rules")
public class CongestionTaxRulesController {

    CongestionTaxRulesService congestionTaxRulesService;

    public CongestionTaxRulesController(CongestionTaxRulesService congestionTaxRulesService) {
        this.congestionTaxRulesService = congestionTaxRulesService;
    }

    @GetMapping("/{city_id}")
    public List<CongestionTaxDTO> getCongestionTaxList(@PathVariable Long city_id) throws CongestionTaxRulesNotDefined {
        return CongestionTaxMapper.mapToDTOList(congestionTaxRulesService.getCongestionTaxList(city_id));
    }
}
