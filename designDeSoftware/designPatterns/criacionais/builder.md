# Builder
Esse padrão permite que você crie objetos complexos passo a passo. Ele permite que voce construa diferentes tipos e representações de um objeto usando o mesmo código de construção.

- Você pode construir objetos passo a passo, adiar etapas de construção ou rodar etapas recursivamente.
- Você pode reutilizar o mesmo código de construção quando construindo várias representações de produtos.
- Você pode isolar um código de construção da lógica de negócio do produto.
- Use o padrão Builder quando você quer que seu código seja capaz de criar diferentes representações do mesmo produto (por exemplo, casas de pedra e madeira).
- A complexidade geral do código aumenta uma vez que o padrão exige criar múltiplas classes novas.

## Estrutura
Temos um builder que armazena as estapas da construção do objeto. Uma classe *Director* o builder e o *client* usa o Director. 

A classe Director é opcional. Se a construção do seu objeto obrigatoriamente tiver uma ordem a seguir, essa responsabilidade pode ser feita pela classe Director.

## Código
```java
public class Carro {
    private Motor motor;
    private Transmissão transmissao;
    private Cor cor;
    private List<ItemOpcional> listaOpcionais;

    public Carro(){
        listaOpcionais = new ArrayList<ItemOpcional>;
    }

    // Getters e Setters
}
```

```java
public class Motor {
    private String tipo;
    
    public Motor(String tipo) {
        this.tipo = tipo;
    }

    // Getters e Setters ...
}
```

```java
public class Transmissao {
    private String modo;

    public Transmissao(String modo) {
        this.modo = modo;
    }

    // Getters e Setters
}
```

```java
public class Cor {
    private String nome;

    public Cor(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
}
```

```java
public class ItemOpcional {
    private String item;

    public ItemOpcional(String item) {
        this.item = item;
    }

    // Getters e Setters
}
```

```java
public class CarroBuilder {
    private Carro carro;

    public CarroBuilder(){
        this.carro = new Carro();
    }

    public CarroBuilder definirMotor(Motor motor){
        this.carro.setMotor(motor);
        return this;
    }
    
    public CarroBuilder definirTransmissao(Transmissao transmissao){
        this.carro.setTransmissao(transmissao);
        return this;
    }
    
    public CarroBuilder definirCor(Cor cor){
        this.carro.setCor(cor);
        return this;
    }
    
    public CarroBuilder adicionarItemOpcional(Cor item){
        this.carro.getListaOpcionais().add(item);
        return this;
    }

    public Carro build(){
        Carro c = this.carro;
        this.carro = new Carro();
        return c;
    }
}
```

```java
public class MontadoraDeCarros {
    void main() {
        Carro c1, c2, c3;
        CarroBuilder builder = new CarroBuilder();
        
        c1 = builder.definirMotor(new Motor("1.0 FLEX Turbo"))
                    .definirTransmissao(new Transmissao("Manual"))
                    .definirCor(new Cor("Prata"))
                    .build();
        
        c2 = builder.definirMotor(new Motor("2.0 Biturbo"))
                    .definirTransmissao(new Transmissao("Automatica"))
                    .definirCor(new Cor("Preto"))
                    .adicionarItemOpcional(new ItemOpcional("Multimidia"))
                    .build();

    }
}
```