package DesignPatterns.estruturais.decorator;

public class EncryptFileDecorator extends FileDecorator{
    
    public EncryptFileDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void write(String dados) {
        super.write(encrypt(dados));
    }

    @Override
    public String read() {
        return decrypt(super.read());
    }

    public String encrypt(String dados){
        return dados.replaceAll("-", "");
    }

    public String decrypt(String dados){
        return dados.replace("1", "1-").replace("2", "2-");
    }
}
