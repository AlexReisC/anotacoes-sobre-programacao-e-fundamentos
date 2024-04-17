# Fila
É um tipo especial de lista linear com as mesmas priprieadades, mas com a restrição de que a inserção ocorre no final e remoção no começo da fila.

## Alocação Sequencial
São necessários dois ponteiros: início de fila (*f*) e retaguarda (*r*). Para a adição de um elemento, move-se o ponteiro *r*; para a retirada, move-se o ponteiro *f*. A situação de fila vazia é representada por *f* = *r* = 0.
<br>
À medida que os ponteiros são incrementados na memória disponível, a fila “se move”, o que pode dar origem à falsa impressão de memória esgotada. Para eliminar esse problema, consideram-se os M nós alocados como se estivessem em círculo, onde F[1] segue F[M]. 
<br>
*A inicialização de *f* e *r* é *f = r = 0*.

**Inserção na fila**
```
    prov := r mod M + 1
    se prov != f então
        r := prov
        F[r] := novo-valor
        se f == 0 então
            f := 1
    senão *overflow*
```

**Remoção**
```
    se f != 0 então
        valor-recuperado := F[f]
        se f == r então
            f := r := 0
        senão
            f := f mod M + 1
    senão *underflow*
```
Operações de tempo constante.

## Alocação Encadeada

