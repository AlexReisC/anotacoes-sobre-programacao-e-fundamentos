package com.example.Streams.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.Streams.dominio.LightNovel;

public class StreamTest06 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
    new LightNovel("Sacana", 2.99), new LightNovel("Mushouku Tensei", 6.99), 
    new LightNovel("Tokyo Ghoul", 4.99), new LightNovel("Fullmetal Alchemist", 5.99),
    new LightNovel("Dragon Bolas", 3.99), new LightNovel("One Piece", 8.99),
    new LightNovel("Sacana", 2.99)));
    public static void main(String[] args) {
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0));
        lightNovels.stream()
        .filter(ln -> ln.getPrice() > 3)
        .findAny()
        .ifPresent(System.out::println);

        lightNovels.stream()
        .filter(ln -> ln.getPrice() > 3)
        .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
        .findFirst()
        .ifPresent(System.out::println);

        lightNovels.stream()
        .filter(ln -> ln.getPrice() > 3)
        .max(Comparator.comparing(LightNovel::getPrice).reversed())
        .ifPresent(System.out::println);
    }
}
