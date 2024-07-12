package com.example.Arquivos.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("eu sou demais\ncontinuando a escrita");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
