package Arquivos.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
//import java.util.Date;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created: " + isCreated);
            
            System.out.println("path " + file.getPath());
            System.out.println("path absolute " + file.getAbsolutePath());
            System.out.println("Is directory " + file.isDirectory());
            System.out.println("Is file " + file.isFile());
            System.out.println("is hidden " + file.isHidden());
            // System.out.println("last modifed " + new Date(file.lastModified())); // retorna um long em milissegundos
            System.out.println("last modifed " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()));

            boolean exists = file.exists();
            if(exists){
                System.out.println("Deletd: " + file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}