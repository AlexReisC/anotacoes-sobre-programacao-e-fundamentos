# Command
O Command é um padrão de projeto comportamental que transforma um pedido em um objeto independente que contém toda a informação sobre o pedido. Essa transformação permite que você parametrize métodos com diferentes pedidos, atrase ou coloque a execução do pedido em uma fila, e suporte operações que não podem ser feitas.

Um objeto que encapsula uma lógica de uma ação.

## Por que usar?
Independente da origem da invocação (ou o evento) que faz a invocação, a lógica pode estar encapsulada em um mesmo lógico.

### Exemplo
Todo mundo já usou um editor de texto que pode gravar um arquivo tanto através de um botão quanto de um atalho (CRTL+S). Ao invés de duplicarmos a lógica em ambos os eventos, podemos simplesmente encapsula-la em um mesmo Command.

## Estrutura
Você pode ter comandos genéricos e depois especifica-los para que cada um execute sua lógica. O Cliente usa um invocador para ser o elemento de ativação do comando.

## Código
```java
public interface Command{
    public void execute();
}
```

```java
public class SaveCommand implements Command{
    private File arquivo;
    private String content;

    public SaveCommand(String fileName, String content){
        try{
            arquivo = new File(fileName);
            this.content = content;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void execute(){
        try{
            FileWriter wr = new FileWriter(arquivo);
            wr.write(content);
            wr.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
```

```java
public class EditorGUI extends JFrame{
    JButton btnSalvar;
    JButton btnGravar;

    JTextArea areaDeTexto;
    JTextField nomeDoArquivo;

    Command cmdSalvar;

    public EditorGUI(){
        setTitle("Simple Editor");
        stLayout(null);
        setBounds(2000, 100, 640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnSalvar = new JButton();
        btnSalvar.setText("Salvar");
        btnSalvar.setBounds(10, 10, 100, 50);
        getContentPane().add(btnSalvar)

        btnGravar = new JButton();
        btnGravar.setText("Gravar");
        btnGravar.setBounds(150, 10, 100, 50);
        getContentPane().add(btnGravar)

        nomeDoArquivo = new JTextField();
        nomeDoArquivo.setBounds(10, 90, 100, 30);
        getContentPane().add(nomeDoArquivo)
        
        areaDeTexto = new JextArea();
        areaDeTexto.setBounds(10, 150, 400, 200);
        areaDeTexto.setEnable(true);
        getContentPane().add(areaDeTexto)
        
        setVisible(true);

        btnGravar.addActionListenar( e -> )
    }
}
```

```java
public class MainClass{
    void main(){
        new EditorGUI();
    }
}
```
