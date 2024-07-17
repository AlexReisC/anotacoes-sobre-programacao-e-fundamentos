# Factory Method
O Factory Method é um padrão criacional de projeto que fornece uma interface para criar objetos em uma superclasse, mas permite que as subclasses alterem o tipo de objetos que serão criados.

Você precisa criar diferentes tipos de objetos que tenham algum comportamento em comum.

Vantagens:
- Você evita acoplamentos firmes entre o criador e os produtos concretos.
- Principio da responsabilidade única. Você pode mover o código de criação do produto para um único local do programa, facilitando a manutenção.
- Principio aberto/fechado. Você pode introduxir novos tipos de produtos no programa sem quebrar o código cliente existente.

Desvantagens:
- Maior complexidade e mais classes

### Exemplo
Você precisa criar diversos tipos de Funcionários com diversas características, porém cada um deles tem um método comum: `calcularSalario()`, por exemplo.

## Estrutura
1. Classe fabrica abstrata
2. Interface com método comum aos produtos
3. Produtos implementam a interface e seu método abstrato
4. Fabricas concretas, que extendem a fabrica generica, para criar os produtos

### Código
```java
public interface Calculable {
    public double calcularSalario();
}
```

```java
public abstract class FabricaDeFuncionarios {
    public abstract Calculable criarFuncionario();
}
```

```java
public class Chefe implements Calculable{
    private String nome;
    private double salarioBase;
    private double adicional;

    public Chefe(String nome, double salarioBase, double adicional){
        super();
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.adicional = adicional;
    }

    @Override
    public double calcularSalario(){
        return salarioBase + adicional;
    }

    // Getters e Setters ...
}
`` 

```java
public class FabricaDeChefes extends Funcionario{
    @Override
    public Calculable criarFuncionario(){
        return new Chefe("Chefe", 10500.0, 1500.0);
    }
}
```

```java
public class Horista implements Calculable {
    private String nome;
    private int horas;
    private double valorHora;

    public Horista(String nome, int horas, double valorDaHora){
        super();
        this.nome = nome;
        this.horas = horas;
        this.valorDaHora = valorDaHora;
} 

    @Override
    public double calcularSalario(){
        return horas * valorDaHora;
    }

    // Getters e Setters
}
```

```java
public class FabricaDeHoristas extends Funcionario{
    @Override
    public Calculable criarFuncionario(){
        return new Horista("Horista", 100.0, 98.75);
    }
}
```

```java
public class Aplicacao {
    void main(){
        List<Calculable> folhaPagamento = new ArrayList<>();

        FabricaDeFuncionarios f1, f2;
        f1 = new FabricaDeChefes;
        f2 = new FabricaDeHoristas;

        folhaPagamento.add(f1.criarFuncionario());
        folhaPagamento.add(f2.criarFuncionario());
        folhaPagamento.add(f1.criarFuncionario());
        folhaPagamento.add(f2.criarFuncionario());

        for(Calculable c; folhaPagamento){
            System.out.println("Salario=" + c.calcularSalarrio);
        }
    }
}
```

**SAÍDA:**
```
Salario = 12000.0
Salario = 9875.0
Salario = 12000.0
Salario = 9875.0
```