package DesignPatterns.criacionais.builder;

public class MontadoraDeCarros {
    public static void main(String[] args) {
        Carro c1, c2;
        CarroBuilder builder = new CarroBuilder();
        
        c1 = builder.definirMotor(new Motor("1.0 FLEX Turbo"))
                    .definirTransmissao(new Transmissao("Manual"))
                    .definirCor(new Cor("Prata"))
                    .build();
        
        c2 = builder.definirMotor(new Motor("2.0 Biturbo"))
                    .definirTransmissao(new Transmissao("Automatica"))
                    .definirCor(new Cor("Preto"))
                    .adicionarItemOpcional(new ItemOpcional("Multimidia"))
                    .adicionarItemOpcional(new ItemOpcional("Bancos de couro"))
                    .build();
        
        System.out.println(c1);
        System.out.println(c2);
    }
}
