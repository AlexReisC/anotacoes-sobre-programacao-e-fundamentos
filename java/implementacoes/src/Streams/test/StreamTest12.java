package Streams.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Streams.dominio.Category;
import Streams.dominio.LightNovel;

public class StreamTest12 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
    new LightNovel("Sacana", 2.99, Category.COMEDIA), new LightNovel("Mushouku Tensei", 6.99, Category.ISEKAI), 
    new LightNovel("Tokyo Ghoul", 4.99, Category.SHOUNEN), new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASIA),
    new LightNovel("Dragon Bolas", 3.99, Category.SHOUNEN), new LightNovel("One Piece", 8.99, Category.SHOUNEN),
    new LightNovel("Sacana", 2.99, Category.COMEDIA)));
    
    public static void main(String[] args) {
        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();
        List<LightNovel> fantasia = new ArrayList<>();
        List<LightNovel> isekai = new ArrayList<>();
        List<LightNovel> shounen = new ArrayList<>();
        List<LightNovel> comedia = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()) {
                case FANTASIA: fantasia.add(lightNovel); break;
                case ISEKAI: fantasia.add(lightNovel); break;
                case SHOUNEN: fantasia.add(lightNovel); break;
                case COMEDIA: fantasia.add(lightNovel); break;
            }
        }
        categoryLightNovelMap.put(Category.FANTASIA, fantasia);
        categoryLightNovelMap.put(Category.ISEKAI, isekai);
        categoryLightNovelMap.put(Category.SHOUNEN, shounen);
        categoryLightNovelMap.put(Category.COMEDIA, comedia);
        System.out.println(categoryLightNovelMap);

        Map<Category, List<LightNovel>> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(collect);
    }
}
