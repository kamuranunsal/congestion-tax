package com.volvocars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.volvocars.exception.CongestionTaxRulesNotDefined;
import com.volvocars.exception.VehicleTypeNotDefinedException;
import com.volvocars.model.VehicleType;
import com.volvocars.model.dto.TaxCalculationParamsDTO;
import com.volvocars.model.dto.TaxCalculationResultDTO;
import com.volvocars.service.CongestionTaxCalculatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CongestionTaxCalculatorController.class)
public class CongestionTaxCalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CongestionTaxCalculatorService service;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private TaxCalculationResultDTO createTestTaxCalculationResultDTO() {
        return TaxCalculationResultDTO.builder()
                .tax(21)
                .build();
    }

    private TaxCalculationParamsDTO createTestTaxCalculationParamsDTO() {
        List<String> dateList = List.of("2013-01-14 21:00:00",
                "2013-01-15 21:00:00",
                "2013-02-07 06:23:27", "2013-02-07 15:27:00");
        return TaxCalculationParamsDTO.builder()
                .vehicleType(VehicleType.CAR)
                .dateList(dateList)
                .build();
    }

    @Test
    public void testShouldReturnTaxCalculationResultDTO() throws VehicleTypeNotDefinedException, CongestionTaxRulesNotDefined {
        TaxCalculationResultDTO taxCalculationResultDTO = createTestTaxCalculationResultDTO();
        Mockito.when(service.getTaxCalculationResult(createTestTaxCalculationParamsDTO())).thenReturn(taxCalculationResultDTO);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/v1/congestion-tax-calculator")
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(createTestTaxCalculationParamsDTO()))
                .contentType(MediaType.APPLICATION_JSON);

        try {
            MvcResult result = mockMvc.perform(request)
                    .andExpect(status().isOk()).andReturn();
            System.out.print(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
