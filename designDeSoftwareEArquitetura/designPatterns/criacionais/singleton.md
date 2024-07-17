# Singleton
O Singleton é um padrão de projeto criacional que permite a você garantir que uma classe tenha apenas uma instância, enquanto provê um ponto de acesso global para essa instância.

## Por que usar?
- Permitir um ponto único (global) de acesso
- Proteger a forma como um objeto é criado (pois o ideal é o construtor ser privado e encapsulado no seu Singleton)
- Mesmo que precise gerenciar variavéis globais com Singleton você consegue um melhor controle
- Problema: Multithreading

### Exemplo
Uma conexão (ou conjunto de conexão) com o banco de dados que é compartilhada com vários módulos do sistema

## Estrutura
Conhecido pelo seu método `getInstance()`. Se não houver instância, cria-se uma instância e aí você consegue utilizá-la. Todos os clientes vão usar a mesma instância sem perceber.

### Código
```java
public class DatabaseSingleton {
    private static DatabaseSingleton instance;

    private DatbaseSingletin(){
        System.out.println("Conectando no MySQL server");
    }
    
    public static DatabaseSingleton getInstance(){
        if(instance == null){
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public void executarComando(String comando){
        System.out.println(comando);
    }
}

```
```java
public class Aplicacao {
    void main() {
        DatabaseSingleton db = DatabaseSingleton.getInstance();
        db.executarComando("SELECT * FROM tabela");

        DatabaseSingleton outroDB = DatabaseSingleton.getInstance();
        outroDB.executarComando("INSERT INTO tabela VALUES(?,?,?)");
    }
}
```
**SAÍDA:**
```
Conectando no MySQL server
SELECT * FROM tabela
INSERT INTO tabela VALUES(?,?,?)
```