# Pilha
É um tipo especial de lista linear, com a restrição e que inserções e remoções ocorrem na mesma extremidade.

## Alocação Sequencial
Temos um ponteiro chamado *topo* para indicar o topo da pilha,ou seja, o elemento da extremidade. Os algoritmos abaixo implementam inserção e remoção na pilha, considerando uma mmória de M posições.

**Inserção na pilha**
```
    se topo != M então
        topo := topo+1
        P[topo] := novo-valor
    senão *overflow*
```

**Remoção na pilha**
```
    se topo != 0 então
        valor-recuperado := P[topo]
        topo := topo - 1
    senão *underflow*
```
A complexidade das operações é O(1).

## Alocação Encadeada

