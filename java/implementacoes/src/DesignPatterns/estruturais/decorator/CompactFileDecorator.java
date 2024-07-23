package DesignPatterns.estruturais.decorator;

public class CompactFileDecorator extends FileDecorator{

    public CompactFileDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String read() {
        return unzip(super.read());
    }

    @Override
    public void write(String dados) {
        super.write(zip(dados));
    }

    public String zip(String dados){
        return dados.replace("ABCD", "1").replace("EFGH", "2");
    }

    public String unzip(String dados){
        return dados.replace("1-", "abcd").replace("2-", "efgh");
    }
    
}
