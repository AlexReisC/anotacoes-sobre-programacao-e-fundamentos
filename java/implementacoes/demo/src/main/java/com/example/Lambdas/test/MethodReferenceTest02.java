package com.example.Lambdas.test;

import java.util.ArrayList;
import java.util.List;

import com.example.Lambdas.dominio.Anime;
import com.example.Lambdas.service.AnimeComparator;

// Reference to a instance method of a particular object
public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparator animeComparator = new AnimeComparator();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("A viagem de Chico", 1), new Anime("One piece",1100), new Anime("Sakamoto", 22)));
        animeList.sort(animeComparator::compareByEpisodesNonStatic);
        animeList.sort((a1, a2) -> animeComparator.compareByEpisodesNonStatic(a1,a2));
        System.out.println(animeList);
    }
}
