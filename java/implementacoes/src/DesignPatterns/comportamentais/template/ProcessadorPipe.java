package DesignPatterns.comportamentais.template;

public class ProcessadorPipe extends ProcessadorDeDados{

	public ProcessadorPipe(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step3() {
		for (String s : super.data) {
			String[] fields = s.split("#");
			Pessoa p = new Pessoa(Integer.parseInt(fields[0]), fields[1], fields[2]);
			super.result.add(p);
		}
	}
	
}
