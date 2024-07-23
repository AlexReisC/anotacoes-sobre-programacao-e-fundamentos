package DesignPatterns.estruturais.decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataSource implements DataSource{
    private File file;
    public FileDataSource(){
        try {
            this.file = new File("arquivo.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void write(String dados) {
        try {
            FileWriter f = new FileWriter(this.file);
            f.write(dados);
            f.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String read() {
        try {
            FileReader r = new FileReader(file);
            BufferedReader br = new BufferedReader(r);
            String linha = br.readLine();
            br.close();
            r.close();
            return linha;
        } catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
