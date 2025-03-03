# Árvores
Uma árvore *T* é um conjunto finito de elementos denominados *nós* tais que:
- T = {0}, a árvore é dita *vazia* ou
- existe um nó especial chamado *raiz* de *T(r(T))*; os nós restantes constituem um conjunto vazio ou são dividios em m >= 1 conjuntos disjuntos não vazios, as subárvores.

Um conjunto de árvores forma uma floresta. Se *v* é um nó de *T*, a notação *T(v)* indica uma subárvore de *T* com raiz *v*.

Os nós raízes *w1, w2, ..., wj* das subárvores de *T(v)* são chamados filhos de *v*. Se *z* é filho de *w1* então *w2* é tio de *z* e *v* é avô de *z*. O número de filhos de um nó é chamado de grau de saída desse nó. Se *x* pertence à subárvore *T(v)*, *x* é descendente de *v*, e *v*, ancestral de *x*. Um nó que não possuí descendentes próprios é chamado de folha. Toda árvore com n > 1 nós possuí no mínimo 1 e no máximo n - 1 folhas. Um nó não folha é dito interior.

Uma sequência de nós distintos *v1, v2, ..., vk*, tal que existe sempre entre nós consecutivos a relação "é filho de" ou "é pai de", é denominada *caminho* da árvore. O *comprimento k do caminho* é a quantidade de pares da relação ao longo do caminho. *Nível* de um nó *v* é o número de nós do caminho da raiz até o nó *v*. O nível da raiz portanto é 1. A *altura* de um nó *v* é o número de nós do maior caminho *v* até um dos seus descentes. A altura da árvore *T* é igual ao nível máximo de seus nós. Representa-se a altura de *T* por *T(h)*.

Uma árvore ordenada é aquela na qual os filhos de cada nó estão ordenados. Assume-se que tal ordenação se desenvolva da esquerda para a direita. 

## Árvores Binárias
Dentre as ávores, as binárias, são as mais comuns.
Uma *árvore binária* *T* é um conjunto finito de elementos denominados *nós* tais que:
- T = {0}, a árvore é dita *vazia* ou
- existe um nó especial chamado *raiz* de *T(r(T))*; os nós restantes são dividios em dois subconjuntos disjuntos, *Te(r(T))* e *Td(r(T))* a *subárvore esquerda* e a *direita* da raiz, respectivamente, as quais também são binárias.

A raiz da subárvore esquerda (direita) de um nó v, se existir, é denominada filho esquerdo (direito) de v. Naturalmente, o esquerdo pode existir sem o direito e vice-versa.

O número de subárvores esquerdas e direitas vazias em uma árvore binária com n > 0 nós é n + 1.

Uma *árvore estritamente binária* é uma árvore binária em que cada nó possui 0 ou 2 filhos. Uma *árvore binária completa* é aquela que apresenta a seguinte propriedade: se *v* é um nó tal que alguma subárvore de *v* é vazia, então *v* se localiza ou no último (maior) ou no penúltimo nível da árvore. Uma *árvore binária cheia* é aquela em que, se *v* é um nó com alguma de suas subárvores vazias, então *v* se localiza no último nível.

A árvore binária que possui altura máxima é aquela cujos nós interiores possuem exatamente uma subárvore vazia. Essas árvores são denominadas *zigue-zague*. Naturalmente, a altura de uma árvore zigue-zague é igual a n. Por outro lado, uma árvore completa sempre apresenta altura mínima.

Seja *T* uma árvore binária completa com n > 0 nós. Então *T* possui *altura h mínima*. Além disso, h = 1 + log n.


Uma *árvore m-ária* T, m ≥ 2, é um conjunto finito de elementos, denominados nós ou vértices, tais que
- T = Ø e a árvore é dita *vazia*, ou
- contém um nó especial chamado *raiz* de *T(r(T))*, e os restantes podem ser sempre divididos em m subconjuntos disjuntos, as i-ésimas subárvores de r(T), 1 ≤ i ≤ m, as quais são também árvores m-árias.
A raiz da i-ésima subárvore de um nó *v* de T, se existir, é denominada i-ésimo filho de *v*. Naturalmente, a árvore m-ária é uma generalização da árvore binária em que cada nó possui *m* subárvores. A árvore m-ária possui uma ordenação implícita nas subárvores de cada nó, mesmo que algumas ou todas essas subárvores sejam vazias.

Analogamente ao caso binário, podem-se definir *árvore estritamente m-ária, árvore m-ária completa e cheia*.

O armazenamento de árvores pode utilizar alocação sequencial ou encadeada. Sendo a árvore uma estrutura mais complexa do que listas lineares, as vantagens na utilização da alocação encadeada prevalecem.

Em árvores binárias cada nó deve possuir dois campos de ponteiros, *esq* e *dir*, que apontam para as suas subárvores esquerda e direita respectivamente. O ponteiro *ptraiz* indica a raiz da árvore. Necessita-se, então, de 2*n* + 1 (os dois campos mencionados e o campo com as informações do nó) unidades de memória para representar uma árvore binária com *n* nós.

### Percurso em Árvores Binárias
Para percorrer uma árvore deve-se visitar cada um de seus nós. Visitar um nó significa operar de alguma forma, com a informação a ele relativa. 

O *percurso em pré-ordem* segue recursivamente os seguintes passos, para cada subárvore da árvore:
- visitar a raiz
- percorrer sua subárvore esquerda, em pré ordem;
- percorrer sua subárvore direita, em pré ordem;
A variavel *pt*, parametro do procedimento, é um ponteiro que indica a raiz da subárvore que está sendo considerada na chamada atual. Em cada chamada, somente esse nó é analisado. Após a visita, é verificada a existência de uma subárvore esquerda. Se verdadeiro, então a chamada recursiva percorrerá toda essa subárvore antes de ir para a subárvore direita.

A versão não recursiva deve manter atualizados os caminhos percorridos a partir da raiz da árvore. Um forma de fazer isso é utilizando uma pilha. O nó é visitado ao ser colocado na pilha, enquanto que a retirada da pilha indica o final da visita cuja raiz é o nó considerado. Além disso, deve ser armazenada a direção do percurso, isto é, se o caminho tomado é é referente à subárvore esquerda ou direita. O nó só é retirado da pilha após ambos os caminhos percorridos.

```python
procedimento pre(pt)
    se pt != null então
        visita(pt)
        pre(pt.esq)
        pre(pt.dir)
```
```python
procedimento preNaoRecursivo(T)
    pt := T.raiz
    se pt == null então "arvore vazia"
    Pilha p = {}
    empilhar(p, pt)

    enquanto(p != null)
        pt := desempilhar(p)
        visita(pt)

        se pt.dir() != null então empilhar(p, pt.dir)
        se pt.esq() != null então empilhar(p, pt.esq)
```
O *percurso em ordem simetrica* segues os passos:
- percorrer sua subárvore esquerda, em ordem simétrica;
- visitar a raiz
- percorrer sua subárvore direita, em ordem simétrica;

```python
procedimento simet(pt)
    se pt != null então
        simet(pt.esq)
        visita(pt)
        simet(pt.dir)
```
```python
procedimento simetNaoRecursivo(T)
    pt := T
    se pt == null então "arvore vaiza"
    Pilha p = {}
    empilhar(p, pt)

    enquanto(p != null)
        se pt.dir() != null então empilhar(p, pt.dir)
        se pt.esq() != null então empilhar(p, pt.esq)
    
    enquanto(p != null)
        pt := desempilhar(p)
        visitar(pt)

```
Uma terceira alternativa de percurso, o *percurso pós-ordem*:
- percorrer a subárvore esquerda, em pós-ordem 
- percorrer a subárvore direita, em pós-ordem
- visitar a raiz
```python
procedimento pos(pt)
    se pt != null então
        pos(pt.esq)
        pos(pt.dir)
        visitar(pt)
```
