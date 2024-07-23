package DesignPatterns.criacionais.factory;

public class FabricaDeChefes extends FabricaDeFuncionarios{

    @Override
    public Calculable criarFuncionario() {
        return new Chefe("Chefe", 10500.0, 1500.0);
    }
    
}
