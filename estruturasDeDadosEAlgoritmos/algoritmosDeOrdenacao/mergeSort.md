# Ordenação por intercalação (Mergesort)
A ideia básica do método é intercalar as duas metades da lista desejada quando estas já se encontram ordenadas. Na realidade, deseja-se então ordenar primeiramente as duas metades, o que pode ser feito utilizando recursivamente o mesmo conceito.
<br>
Sejam duas listas *A* e *B*, ordenadas, com respectivamente *n* e *m* elementos. As duas listas são percorridas por ponteiros *ptA* e *ptB*, armazenando o resultado da intercalação na lista *C*, apontada pelo ponteiro *ptC*. O primeiro elemento de *A* é comparado com o primeiro elemento de *B*; o menor valor é colocado em *C*. O ponteiro da lista onde se encontra o menor valor é incrementado, assim como o ponteiro da lista resultado; o processo se repete até que uma das listas seja esgotada. Neste ponto, os elementos restantes da outra lista são copiados na lista resultado.
<br>
Seja L a lista que se deseja ordenar. O método de ordenação por intercalação consiste em dividir a lista original em duas metades e ordená-las; o resultado são duas listas ordenadas que podem ser intercaladas. Para ordenar cada uma das metades o processo considerado é o mesmo, sendo o problema dividido em problemas menores, que são sucessivamente solucionados.

```
    mergeSort(esq, dir)
        se esq < dir então
            centro := (esq+dir)/2
            mergeSort(esq, centro)
            mergeSort(centro+1, dir)
            intercalar(esq, centro+1, dir)
    
    intercalar(L, Tmp, ini1, ini2, fim2)
        fim1 := ini2 – 1; nro := 0
        ind := ini1
        enquanto (ini1 <= fim1) e (ini2 <= fim2) faça
        se L[ini1].chave se L[ini1] L[ini2].chave então
            Tmp[ind] := L[ini1]
            ini1 := ini1 + 1
        senão Tmp[ind] := L[ini2]
            ini2 := ini2 + 1
        ind := ind + 1; nro := nro + 1
        enquanto {ini1 <= fim1} faça
            Tmp[ind] := L[ini1]
            ini1 := ini1 + 1; ind := ind + 1; nro := nro + 1
        enquanto {ini2 ≤ fim2} faça
            Tmp[ind] := L[ini2]
            ini2 := ini2 + 1; ind := ind + 1; nro := nro + 1
        para i := 1 até nro faça
            L[i + ini1 – 1] := Tmp[i + ini1 – 1]
        mergesort (1, n)
```
A complexidade do pior caso é O(n log n).
