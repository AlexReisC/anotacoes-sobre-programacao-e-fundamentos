package com.example.Streams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");
        //List<String[]> letters = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        
        List<String> letters2 = words.stream().map(w -> w.split(""))
        .flatMap(Arrays::stream)
        .collect(Collectors.toList());

        System.out.println(letters2);
    }
}
