package DesignPatterns.criacionais.builder;

public class Motor {
    private String tipo;
    
    public Motor(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Motor + [" + tipo + "]";
    }
    
}
