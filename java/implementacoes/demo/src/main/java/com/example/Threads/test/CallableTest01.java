package com.example.Threads.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.example.Threads.dominio.CallableImplementacao;

public class CallableTest01 {
    public static void main(String[] args) {
        List<CallableImplementacao> tarefas = Arrays.asList(
                new CallableImplementacao(8000),
                new CallableImplementacao(4000),
                new CallableImplementacao(6000));

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(threadPool);

        //executa as tarefas
        for (CallableImplementacao tarefa : tarefas) {
            completionService.submit(tarefa);
        }
        System.out.println("Tarefas iniciadas, aguardando conclusão");

        //aguarda e imprime o retorno de cada uma
        for (int i = 0; i < tarefas.size(); i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }

        threadPool.shutdown();
    }
}
