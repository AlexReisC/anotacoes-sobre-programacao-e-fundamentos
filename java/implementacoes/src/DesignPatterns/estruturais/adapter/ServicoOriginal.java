package DesignPatterns.estruturais.adapter;

public class ServicoOriginal implements IRelatorio{

    @Override
    public void gerarRelatorio(String dados) {
        System.out.println("Relatorio módulo original");
        System.out.println("-------------------------");
        System.out.println(dados);
        System.out.println("-------------------------");    
    }
    
}
