package DesignPatterns.criacionais.factory;

public class FabricaDeHoristas extends FabricaDeFuncionarios{

    @Override
    public Calculable criarFuncionario() {
        return new Horista("Horista", 100, 98.75);
    }
    
}
