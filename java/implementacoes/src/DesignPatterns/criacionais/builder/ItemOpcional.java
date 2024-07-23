package DesignPatterns.criacionais.builder;

public class ItemOpcional {
    private String item;

    public ItemOpcional(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ItemOpcional [" + item + "]";
    }

}
