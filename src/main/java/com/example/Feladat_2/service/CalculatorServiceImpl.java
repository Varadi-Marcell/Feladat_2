package com.example.Feladat_2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public double arithmeticCalc(double a, double b) {
        return (a+b)/2;
    }
    @Override
    public double geometricCalc(double a, double b) {
        return Math.sqrt(a * b);
    }

}
