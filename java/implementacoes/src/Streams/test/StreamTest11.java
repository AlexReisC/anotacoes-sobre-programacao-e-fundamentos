package Streams.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import Streams.dominio.LightNovel;

public class StreamTest11 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
    new LightNovel("Sacana", 2.99), new LightNovel("Mushouku Tensei", 6.99), 
    new LightNovel("Tokyo Ghoul", 4.99), new LightNovel("Fullmetal Alchemist", 5.99),
    new LightNovel("Dragon Bolas", 3.99), new LightNovel("One Piece", 8.99),
    new LightNovel("Sacana", 2.99)));

    public static void main(String[] args) {
        System.out.println(lightNovels.stream().count());
        System.out.println(lightNovels.stream().collect(Collectors.counting()));

        lightNovels.stream().max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);
        lightNovels.stream().collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))).ifPresent(System.out::println);

        System.out.println(lightNovels.stream().mapToDouble(LightNovel::getPrice).sum());
        System.out.println(lightNovels.stream().collect(Collectors.summingDouble(LightNovel::getPrice)));
        
        lightNovels.stream().mapToDouble(LightNovel::getPrice).average().ifPresent(System.out::println);
        System.out.println(lightNovels.stream().collect(Collectors.averagingDouble(LightNovel::getPrice)));

        DoubleSummaryStatistics collect = lightNovels.stream().collect(Collectors.summarizingDouble(LightNovel::getPrice));
        System.out.println(collect);

        String collect2 = lightNovels.stream().map(LightNovel::getTitle).collect(Collectors.joining(", "));
        System.out.println(collect2);
    }
}
