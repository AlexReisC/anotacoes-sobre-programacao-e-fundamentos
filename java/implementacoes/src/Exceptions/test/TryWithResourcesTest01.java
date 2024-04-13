package Exceptions.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import Exceptions.dominio.Leitor1;
import Exceptions.dominio.Leitor2;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {
        lerArquivo();
    }

    public static void lerArquivo(){
        try (Leitor1 leitor1 = new Leitor1(); Leitor2 leitor =  new Leitor2()) { 
            // é possíel declarar dois objetos, eles são fechados na ordem inversa da criação
        } catch (IOException e) {
            
        }
    }

    public static void lerArquivo2(){
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
