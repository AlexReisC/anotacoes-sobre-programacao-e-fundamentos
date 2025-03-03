# Heap (Fila de prioridades)
Heap é uma lista linear onde cada elemento armazena um dado e sua prioridade de modo que: 
- H[i] > H[2i] (ou H[i] < H[i/2])
- H[i] > H[2i+1], Para 1 <= i <= n.

Exemplo: [33, 32, 38, 31, 29, 26, 25, 30, 27]

Essa estrutra pode ser representada visualmente na forma de uma árvore binaria, onde cada nó possui prioridade maior que seus dois filhos, se existirem. Na memória a estrutra está disposta como uma lista linear sequencial.

As condições anteriormente descritas implicam que o elemento de maior prioridade sempre é o primeiro, ou seja, a raiz da árvore.
- seleção: O(1)
- inserção: O(log n) 
- remoção: O(log n)
- alteração: O(log n)
- construção: O(n)

## Alteração de prioridade
De modo geral, uma operação que se deseja realizar no heap está associada a "subir" ou "descer" num caminho da árvore. Associa-se então o aumento de prioridade à "subida" e a diminuição à "descida". OS algoritmos correspondentes a estas operações são:

Algoritmo subir() recursivo
```
    subir(i)
        j := i/2
        se j >= 1 então
            se H[j].chave < H[i].chave então
                torcar (H[j], H[i])
                subir(j)
```

Algoritmo subir() iterativo
```
    subir(i)
        j := i/2
        enquanto j >= 1 e H[j].chave < H[i].chave
            torcar H[j] <=> H[i]
            i := j
            j := i/2
```

Algoritmo descer() recursivo
```
    descer(i,n)
        j := 2*i
        se j <= n então
            se j < n então
                se H[j].chave < H[j+1].chave então
                    j := j+1
            se H[i].chave < H[j].chave então
                trocar (H[i], H[j])
                descer(j,n)
        
```

Algoritmo descer() iterativo
```
    descer(i,n)
        j := 2*i
        enquanto j <= n faça
            se j < n então
                se H[j].chave < H[j+1].chave então
                    j := j+1
            se H[i].chave < H[j].chave então
                trocar (H[i], H[j])
                i := j
                j := 2*i
            senão
                j := n+1
```

As complexidades dos algoritmos subir() e descer() **recursivos** são as mesmas de percorrer o caminho de uma árvore binária completa: O(log n)

## Inserção de elemento
Suponha a inserção de um novo elemento, a lista agora passará a ter n+1 elementos. Obviamente o lista não respeita mais a propriedade de heap. O procedimento a seguir corrige esse problema.
```
    inserir(x)
        H[n+1] := x
        n := n+1
        subir(n)
```

Complexidade igual ao algoritmo subir(): O(log n)

## Remoção de elemento
A remoção é feita sempre com o de maior prioridade, logo a sua posição fica vazia e a lista passa a ter n-1 elementos, o último elemento então deve preenche-la mas como sua prioridade está deslocada a lista deve ser corrigida.
```
    remover()
        se n != 0 então
            H[1] := H[n]
            n := n-1
            descer(1, n)
        senão "lista vazia"
```

A complexidade desse algoritmo depende do algoritmo descer(): O(log n)

## Construção de um heap
Observando que toda lista ordenada corresponde a um heap, podemos construir um através da ordenação de uma lista.
```
    construirHeap()
        para i := 2 até n faça
            subir(i)
```
Complexidade O(n log n)

Uma solução alternativa é descrita observando que para um nó sem filhos satisfaz as propriedades de heap, isto é, todo nó alocado a partir da posição n/2 + 1. Por essa razão, na construção de um heap os únicos nós relevantes são os internos da árvore. Estes devem ter suas prioridades verificadas e acertadas.

```
    construirHeapOtimizado()
        para i := n/2 até 1 faça
            descer(i,n)
```
Complexidade linear: O(n)
