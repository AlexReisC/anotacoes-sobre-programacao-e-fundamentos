package com.example.Generics.test;

import com.example.Generics.dominio.Barco;
import com.example.Generics.dominio.Carro;
import com.example.Generics.service.BarcoRentavelService;
import com.example.Generics.service.CarroRentavelService;

public class ClasseGenericaTest01 {
    public static void main(String[] args) {
        CarroRentavelService carroRentavelService = new CarroRentavelService();
        Carro carro = carroRentavelService.buscarCarroDisponivel();
        System.out.println("Usando carro por um mês");
        carroRentavelService.retornarCarroAlugado(carro);

        BarcoRentavelService barcoRentavelService = new BarcoRentavelService();
        Barco barco = barcoRentavelService.buscarBarcoDisponivel();
        System.out.println("Usando barco por um mês");
        barcoRentavelService.retornarBarcoAlugado(barco);
    }
}
