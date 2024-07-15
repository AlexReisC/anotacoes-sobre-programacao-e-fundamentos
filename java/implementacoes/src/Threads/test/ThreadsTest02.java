package Threads.test;

import Threads.dominio.Tarefa;

public class ThreadsTest02 {
    public static void main(String[] args) {
        Tarefa t1 = new Tarefa(0, 1000);
        t1.setName("Tarefa1");
        Tarefa t2 = new Tarefa(1001, 2000);
        t2.setName("Tarefa2");
        Tarefa t3 = new Tarefa(2001, 3000);
        t3.setName("Tarefa3");

        //inicia a execução paralela das três tarefas, iniciando três novas threads no programa
        t1.start();
        t2.start();
        t3.start();

        //aguarda a finalização das tarefas
        try {
            t1.join(); /*  Este faz com que o programa aguarde a finalização de cada thread para que depois possa ler 
                        o valor totalizado por cada tarefa.*/
            t2.join(); 
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total: " + (t1.getTotal() + t2.getTotal() + t3.getTotal()));
    }
}
