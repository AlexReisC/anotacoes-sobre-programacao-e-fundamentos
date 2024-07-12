package com.example.Exceptions.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest01 {
    public static void main(String[] args) throws IOException {
        criarNovoArquivo();
    }

    private static void criarNovoArquivo() throws IOException{
        File file = new File("C:\\Estudos e Projetos\\Implementacoes Java\\src\\arquivo\\teste.txt");
        try {
            boolean criado = file.createNewFile(); // o java obriga o programador a tratar uma possivel exceção IOException
            System.out.println("Arquivo criado? " + criado);
        } catch (IOException e) {
            e.printStackTrace();
            throw e; // aqui estamos capturando, tratando e exibindo no console e mandando a exceção para quem chamou o método
            // throw new RuntimeException("Problema na hora de criar o arquivo");
        }
        
    }
}
