package Optional.test;

import java.util.Optional;

import Optional.dominio.Manga;
import Optional.repositorio.MangaRepository;

public class OptionalTest02 {
    public static void main(String[] args) {
        //MangaRepository.findByTitle("Noku").ifPresent(m -> m.setTitle("Gugu"));
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Noku");
        mangaByTitle.ifPresent(m -> m.setTitle("Gugu"));
        System.out.println(mangaByTitle);

        Manga mangaById = MangaRepository.findById(3).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaById);
     
        Manga newManga = MangaRepository.findByTitle("Pirata da fimose").orElse(new Manga(4, "Pirata da fimose", 1100));
        System.out.println(newManga);
    }
}
