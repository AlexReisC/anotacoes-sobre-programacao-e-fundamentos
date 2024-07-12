package com.example.Generics.service;

import java.util.List;

public class RentalService<T> {
    private List<T> objetosDisponiveis;
    
    public RentalService(List<T> objetosDiponiveis){
        this.objetosDisponiveis = objetosDiponiveis;
    }
    
    public T buscarObjetoDisponivel(){
        System.out.println("Buscando objeto disponivel...");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto " + t);
        System.out.println("Objetos disponiveis para alugar:");
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T t){
        System.out.println("Devolvendo objeto alugado");
        objetosDisponiveis.add(t);
        System.out.println("Objetos disponiveis para alugar...");
        System.out.println(objetosDisponiveis);
    }
}
