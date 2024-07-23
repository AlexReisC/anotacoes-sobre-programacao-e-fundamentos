package DesignPatterns.criacionais.builder;

public class Transmissao {
    private String modo;

    public Transmissao(String modo) {
        this.modo = modo;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    @Override
    public String toString() {
        return "Transmissao [" + modo + "]";
    }
    
}
