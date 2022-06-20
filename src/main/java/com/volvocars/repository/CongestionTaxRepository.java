package com.volvocars.repository;

import com.volvocars.model.CongestionTax;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongestionTaxRepository extends CrudRepository<CongestionTax, Long> {

    List<CongestionTax> findByCityId(Long cityId);
}
