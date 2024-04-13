package Generics.test;

import java.util.List;

public class WildCardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());
        //printConsulta(cachorros);
        List<Animal> animais = List.of(new Gato(), new Cachorro());
        printConsulta(animais);
    }

    private static void printConsulta(List<Animal> animals){ // lista de Animal ou filhos
        for (Animal animal : animals) {
            animal.consulta();
        }

        animals.add(new Cachorro());
    }

    private static void printConsultaAnimal(List<? super Animal> animals){ // lista de Animal ou pais
        animals.add(new Cachorro());
        animals.add(new Gato());
    }
}
