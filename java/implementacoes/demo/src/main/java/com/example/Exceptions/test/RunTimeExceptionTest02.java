package com.example.Exceptions.test;

public class RunTimeExceptionTest02 {
    public static void main(String[] args) {
        /* try {
            divisao(1,0); // ArithmeticException
        } catch (RuntimeException e) {
            e.printStackTrace();
        } */
        divisao(1, 0);
        System.out.println("finalizado");
    }

    private static int divisao(int a, int b){
        if(b == 0){
            throw new RuntimeException("Argumento inválido, não pode ser 0"); // lançando ma exceção
        }
        return a / b;
        /*
        try {
            return a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
        */
    }
}
