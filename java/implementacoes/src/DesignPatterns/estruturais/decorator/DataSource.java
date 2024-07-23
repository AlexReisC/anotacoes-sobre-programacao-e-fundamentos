package DesignPatterns.estruturais.decorator;

public interface DataSource {
    public void write(String dados);
    public String read();
}
