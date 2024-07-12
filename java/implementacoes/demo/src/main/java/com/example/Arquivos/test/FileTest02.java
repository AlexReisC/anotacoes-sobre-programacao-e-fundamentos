package com.example.Arquivos.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File directory = new File("past");
        boolean isDirectoryCriated = directory.mkdir(); // criar pasta
        System.out.println(isDirectoryCriated);
        File file = new File(directory,"file.txt"); // criar arquivo dentro de pasta
        boolean isFileCreated = file.createNewFile();
        System.out.println(isFileCreated);

        File fileRenamed = new File(directory,"arquivo_confidencial.txt");
        boolean isRenamed = file.renameTo(fileRenamed); // renomear arquivo
        System.out.println(isRenamed);

        File directoryRenamed = new File("past2");
        boolean isDirectoryRenamed = directory.renameTo(directoryRenamed);
        System.out.println(isDirectoryRenamed);
    }
}
