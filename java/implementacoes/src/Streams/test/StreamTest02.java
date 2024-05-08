package Streams.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Streams.dominio.LightNovel;

public class StreamTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
    new LightNovel("Sacana", 2.99), new LightNovel("Mushouku Tensei", 3.99), 
    new LightNovel("Tokyo Ghoul", 4.99), new LightNovel("Fullmetal Alchemist", 5.99),
    new LightNovel("Dragon Bolas", 3.99), new LightNovel("One Piece", 5.99)));
    public static void main(String[] args) {
        List<String> titles = lightNovels.stream()
        .sorted(Comparator.comparing(LightNovel::getTitle))
        .filter(ln -> ln.getPrice() <= 4)
        .limit(3)
        .map(LightNovel::getTitle) // ln -> ln.getTitle()
        .collect(Collectors.toList());
        
        System.out.println(titles);
    }
}
