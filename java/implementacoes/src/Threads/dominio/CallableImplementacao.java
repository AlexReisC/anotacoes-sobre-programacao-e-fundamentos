package Threads.dominio;

import java.util.concurrent.Callable;

public class CallableImplementacao implements Callable<String>{
    private final long tempoDeEspera;

    public CallableImplementacao(int time) {
        this.tempoDeEspera = time;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(tempoDeEspera);
        return Thread.currentThread().getName();
    }
}
