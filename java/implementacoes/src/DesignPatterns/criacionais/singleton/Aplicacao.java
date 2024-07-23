package DesignPatterns.criacionais.singleton;

public class Aplicacao {
    public static void main(String[] args) {
        DatabaseSingleton db = DatabaseSingleton.getInstance();
        db.executarComando("SELECT * FROM tabela");

        DatabaseSingleton outroDB = DatabaseSingleton.getInstance();
        outroDB.executarComando("INSERT INTO tabela VALUES(?,?,?)");
    }
}
