package DesignPatterns.comportamentais.template;

public class ProcessadorCSV extends ProcessadorDeDados{

	public ProcessadorCSV(String fileName) {
		super(fileName);
	}

	@Override
	public void step3() {
		for (String s : super.data) {
			String[] fields = s.split(";");
			Pessoa p = new Pessoa(Integer.parseInt(fields[0]), fields[1], fields[2]);
			super.result.add(p);
		}
		
	}
	
}
