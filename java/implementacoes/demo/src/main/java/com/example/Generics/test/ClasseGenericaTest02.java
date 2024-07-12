package com.example.Generics.test;

import java.util.ArrayList;
import java.util.List;

import com.example.Generics.dominio.Barco;
import com.example.Generics.dominio.Carro;
import com.example.Generics.service.RentalService;

public class ClasseGenericaTest02 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Mercedes")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
        RentalService <Carro> rentalService = new RentalService<>(carrosDisponiveis);

        Carro carro = rentalService.buscarObjetoDisponivel();
        rentalService.retornarObjetoAlugado(carro);
    }
    
    
}