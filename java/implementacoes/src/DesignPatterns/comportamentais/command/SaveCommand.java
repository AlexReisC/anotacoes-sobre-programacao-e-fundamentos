package DesignPatterns.comportamentais.command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements Command{
    private File arquivo;
    private String content;
    public SaveCommand(String fileName, String content) {
        arquivo = new File(fileName);
        this.content = content;
    }

    @Override
    public void execute() {
        FileWriter writer;
        try {
            writer = new FileWriter(arquivo);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
