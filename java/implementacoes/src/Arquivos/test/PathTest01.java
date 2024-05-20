package Arquivos.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        Path p1 = Paths.get("C:\\Estudos e Projetos\\Anotacoes\\java\\implementacoes\\past2");
        Path p2 = Paths.get("C:","Estudos e Projetos","Anotacoes","java","implementacoes", "past2");
        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        
    }
}
