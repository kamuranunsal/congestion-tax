package com.volvocars.service.impl;

import com.volvocars.exception.CongestionTaxRulesNotDefined;
import com.volvocars.model.CongestionTax;
import com.volvocars.repository.CongestionTaxRepository;
import com.volvocars.service.CongestionTaxRulesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongestionTaxRulesServiceImpl implements CongestionTaxRulesService {
    CongestionTaxRepository congestionTaxRepository;

    public CongestionTaxRulesServiceImpl(CongestionTaxRepository congestionTaxRepository) {
        this.congestionTaxRepository = congestionTaxRepository;
    }

    @Override
    public List<CongestionTax> getCongestionTaxList(Long cityId) throws CongestionTaxRulesNotDefined {
        //city id can be set to redis to get tax rules when it is needed
        List<CongestionTax> congestionTaxList = congestionTaxRepository.findByCityId(cityId);
        if (congestionTaxList == null) {
            throw new CongestionTaxRulesNotDefined("Congestion tax rules are not defined for city: " + cityId);
        }
        return congestionTaxList;
    }
}
