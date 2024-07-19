# Adapter
Permite integrar objetos que precisam se comunicar mas tem interfaces incompatíveis seja na chamada de métodos, seja no formato dos dados.

Um cliente precisa acssar um novo módulo que tem uma interface incompatível a sua chamada.

O padrão Adapter permite que você crie uma classe de meio termo que serve como um tradutor entre seu código e a classe antiga, uma classe de terceiros, ou qualquer outra classe com uma interface estranha.

## Estrutura
O cliente continua fazendo a chamada ao módulo do jeito que ele conhece. Entretanto não usa mais uma classe, e sim uma interface. A classe Adapter implementa esta interface, realiza as adaptações necessárias e efetivamente chama o novo serviço.

## Codigo
```java
public interface IRelatorio {
    public void gerarRelatorio(String dados);
}
```

```java
public class ServicoOriginal implements IRelatorio{
    @Override
    public void gerarRelatorio(String dados){
        System.out.println("Relatorio módulo original");
        System.out.println("-------------------------");
        System.out.println(dados);
        System.out.println("-------------------------");
    }
}
```

```java
public class RelatorioMasterBlasterPlus {
    public void generateReport(String[] csvDados){
        System.out.println("New report v1.0");
        System.out.println("=======================");
        for (String s: csvDados){
            System.out.println(s);
        }
        System.out.println("=======================");
    }
}
```

```java
public class ReportAdapter implements IRelatorio{
    private RelatorioMasterBlasterPlus report;

    public ReportAdapter(){
        this.report = new RelatorioMasterBlasterPlus();
    }

    @Override
    public void gerarRelatorio(String dados){
        String[] csvDados = dados.split("\n");
        this.report.generateReport(csvDados);
    }
}
```

```java
public class Main {
    void main(){
        IRelatorio rel = new ReportAdapter();
        rel.gerarRelatorio("Unidade: R$ 1000 \nUnidade2: R$ 1200 \nUnidade3: R$ 1300");
    }
}
```

**SAÍDA:**
```
====================
Unidade: R$ 1000
Unidade2: R$ 1200
Unidade3: R$ 1300
====================
```