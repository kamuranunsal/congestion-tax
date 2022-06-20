package com.volvocars.controller.converter;

import com.volvocars.model.CongestionTax;
import com.volvocars.model.dto.CongestionTaxDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CongestionTaxMapper {
    public static CongestionTax mapToDO(CongestionTaxDTO congestionTaxDTO) {
        return new CongestionTax(congestionTaxDTO.getStartTime(), congestionTaxDTO.getEndTime(), congestionTaxDTO.getAmount(), congestionTaxDTO.getCity());
    }

    public static CongestionTaxDTO mapToDTO(CongestionTax congestionTax) {
        return new CongestionTaxDTO(
                congestionTax.getId(), congestionTax.getStartTime(), congestionTax.getEndTime(), congestionTax.getAmount(), congestionTax.getCity());
    }

    public static List<CongestionTaxDTO> mapToDTOList(Collection<CongestionTax> congestionTaxList) {
        return congestionTaxList.stream().map(CongestionTaxMapper::mapToDTO).collect(Collectors.toList());
    }
}
