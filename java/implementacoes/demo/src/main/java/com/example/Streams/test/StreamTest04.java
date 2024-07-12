package com.example.Streams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Baguncinha", "Panelada", "Antoin");        
        List<String> developers = List.of("Incapaz", "TalDoBumbaMeuBoi");
        List<String> students = List.of("Monark", "Aristóteles");

        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

        for (List<String> people : devdojo) {
            for (String person : people) {
                System.out.println(person);
            }
        }

        System.out.println("-----------");
        devdojo.stream()
        .flatMap(Collection::stream).forEach(System.out::println);

    }
}
