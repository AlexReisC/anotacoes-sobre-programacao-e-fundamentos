package DesignPatterns.comportamentais.template;

public class MainClass {

	public static void main(String[] args) {
		ProcessadorCSV pro = new ProcessadorCSV("dados.csv");
		pro.processData();
		pro.printResult();
		
		System.out.println("---------------------------------");
		
		ProcessadorPipe pro2 = new ProcessadorPipe("dados.pipe");
		pro2.processData();
		pro2.printResult();
	}

}
