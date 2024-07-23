package DesignPatterns.estruturais.adapter;

public class ReportAdapter implements IRelatorio{
    private RelatorioMasterBlasterPlus report;

    public ReportAdapter(){
        this.report = new RelatorioMasterBlasterPlus();
    }

    @Override
    public void gerarRelatorio(String dados) {
        String[] csvDados = dados.split("\n");
        this.report.generateReport(csvDados);
    }
}
