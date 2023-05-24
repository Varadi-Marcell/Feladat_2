package com.example.Feladat_2.controller;

import com.example.Feladat_2.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String showForm() {
        return "form";
    }

    @RequestMapping(
            method = {RequestMethod.POST})
    @PostMapping("/arithmetic")
    public String calculateArithmeticAveragePost(@RequestParam("a") String a, @RequestParam("b") String b, Model model) {
        try {
            double result = calculatorService.arithmeticCalc(Double.parseDouble(a), Double.parseDouble(b));
            model.addAttribute("result", result);
            return "result";
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Hiba: nem számokat adtál meg.");
            return "form";
        }
    }

    @ResponseBody
    @PostMapping("/geometric")
    public double calculateGeometricMean(@RequestParam double a, @RequestParam double b) {
        return calculatorService.geometricCalc(a, b);
    }

}
