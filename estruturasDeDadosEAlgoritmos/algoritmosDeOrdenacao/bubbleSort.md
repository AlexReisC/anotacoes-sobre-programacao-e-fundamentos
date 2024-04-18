# Ordenação Bolha (Bubblesort)
Cada iteração desse método se limita a percorrer a lista do inicio ao fim, trocando de posição de dois elementos consecutivos que estiejam fora de ordem. Ao terminar a primeira iteração o maior elemento está na última posição. Ao final da segunda iteração o segundo maior está posicionado e etc.

```
    para i := 1 até n faça
        para j := 1 até n-1 faça
            se L[j].chave  > L[j+1]>.chave então
                trocar(L[j], L[j+1])
```
O algoritmo acima é ruim e tem complexidade O(n²) para o pior e o melhor caso. Pode-se, entretanto, pensar em alguns critérios de parada que levariam em consideração comparações desnecessárias.
<br>
O primeiro critério de parada resulta do fato de que, se a tabela está ordenada, o algoritmo é executado em toda sua extensão desnecessariamente. Uma variável lógica *mudou* é então introduzida com a finalidade de sinalizar se pelo menos uma troca foi realizada. Caso isso não ocorra, o algoritmo pode ser encerrado.
<br>
A segunda modificação decorre do próprio método: como, a cada passo, um elemento é garantidamente transportado para o fim da lista, o número de elementos da mesma pode ser diminuído. Na realidade, a posição da última troca (armazenada, no algoritmo, na variável *guarda*) indica que todos os elementos posteriores já estão ordenados. O algoritmo pode então utilizar esta posição para atualizar o limite superior da lista, que inicialmente é o próprio número de elementos.

```
    mudou := V; n' := n; guarda := n
    enquanto mudou faça
        j := 1; mudou := F
        enquanto j < n' faça
            se L[j].chave < L[j+1].chave então
                trocar(L[j], L[j+1])
                mudou := V
                guarda := j
            j := j+1
        n' := guarda
```
Este segundo algoritmo tem complexidade de melhor caso de O(n), mas pro pior caso permanece em O(n²).