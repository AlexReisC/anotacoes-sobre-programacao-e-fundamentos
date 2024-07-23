package DesignPatterns.criacionais.builder;

public class CarroBuilder {
    private Carro carro;

    public CarroBuilder() {
        this.carro = new Carro();
    }

    public CarroBuilder definirMotor(Motor motor){
        this.carro.setMotor(motor);
        return this;
    }
    
    public CarroBuilder definirTransmissao(Transmissao transmissao){
        this.carro.setTransmissao(transmissao);
        return this;
    }
    
    public CarroBuilder definirCor(Cor cor){
        this.carro.setCor(cor);
        return this;
    }
    
    public CarroBuilder adicionarItemOpcional(ItemOpcional item){
        this.carro.getListaOpcionais().add(item);
        return this;
    }

    public Carro build(){
        Carro c = this.carro;
        this.carro = new Carro();
        return c;
    }
}
