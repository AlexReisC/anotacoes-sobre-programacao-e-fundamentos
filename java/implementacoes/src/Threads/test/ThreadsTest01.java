package Threads.test;

public class ThreadsTest01 {
    public static void main(String[] args) {
        new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("ID: " + Thread.currentThread().threadId());
                System.out.println("Nome: " + Thread.currentThread().getName());
                System.out.println("Prioridade: " + Thread.currentThread().getPriority());
                System.out.println("Estado: " + Thread.currentThread().getState());
            }
        }).start();
    }
}
