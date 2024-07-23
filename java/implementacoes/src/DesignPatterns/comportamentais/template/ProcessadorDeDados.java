package DesignPatterns.comportamentais.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ProcessadorDeDados {
	protected List<String> data;
	protected File file;
	protected FileReader reader;
	protected List<Pessoa> result;
	
	public ProcessadorDeDados(String fileName) {
		try {
			file = new File(fileName);
			this.data = new ArrayList<>();
			this.result = new ArrayList<>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void processData() {
		step1();
		step2();
		step3();
	}
	
	public void step1() {
		try {
			reader = new FileReader(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void step2() {
		BufferedReader br = new BufferedReader(reader);
		String line;
		try {
			while((line = br.readLine()) != null) {
				this.data.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract void step3();

	public void printResult() {
		for (Pessoa p : result) {
			System.out.println(p);
		}
	}
}
