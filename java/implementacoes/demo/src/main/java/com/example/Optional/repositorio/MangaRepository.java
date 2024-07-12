package com.example.Optional.repositorio;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.example.Optional.dominio.Manga;

public class MangaRepository {
    private static List<Manga> mangas = List.of(new Manga(1, "Sanfona", 200), new Manga(2, "Noku", 480), new Manga(3, "Naldo", 400));
    
    public static Optional<Manga> findByTitle(String title){
        return findBy(manga -> manga.getTitle().equals(title));
    }

    public static Optional<Manga> findById(Integer id){
        return findBy(manga -> manga.getId().equals(id));
    }

    public static Optional<Manga> findBy(Predicate<Manga> predicate){
        Manga found = null;
        for (Manga manga : mangas) {
            if(predicate.test(manga)){
                found = manga;
            }
        }
        return Optional.ofNullable(found);
    }


}
