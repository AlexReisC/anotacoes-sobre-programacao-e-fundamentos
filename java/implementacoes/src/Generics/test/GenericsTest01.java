package Generics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Olá");
        lista.add("Mundo!");

        for (String s : lista) {
            System.out.println(s);
        }
    }
}