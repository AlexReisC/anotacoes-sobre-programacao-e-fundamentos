package Lambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import Lambdas.dominio.Anime;
import Lambdas.service.AnimeComparator;

public class MethodReferenceTest04 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("A viagem de Chico", 1), new Anime("One piece",1100), new Anime("Sakamoto", 22)));
        // Supplier<AnimeComparator> newAnimeComparator = () -> new AnimeComparator();
        Supplier<AnimeComparator> newAnimeComparator = AnimeComparator::new;
        AnimeComparator animeComparator = newAnimeComparator.get();

        animeList.sort(animeComparator::compareByEpisodesNonStatic);
        System.out.println(animeList);

        //BiFunction<String, Integer, Anime> animeBiFunction = (title, episodes) -> new Anime(title, episodes);
        BiFunction<String, Integer, Anime> animeBiFunction = Anime::new;
        System.out.println(animeBiFunction.apply("Santana", 25));
    }
}
