package com.example.Streams.test;

import java.util.ArrayList;
import java.util.List;

import com.example.Streams.dominio.LightNovel;

public class StreamTest08 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
    new LightNovel("Sacana", 2.99), new LightNovel("Mushouku Tensei", 6.99), 
    new LightNovel("Tokyo Ghoul", 4.99), new LightNovel("Fullmetal Alchemist", 5.99),
    new LightNovel("Dragon Bolas", 3.99), new LightNovel("One Piece", 8.99),
    new LightNovel("Sacana", 2.99)));
    public static void main(String[] args) {
        lightNovels.stream()
        .map(LightNovel::getPrice)
        .filter(price -> price > 3)
        .reduce(Double::sum)
        .ifPresent(System.out::println);

        double sum = lightNovels.stream()
        .mapToDouble(LightNovel::getPrice)
        .filter(price -> price > 3)
        .sum();
        System.out.println(sum);
    }
}
