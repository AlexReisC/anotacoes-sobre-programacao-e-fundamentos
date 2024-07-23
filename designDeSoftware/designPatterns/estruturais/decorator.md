# Decorator
O Decorator é um padrão de projeto estrutural que permite que você acople novos comportamentos para objetos ao colocá-los dentro de invólucros de objetos que contém os comportamentos.

A ideia é como uma boneca *Matryoshca*: Acoplar novas funcionalidades, preservando funcionalidades como se fossem "pilhas".

É um padrão complexo de se criar pois depende bastante do conhecimento da aplicação e também da sua visão de responsabilidade única.

## Codigo
```java
public interface DataSource {
    public void write(String dados);
    public String read();
}
```

```java
public class FileDataSource implements DataSource {
    private File file;
    public FileDataSource(){
        try {
            this.file = new File("arquivo.txt");
        } catch(IOException e){
            e.printStackTrace;
        }
    }

    @Override
    public void write(String dados);{
        try {
            FileWriter f = new FileWriter(this.file);
            f.write(dados);
            f.close();
        } catch(IOException e){
            e.printStackTrace;
        }
    }

    @Override
    public String read(){
        try {
            FileReader r = new FileReader(file);
            BufferedReader br = new BufferedReader(r);
            String linha = br.readLine();
            br.close();
            r.close();
            return linha;
        } catch(IOException e){
            e.printStackTrace;
        }

        return null;
    }
}
```

```java
public class FileDecorator implements DataSource{
    private DataSource dataSoruce;
    
    public FileDecorator(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void write(String dados){
        this.dataSource.write(dados);
    }
    
    @Override
    public String read(String dados){
        return this.dataSource.read();
    }
}
```

```java
public class EncryptFileDecorator extends FileDecorator {
    public EncryptFileDecorator(DataSource dataSource){
        super(dataSoruce);
    }

    public void write(String dados){
        super.write(encrypt(dados));
    }

    public String read(){
        return decrypt(super.read());
    }

    public String encrypt(String dados){
        return dados.replaceAll("-", "");
    }

    public String decrypt(String dados){
        return dados.replace("1", "1-").replace("2", "2-");
    }
}
```

```java
public class CompactFileDecorator extends FileDecorator {
    public CompactFileDecorator(DataSource dataSource){
        super(dataSource)
    }

    public void write(String dados){
        super.write(zip(dados));
    }

    public String read(){
        return unzip(super.read());
    }

    public String zip(String dados){
        return dados.replace("ABCD", "1").replace("EFGH", "2");
    }

    public String unzip(String dados){
        return dados.replace("1-", "abcd").replace("2-", "efgh");
    }
}
```

```java
public class AppQueManipulaAplicatios {
    void main() {
        /*DataSource arquivo = new FileDataSource();

        arquivo.write("ABCDEFG");
        System.out.println(arquivo.read());

        DataSource ds = new FileDecorator(new FileDataSource());
        ds.write("ABCDEFG");
        System.out.println(ds.read());

        DataSource ds2 = new EncryptFileDecorator(new FileDecorator(new FileDataSource()));
        ds2.write("ABCDEFG");
        System.out.println(ds2.read());*/

        DataSource ds3 = new CompactFileDecortor(
                            new EncryptFileDecorator(
                                new FileDecorator(
                                    new FileDataSource())));
        ds2.write("ABCDEFG");
        System.out.println(ds2.read());
    }
}
```
**SAÍDA:**
```
ABCDEFG
```