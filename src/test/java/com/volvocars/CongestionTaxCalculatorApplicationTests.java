package com.volvocars;

import com.volvocars.controller.CongestionTaxCalculatorController;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CongestionTaxCalculatorApplicationTests {

    @Autowired
    private CongestionTaxCalculatorController controller;

    @Test
    void contextLoads() {
        AssertionsForClassTypes.assertThat(controller).isNotNull();
    }
}
