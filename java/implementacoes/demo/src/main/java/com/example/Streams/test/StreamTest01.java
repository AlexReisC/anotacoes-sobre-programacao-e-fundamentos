package com.example.Streams.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.Streams.dominio.LightNovel;

public class StreamTest01 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
    new LightNovel("Sacana", 2.99), new LightNovel("Mushouku Tensei", 3.99), 
    new LightNovel("Tokyo Ghoul", 1.99), new LightNovel("Fullmetal Alchemist", 5.99)));
    public static void main(String[] args) {
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            if(lightNovel.getPrice() <= 4){
                titles.add(lightNovel.getTitle());
            }
            if(titles.size() == 3){
                break;
            }
        }
        
        System.out.println(lightNovels);
        System.out.println(titles);
    }
}
