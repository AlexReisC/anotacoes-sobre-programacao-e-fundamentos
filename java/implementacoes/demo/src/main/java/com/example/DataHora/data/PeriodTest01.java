package com.example.DataHora.data;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate ld1 = LocalDate.of(2023, 10, 11);
        LocalDate ld2 = LocalDate.now();
        
        Period p1 = Period.between(ld1, ld2); // aceita apenas LocalDate
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(42); // nao trabalha com semanas
        Period p4 = Period.ofMonths(6);
        Period p5 = Period.ofYears(6);
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(ld2.until(ld2.plusDays(p3.getDays()), ChronoUnit.MONTHS));
    }
}
