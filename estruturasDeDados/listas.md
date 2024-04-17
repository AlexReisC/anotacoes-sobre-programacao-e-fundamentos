# Listas
Uma Lista linear é um conjunto de n >= 0 elementos L[1], L[2], ..., L[n]. Tal que:
- se n > 0, L[1] é o primeiro elemento
- para 1 <= k <= n, o nó L[k] é precidido pelo L[k-1].

As operações mais frequentes em listas são a *busca*, a *inclusão* e a *remoção* de um determinado elemento.
<br>
Se as inserções e remoções são permitidas apenas nas extremidades da lista, ela recebe o nome de *deque* (*double end queue*). Se as inserções e as remoções são realizadas somente em um extremo, a lista é chamada *pilha*, sendo denominada *fila* no caso em que inserções são realizadas em um extremo e remoções em outro.
<br>
O tipo de armazenamento de uma lista linear pode ser classificado de acordo com a posição relativa (sempre contígua ou não) na memória de dois nós consecutivos na lista.

## Alocação sequencial
A maneira mais simples de se manter uma lista linear na memória do computador é colocar seus nós em posições contíguas. Nesse caso, o endereço real do (j + 1)-ésimo nó da lista se encontra c unidades adiante daquele correspondente ao j-ésimo. A constante c é o número de palavras de memória que cada nó ocupa.
<br>
Seja uma lista linear. Cada nó é formado por *campos*, que armazenam as características distintas dos elementos da lista. Além disso, cada nó da lista possui, geralmente, um identificador, denominado *chave*. Para evitar ambiguidades supõe-se que todas as chaves são distintas. Os nós podem ser ordenadso ou não, segundo suas chaves.
<br>

**Busca por um nó conhecendo sua chave**
```
    busca1(x):
        i:=1; busca1:=0
        enquanto i <= n faça
            se L[i].chave == x então
                busca1:=i
                i:=n+1
            senão
                i:=i+1
```

**Algoritmo que cria um novo nó com a chave procurada**
```
    busca(x):
        L[n+1]:=x; i:=1
        enquanto L[i].chave != x faça
            i:=i+1
        se i != n+1
            busca:=i
        senão
            busca:=0
```
Ambos algoritmos tem complexidade do pior caso O(n). Mas o segundo é mais rápido por fazer menos comparações.
<br>

**Busca por um elemento na lista ordenada**
```
    busca-ordenada(x):
        L[n+1]:=x; i:=1
        enquanto L[i].chave < x faça
            i:i+1
        se i == n+1 ou L[i].chava != x então
            busca-ordenada:=0
        senão
            busca-ordenada:=i
```
Complexidade O(n).
<br>

**Busca Binária**
```
    busca-bin(x):
        inf:=1; sup:=n; busca-bin:=0
        enquanto inf <= sup faça
            meio:=(inf+sup)/2
            se L[meio].chave == x então
                busca-bin:=meio
                inf:=sup+1
            senão se L[meio].chave < x então
                inf:=meio+1
            senão
                sup:=meio-1

```
Complexidade O(log n).
<br>
As operações de inserção e remoção utilizam a busca, tanto para evitar chaves duplicadas quanto para encontrar o elemento a ser removido. Os algoritmos de inserir e remover a seguir consideram uma lista não ordenada. A memória pressuposta disopnível tem M posições (M+1 pois é necessária uma posição extra para a *busca*).
<br>

**Inserção de um nó com chave x**
```
    se n < M então
        se busca(x) == 0 então 
            L[n+1]:= novo-valor
            n:=n+1
        senão "elemento já existe"
    senão overflow
```

**Remoção de um nó com chave x**
```
    se n != 0 então
        indice:=busca(x)
        se indice != 0 então
            valor-recuperado:=L[indice]
            para i:=indice até n-1 faça
                L[i]:=L[i+1]
            n:=n-1
        senão "elemento não existe"
    senão underflow
```
Complexidade dde ambos é O(n).

## Alocação encadeada
Também conhecida por *aloção dinammica* uma vez que as posições de memória são alocadas conforme o necessário. Os nós de uma lista então encontram-se dispersos na memória e são interligados por ponteiros.
<br>
Qualquer estrutura, inclusive listas, que seja armazenada em alocação encadeada requer o uso de um ponteiro que indique o endereço de seu primeiro nó.


## Lista Circular


## Lista Duplamente Encadeada

