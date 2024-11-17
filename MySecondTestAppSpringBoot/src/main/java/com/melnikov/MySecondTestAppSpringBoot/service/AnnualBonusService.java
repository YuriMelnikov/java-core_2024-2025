package com.melnikov.MySecondTestAppSpringBoot.service;

import com.melnikov.MySecondTestAppSpringBoot.model.Positions;
import org.springframework.stereotype.Service;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);

    double calculateQuarterlyBonus(Positions position, double salary);
}
