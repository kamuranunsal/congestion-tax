package com.volvocars.smoke;


import com.volvocars.CongestionTaxCalculatorApplication;
import com.volvocars.controller.CongestionTaxCalculatorController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CongestionTaxCalculatorApplication.class)
public class SmokeTest {

    @Autowired
    private CongestionTaxCalculatorController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}