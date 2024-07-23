package DesignPatterns.criacionais.singleton;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;

    private DatabaseSingleton(){
        System.out.println("Conectando no MySQL server");
    }
    
    public static DatabaseSingleton getInstance(){
        if(instance == null){
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public void executarComando(String comando){
        System.out.println("MySQL > " + comando);
    }
}
