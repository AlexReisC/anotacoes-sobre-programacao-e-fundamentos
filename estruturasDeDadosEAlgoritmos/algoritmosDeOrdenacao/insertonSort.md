# Ordenação por Inserção (Insertionsort)
O algoritmo consiste em imaginar uma lista e adicionar um novo elemento e então compara-lo com o anterior, se for menor faz a troca de posições e compara com o novo elemento anterior. O processo se repete.

```
    para i := 2 até n
        prov := L[i]; valor := L[i].chave
        j := i-1
        enquanto j >= 1 e L[j].chave faça
            L[j+1] := L[j]
            j := j-1
        L[j+1] := prov
```
Complexidade O(n²)