package com.example.Streams.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.example.Streams.dominio.LightNovel;

public class StreamTest03 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
    new LightNovel("Sacana", 2.99), new LightNovel("Mushouku Tensei", 3.99), 
    new LightNovel("Tokyo Ghoul", 4.99), new LightNovel("Fullmetal Alchemist", 5.99),
    new LightNovel("Dragon Bolas", 3.99), new LightNovel("One Piece", 5.99),
    new LightNovel("Sacana", 2.99)));
    public static void main(String[] args) {
        Stream<LightNovel> stream = lightNovels.stream();
        //lightNovels.forEach(System.out::println);
        long count = stream.filter(ln -> ln.getPrice() <= 4).count();
        long count2 = lightNovels.stream().distinct().filter(ln -> ln.getPrice() <= 4).count();
        System.out.println(count);
        System.out.println(count2);
    }
}
