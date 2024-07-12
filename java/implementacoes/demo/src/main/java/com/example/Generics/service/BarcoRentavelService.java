package com.example.Generics.service;

import java.util.ArrayList;
import java.util.List;

import com.example.Generics.dominio.Barco;

public class BarcoRentavelService {
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
    
    public Barco buscarBarcoDisponivel(){
        System.out.println("Buscando barco disponivel...");
        Barco barco = barcosDisponiveis.remove(0);
        System.out.println("Alugando barco " + barco);
        System.out.println("Barcos disponiveis para alugar:");
        System.out.println(barcosDisponiveis);
        return barco;
    }

    public void retornarBarcoAlugado(Barco barco){
        System.out.println("Devolvendo barco alugado");
        barcosDisponiveis.add(barco);
    }    
}
