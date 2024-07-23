package DesignPatterns.estruturais.decorator;

public class AppQueManipulaAplicativos {
    public static void main(String[] args) {
        DataSource ds = new CompactFileDecorator(
                            new EncryptFileDecorator(
                                new FileDecorator(
                                    new FileDataSource())));
        ds.write("ABCDEFG");
        System.out.println(ds.read());
    }
}
