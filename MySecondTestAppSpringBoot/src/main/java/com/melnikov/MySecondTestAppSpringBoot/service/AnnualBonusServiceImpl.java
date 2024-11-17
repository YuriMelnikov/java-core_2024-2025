package com.melnikov.MySecondTestAppSpringBoot.service;

import com.melnikov.MySecondTestAppSpringBoot.model.Positions;
import org.springframework.stereotype.Service;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays){
        int daysInYear = isLeapYear() ? 366 : 365;
        return salary * bonus * daysInYear * positions.getPositionCoefficient() / workDays;
    }

    private boolean isLeapYear() {
        int year = java.time.Year.now().getValue();
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public double calculateQuarterlyBonus(Positions position, double salary) {
        if (!position.isManager()) {
            throw new IllegalArgumentException("Quarterly bonus is only applicable for managers.");
        }
        return salary * 0.25 * position.getPositionCoefficient();
    }
}
