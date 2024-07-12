package com.example.DataHora.data;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 5, 16);
        System.out.println(date);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
        System.out.println(date.get(ChronoField.DAY_OF_YEAR));
        LocalDate agora = LocalDate.now();
        System.out.println(agora);
        System.out.println(date.MAX);
        System.out.println(date.MIN);
    }
}
