package Generics.test;

import Generics.dominio.Barco;
import Generics.dominio.Carro;
import Generics.service.BarcoRentavelService;
import Generics.service.CarroRentavelService;

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
