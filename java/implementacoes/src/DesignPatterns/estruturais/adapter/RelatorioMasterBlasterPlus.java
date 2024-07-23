package DesignPatterns.estruturais.adapter;

public class RelatorioMasterBlasterPlus {
    public void generateReport(String[] csvDados){
        System.out.println("New report v1.0");
        System.out.println("=======================");
        for (String s: csvDados){
            System.out.println(s);
        }
        System.out.println("=======================");
    }
}
