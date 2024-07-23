package DesignPatterns.estruturais.adapter;

public class Main {
    public static void main(String[] args) {
        IRelatorio rel = new ReportAdapter();
        rel.gerarRelatorio("Unidade: R$ 1000 \nUnidade2: R$ 1200 \nUnidade3: R$ 1300");
    }
}
