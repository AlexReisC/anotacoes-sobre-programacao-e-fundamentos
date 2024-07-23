package DesignPatterns.criacionais.factory;

public class Horista implements Calculable{
    private String nome;
    private int horas;
    private double valorHora;
    
    public Horista(String nome, int horas, double valorHora) {
        this.nome = nome;
        this.horas = horas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horas * valorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    
}
