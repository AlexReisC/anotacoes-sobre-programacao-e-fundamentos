# Collections no Java
Afim de resolver as dificuldades em implementar estrututras de dados usando arrays e falta de classes que implementassem listas, conjuntos e mapas, o Java fornece a API Collections Framework, do pacote `java.util`, a paritir da versão 1.2.
<br>
Collections Framework é um conjunto de classes e interfaces que implementam estruturas de dados, a Collections Framework contém os seguintes componentes:
- Interfaces: tipos abstratos de dados que representam coleções.
- Classes: Implementam as interfaces.
- Algoritmos: Métodos que realizam operações em coleções, como ordenação e busca.

### Existe uma hierarquia de interfaces e classes da Java Collections Framework que são derivadas da interface `Collection` e da interface `Map`.
- `Collection`
  - `List`
    - `ArrayList`
    - `LinkedList`
    - `Vector`
  - `Set`
    - `HashSet`
    - `LinkedHashSet`
    - `SortedSet`
      - `TreeSet`
  - `Queue`
    - `PriorityQueue`
***
- `Map`
  - `Hashtable`
  - `HashMap`
  - `LinkedHashMap`
  - `SortedMap`
    - `TreeMap`

## Interfaces

`Collection` é a interface raiz da hierarquia de coleções, não existe implementação direta dela mas ela define operações comuns a todas as coleções, como adicionar elementos, remover elementos, verificar se um elemento está na coleção, etc.
<br>
`List` é uma coleção ordenada, que pode conter elementos duplicados. A interface `List` estende a interface `Collection` e adiciona operações para acessar elementos por índice, pesquisar elementos na lista e iterar sobre a lista. Recomendada quando precisar de acesso aleatório.
<br>
`Set` é uma coleção que não permite elementos duplicados. A interface `Set` estende a interface `Collection` e não adiciona operações próprias.
<br>
`Queue` é uma coleção que representa uma fila, onde os elementos são inseridos no final e removidos do início. A interface `Queue` estende a interface `Collection` e adiciona operações para inserir, remover e inspecionar elementos na fila. A ordem de seus elementos pode ser definida por prioridade, através da implementação da interface `Comparable` ou `Comparator`.
<br>
`Map` é uma coleção que mapeia chaves a valores. A interface `Map` não estende a interface `Collection` e não adiciona operações próprias.
<br>
`SortedSet` é uma coleção ordenada que não permite elementos duplicados. A interface `SortedSet` estende a interface `Set` e possibilita a classificação natural dos elementos.
<br>

## Classes ou Implementações

- `ArrayList` é uma implementação de `List` que utiliza um array para armazenar os elementos, mas o tamanho do array pode ser aumentado dinamicamente. A busca de elementos é rápida, mas a inserção e remoção de elementos podem ser lentas. Recomendada quando precisar de acesso aleatório.
<br>
- `LinkedList` é uma implementação de `List` que utiliza uma lista duplamente encadeada para armazenar os elementos. A busca de elementos é lenta, mas a inserção e remoção de elementos são rápidas. Recomendada quando precisar de inserção e remoção de elementos.
<br>
- `HashSet` é uma implementação de `Set` que utiliza uma tabela de dispersão para armazenar os elementos, os objetos são organizados pelo código hash. A busca de elementos é rápida, mas a ordem dos elementos não é garantida. Recomendada quando exigir elementos únicos e não se importar com a ordem.
<br>
- `LinkedHashSet` é uma implementação de `Set` derivada de `HashSet` mas mantém uma lista duplamente encadeada de todos os elementos. Mantém a ordem de inserção. Recomendada quando exigir elementos únicos e se importar com a ordem.
<br>
- `TreeSet` é uma implementação de `SortedSet` que utiliza uma árvore para armazenar os elementos. Os elementos são ordenados de acordo com a ordem natural dos elementos ou de acordo com um `Comparator` fornecido. O acesso é lento. Recomendada quando exigir elementos únicos e com a ordem natural.
<br>
- `HashMap` é uma implementação de `Map` que utiliza uma tabela de dispersão para armazenar os pares chave-valor. A ordem dos elementos não é garantida. Recomendada quando exigir pares chave-valor e não se importar com a ordem.
<br>
- `LinkedHashMap` é uma implementação de `Map` derivada de `HashMap` mas mantém uma lista duplamente encadeada de todos os elementos. A ordem de inserção é mantida. Recomendada quando exigir pares chave-valor e os elementos são iterados na ordem de inserção.
<br>
- `TreeMap` é uma implementação de `SortedMap` que utiliza uma árvore para armazenar os pares chave-valor. Os elementos são ordenados de acordo com a ordem natural das chaves ou de acordo com um `Comparator` fornecido. Recomendada quando exigir pares chave-valor e a ordem natural das chaves. Semelhante ao `TreeSet`.

## Complexidade de Tempo

| Operação | ArrayList | LinkedList | HashSet | LinkedHashSet | TreeSet | HashMap | LinkedHashMap | TreeMap |
|----------|-----------|------------|---------|---------------|---------|---------|---------------|---------|
| add      | O(n)      | O(1)       | O(1)    | O(1)          | O(log n)| O(1)    | O(1)          | O(log n)|
| remove   | O(n)      | O(n)       | O(1)    | O(1)          | O(log n)| O(1)    | O(1)          | O(log n)|
| contains | O(n)      | O(n)       | O(1)    | O(1)          | O(log n)| O(1)    | O(1)          | O(log n)|
| get      | O(1)      | O(n)       | -       | -             | O(log n)| -       | -             | O(log n)|
| put      | -         | -          | -       | -             | -       | O(1)    | O(1)          | O(log n)|

## Referências
[DevMedia - Java Collections](https://www.devmedia.com.br/java-collections-como-utilizar-collections/18450)
<br>
[Time Complexity of Java Collections](https://www.baeldung.com/java-collections-complexity)