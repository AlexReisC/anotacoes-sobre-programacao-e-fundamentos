package DesignPatterns.comportamentais.observer;

import java.util.List;
import java.util.ArrayList;

public class Publisher {
    private List<ISubscriber> assinantes;

    public Publisher() {
        this.assinantes = new ArrayList<>();
    }

    public void subscribe(ISubscriber assinante){
        this.assinantes.add(assinante);
    }

    public void notifySubscribers(){
        for(ISubscriber assinante : assinantes){
            assinante.update();
        }
    }
}
