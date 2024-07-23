package DesignPatterns.comportamentais.observer;

public class MainClass {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        publisher.subscribe(new Assinante(1));
        publisher.subscribe(new Assinante(2));
        publisher.subscribe(new Assinante(3));
        
        publisher.notifySubscribers();
    }
}
