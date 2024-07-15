# Stream
É uma sequência de elementos advinda de uma fonte de dados que oferece suporte a "operações agregadas".
- Fonte de dados: array, coleção, função de iteração, recurso de entrada/saída.

Stream é uma solução para processar sequência de dados. Trabalhar com stream é trabalhar no espaço de tempo. Quando se fecha um stream não se pode mais usa-lo (ela é fechada quando se utiliza uma operação final).
<br>
A maioria das coleções tem um método `stream`. As operações em um stream são *intermediarias* ou *finais*.
- Ações intermediarias: retornam uma stream (é possível encadear ações)
- Ações finais: não há retorno de stream.
  
Métodos do `stream`:
- `sorted()`: ordena elementos. Recebe um `Comparator` e retorna um stream.
- `filtter()`: filtra elementos. Recebe um `Predicate` e retorna um stream.
- `limit()`: retorna uma stream contendo o número limitado de elementos especificado no parametro.
- `map()`: extrai elementos. Recebe uma `Function` e retorna um stream.
- `collect()`: agrupa elementos. É um método do tipo *final*.
- `count()`: conta os elementos. É um método *final*.
- `distinct()`: retorna uma stream contendendo os elementos distintos (de acordo com o `Object.equals(Object)`).
- `flatMap()`: igual ao `map()` mas usado quando se tem propriedades aninhadas, quando se quer retirar um atributo de dentro de outro.
- `anyMatch()`: procura por um elemento e retorna `true` ou `false`.
- `allMatch()`: verifica se todos os elementos corresponde com o parametro passado, retorna `true`ou `false`.
- `noneMatch()`: o inverso de `allMatch`.
- `findAny()`: procura um elemento qualquer e retorna um opcional
- `findFirst()`: procura o primeiro elemento e retorna um opcional
- `reduce()`: *operação final* dos streams. Aplica uma operação aos elementos para obter-se um resultado único.

Formas para criar Streams diretamente:
- IntStream: cria um stream de inteiros
- Stream.of(): funciona como o `List.of()`

[Também é possível usar streams em arquivos](test/StreamTest09.java)
<br>
 
[Como gerar infinitas streams](test/StreamTest10.java)
<br>

Dentro das streams existe o método `collect()` que é utilizado para implementar a classe `Collectors` que por sua vez possui diversos métodos. Dentre eles, o método `summarizing` que retorna uma série de estatisticas sobre os elementos da stream.
<br>
[Streams podem ser paralelizadas](test/StreamTest13.java)
<br>
Condições para avaliar se é bom paralelizar uma Stream:
- Benchmark
- Unboxing/boxing
- não indicado com (`limit()`, `findFirst()`), indicado com `findAny()`
- Custo total da computação
- Quantidade de dados
- Tipos de coleções (collections)
- Tamanho do stream (tamanho definido)
- Processamento merge