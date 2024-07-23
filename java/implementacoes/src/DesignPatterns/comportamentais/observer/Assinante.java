package DesignPatterns.comportamentais.observer;

public class Assinante implements ISubscriber {
    private int id;

    public Assinante(int id) {
        this.id = id;
    }

    @Override
    public void update() {
        System.out.println("Sou o assinante " + id + " e fui atualizado");
    }
    
}
