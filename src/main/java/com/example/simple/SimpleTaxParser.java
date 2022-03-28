package com.example.simple;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SimpleTaxParser {

    private SimpleTaxParser() {
    }

    public static BigDecimal calculateRealTax(List<String> strings) {
        List<Tax> taxes = strings.stream()
                .map(s -> s.split(","))
                .filter(s -> s.length == 3)
                .map(s -> {
                    BigDecimal net = new BigDecimal(s[0]);
                    BigDecimal tax = new BigDecimal(s[1]);
                    BigDecimal gross = new BigDecimal(s[2]);
                    return new Tax(net, tax, gross);
                })
                .filter(tax -> tax.net().add(tax.taxRate()).compareTo(tax.gross()) >= 0)
                .toList();
        BigDecimal fullTaxRate = taxes.stream().map(Tax::taxRate).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal fullGross = taxes.stream().map(Tax::gross).reduce(BigDecimal.ZERO, BigDecimal::add);
        return fullTaxRate.multiply(new BigDecimal(100)).divide(fullGross, RoundingMode.HALF_UP);
    }

}

record Tax(BigDecimal net, BigDecimal taxRate, BigDecimal gross) {

}