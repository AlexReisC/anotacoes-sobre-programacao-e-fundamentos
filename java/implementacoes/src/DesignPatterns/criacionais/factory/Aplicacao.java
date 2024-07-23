package DesignPatterns.criacionais.factory;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
        List<Calculable> folhaPagamento = new ArrayList<>();

        FabricaDeFuncionarios f1, f2;
        f1 = new FabricaDeChefes();
        f2 = new FabricaDeHoristas();

        folhaPagamento.add(f1.criarFuncionario());
        folhaPagamento.add(f2.criarFuncionario());
        folhaPagamento.add(f1.criarFuncionario());
        folhaPagamento.add(f2.criarFuncionario());

        for(Calculable c : folhaPagamento){
            System.out.println("Salario=" + c.calcularSalario());
        }
    }
}
