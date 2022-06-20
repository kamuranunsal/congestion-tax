package com.volvocars.service;

import com.volvocars.exception.CongestionTaxRulesNotDefined;
import com.volvocars.model.CongestionTax;

import java.util.List;

public interface CongestionTaxRulesService {

    List<CongestionTax> getCongestionTaxList(Long cityId) throws CongestionTaxRulesNotDefined;

}
