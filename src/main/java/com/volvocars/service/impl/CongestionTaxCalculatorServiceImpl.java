package com.volvocars.service.impl;

import com.volvocars.exception.CongestionTaxRulesNotDefined;
import com.volvocars.exception.VehicleTypeNotDefinedException;
import com.volvocars.model.Vehicle;
import com.volvocars.model.dto.TaxCalculationParamsDTO;
import com.volvocars.model.dto.TaxCalculationResultDTO;
import com.volvocars.repository.VehicleRepository;
import com.volvocars.service.CongestionTaxCalculatorService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@Service
public class CongestionTaxCalculatorServiceImpl implements CongestionTaxCalculatorService {

    VehicleRepository vehicleRepository;

    public CongestionTaxCalculatorServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public TaxCalculationResultDTO getTaxCalculationResult(TaxCalculationParamsDTO taxCalculationParamsDTO) throws VehicleTypeNotDefinedException, CongestionTaxRulesNotDefined {

        TaxCalculationResultDTO taxCalculationResultDTO = new TaxCalculationResultDTO();

        Vehicle vehicle = vehicleRepository.findByVehicleType(taxCalculationParamsDTO.getVehicleType());

        if (vehicle == null) {
            throw new VehicleTypeNotDefinedException("Could not find entity type" +
                    taxCalculationParamsDTO.getVehicleType().toString());
        }

        if (vehicle.isTaxExempt()) {
            taxCalculationResultDTO.setTax(0);
            return taxCalculationResultDTO;
        }

        double tax = getTax(taxCalculationParamsDTO.getDateList());
        taxCalculationResultDTO.setTax(tax);
        return taxCalculationResultDTO;
    }


    private int getTax(List<String> dates) {

        //order dates
        Collections.sort(dates);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime intervalStart = LocalDateTime.parse(dates.get(0), formatter);

        int totalFee = 0;

        for (int i = 0; i < dates.size(); i++) {
            LocalDateTime nextDateTime = LocalDateTime.parse(dates.get(i), formatter);

            int tempFee = GetTollFee(intervalStart);

            int nextFee = GetTollFee(nextDateTime);

            LocalDateTime tempDateTime = LocalDateTime.from(intervalStart);

            long minutes = tempDateTime.until(nextDateTime, ChronoUnit.MINUTES);

            if (minutes <= 60) {
                if (totalFee > 0) totalFee -= tempFee;
                if (nextFee >= tempFee) tempFee = nextFee;
                totalFee += tempFee;
            } else {
                totalFee += nextFee;
            }
            intervalStart = nextDateTime;
        }

        if (totalFee > 60) totalFee = 60;
        return totalFee;
    }

    public static int GetTollFee(LocalDateTime date) {

        if (IsTollFreeDate(date)) return 0;

        int hour = date.getHour();
        int minute = date.getMinute();

        if (hour == 6 && minute >= 0 && minute <= 29) return 8;
        else if (hour == 6 && minute >= 30 && minute <= 59) return 13;
        else if (hour == 7 && minute >= 0 && minute <= 59) return 18;
        else if (hour == 8 && minute >= 0 && minute <= 29) return 13;
        else if (hour >= 8 && hour <= 14 && minute >= 30 && minute <= 59) return 8;
        else if (hour == 15 && minute >= 0 && minute <= 29) return 13;
        else if (hour == 15 && minute >= 30 || hour == 16 && minute <= 59) return 18;
        else if (hour == 17 && minute >= 0 && minute <= 59) return 13;
        else if (hour == 18 && minute >= 0 && minute <= 29) return 8;
        else return 0;
    }

    private static Boolean IsTollFreeDate(LocalDateTime date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfWeek().getValue();
        int dayOfMonth = date.getDayOfMonth();

        if (day == DayOfWeek.SATURDAY.getValue() || day == DayOfWeek.SUNDAY.getValue()) return true;

        if (year == 2013) {
            return (month == 1 && dayOfMonth == 1) || (month == 3 && (dayOfMonth == 28 || dayOfMonth == 29)) || (month == 4 && (dayOfMonth == 1 || dayOfMonth == 30)) || (month == 5 && (dayOfMonth == 1 || dayOfMonth == 8 || dayOfMonth == 9)) || (month == 6 && (dayOfMonth == 5 || dayOfMonth == 6 || dayOfMonth == 21)) || (month == 7) || (month == 11 && dayOfMonth == 1) || (month == 12 && (dayOfMonth == 24 || dayOfMonth == 25 || dayOfMonth == 26 || dayOfMonth == 31));
        }
        return false;
    }
}
