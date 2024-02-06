# Diferenças entre as versões do Java

## Novidades do Java 8

Foi lançado em Março de 2014, e trouxe várias novidades, como:
- Expressões Lambda
  - São funções anônimas que não possuem um nome e podem ser passadas como argumentos para métodos ou atribuídas a variáveis de referência de função: `() -> System.out.println("Hello World");`
  - Method References: `System.out::println`
  - Constructor References: `ArrayList::new`
  - Functional Interfaces: é uma interface que possui apenas um método abstrato
- Stream 
  - API de processamento de coleções de dados que suporta operações paralelas e sequenciais sobre os elementos
  - `filter()`, `map()`, `flatMap()`, `reduce()`, `collect()`, `forEach()`, `count()`
- Optional Class
  - É uma classe que representa um valor opcional, ou seja, um valor que pode ser nulo
- Date and Time API 
  - Novas classes para manipulação de datas e horas
  - `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `OffsetDateTime`, `Instant`, `Duration`, `Period`
- Nashorn
  - Engine JavaScript para a JVM que permite a execução de scripts JavaScript
- JavaFX
  - É uma biblioteca gráfica para a criação de aplicações desktop e aplicações ricas para a web (RIA) em Java
- PermGen removido
  - É um espaço de memória que armazena as classes carregadas na JVM e os métodos estáticos e variáveis estáticas associadas a essas classes, foi removido e substituído pelo Metaspace

## Novidades do Java 9

- Módulos
  - É uma unidade de código que agrupa pacotes relacionados e fornece uma maneira de ocultar a implementação e expor apenas a API
  - `module-info.java`
- JShell
  - É uma ferramenta interativa que permite a execução de código Java sem a necessidade de criar um arquivo .java
- Private Methods in Interfaces
  - Permite que métodos privados sejam definidos em interfaces

## Novidades do Java 10

- Local-Variable Type Inference
  - Permite que as variáveis locais sejam declaradas com o tipo `var` ao invés de um tipo explícito
  - `var`, `var x = 10;`, `var x = new ArrayList<String>();`
- Garbage-Collector Interface
  - API para implementar coletores de lixo

## Novidades do Java 11

Foi lançado em Setembro de 2018, e trouxe várias novidades, como:
- HTTP Client API
  - API para realizar requisições HTTP e processar respostas HTTP
- Local-Variable Syntax for Lambda Parameters
  - Permite que os parâmetros de uma expressão lambda sejam declarados com o tipo `var` ao invés de um tipo explícito
  - `var`, `var x = 10;`, `var x = new ArrayList<String>();`
- Nest-Based Access Control
  - Permite que as classes aninhadas (inner classes) acessem os membros privados das classes que as envolvem
- Epsilon: Garbage Collector
  - É um coletor de lixo que não faz nada, é usado para testar o desempenho da JVM
- ZGC: Garbage Collector (Experimental)
  - É um coletor de lixo de baixa latência e escalável
- Flight Recorder (JFR)
  - É uma ferramenta de diagnóstico de desempenho que coleta dados de eventos e métricas de desempenho da JVM

## Novidades do Java 12

- Switch Expressions
  - Permite que o switch seja usado como uma expressão, ou seja, que retorne um valor
  - `switch (day) { case MONDAY, TUESDAY -> System.out.println("Working day"); case WEDNESDAY -> System.out.println("Midweek"); }`
- Teeing Collector
  - É um coletor que permite que os elementos de um `Stream` sejam processados por dois coletores diferentes
  - `Collectors.teeing()`

## Novidades do Java 14

- Switch Expressions (Preview)
  - Permite que o switch seja usado como uma expressão, ou seja, que retorne um valor
  - `switch (day) { case MONDAY, TUESDAY -> System.out.println("Working day"); case WEDNESDAY -> System.out.println("Midweek"); }`
- Records (Preview)
  - É uma classe de dados imutável que possui um construtor, getters, equals, hashCode e toString
  - `record Point(int x, int y) { }`
- Text Blocks
  - Permite que strings multilinhas sejam escritas de forma mais legível
  - `String html = """ <html> <body> <p>Hello, world</p> </body> </html> """;`
- Pattern Matching for `instanceof` (Preview)
  - Permite que o resultado de uma expressão `instanceof` seja atribuído a uma variável
  - `if (obj instanceof String s) { System.out.println(s.length()); }`


## Novidades do Java 17

Foi lançado em Setembro de 2021, e trouxe várias novidades, como:
- Sealed Classes
  - Classes que podem ser estendidas por um número limitado de subtipos e que são seladas com a palavra-chave `sealed` e os subtipos com a palavra-chave `permits`
  - `sealed interface Shape permits Circle, Rectangle, Square { }`
- Versão LTS (Long-Term Support)
  - A partir do Java 17, a cada três anos será lançada uma versão LTS, que terá suporte por no mínimo 8 anos
- Pattern Matching for `switch`
  - Permite que o resultado de uma expressão `switch` seja atribuído a uma variável
  - `int result = switch (day) { case MONDAY, TUESDAY -> 1; case WEDNESDAY -> 2; }`

## Referências

[Java Versions Comparisons and Examples](https://medium.com/nerd-for-tech/java-versions-comparisons-and-examples-233280b9192f)
<br>
[Java Versons and Features](https://www.marcobehler.com/guides/a-guide-to-java-versions-and-features#_java_features_8_20)