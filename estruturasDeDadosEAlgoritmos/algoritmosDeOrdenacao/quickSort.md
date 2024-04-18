# Ordenação Rápida (Quicksort)
Dada uma tabela L com *n* elementos, o procedimento recursivo para ordenar L consiste nos seguintes passos:
- se n = 0 ou n = 1 então a tabela está ordenada;
- escolha qualquer elemento x em L, este elemento é chamado pivô;
- separe L – {x} em dois conjuntos de elementos disjuntos: S1 = {w pertencente a L – {x}|w < x} e S2 = {w pertencente a L – {x}|w >= x}; o procedimento de ordenação é chamado recursivamente para S1 e S2;
- L recebe a concatenação de S1, seguido de x, seguido de S2.  

A escolha do pivô mais utilizada é tomar o primeiro elemento como tal. Isto é aceitável se a tabela é reconhecidamente aleatória. Se, entretanto, a tabela está ordenada na ordem inversa à desejada, esta escolha provoca o pior desempenho do algoritmo. A partição obtida nesse caso separa a tabela de tal forma que o conjunto S1 contém n – 1 elementos e o conjunto S2 é vazio. Sendo assim, o primeiro elemento não é uma boa escolha para pivô. Uma solução utilizada com bons resultados é a escolha da mediana dentre três elementos: o primeiro, o último e o central.
<br>
