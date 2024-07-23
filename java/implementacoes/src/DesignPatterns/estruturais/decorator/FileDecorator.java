package DesignPatterns.estruturais.decorator;

public class FileDecorator implements DataSource{
    private DataSource dataSource;
    
    public FileDecorator(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void write(String dados) {
        this.dataSource.write(dados);
    }
    
    @Override
    public String read() {
        return this.dataSource.read();
    }
    
}
