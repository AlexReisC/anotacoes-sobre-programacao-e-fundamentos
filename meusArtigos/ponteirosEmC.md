# Ponteiros
Ponteiro é um tipo de variável cuja função é armazenar um endereço de memória, **ele aponta para o elemento cujo o endereço está sendo guardado dentro dele**. Ponteiros podem ser de diferentes tipos de dados como `int`, `char`, `float` etc, mas um ponteiro só pode armazenar o endereço de uma variável do mesmo tipo que o seu.<br>

**Exemplo de declaração de um ponteiro**
```c
    int a = 10;
    int *ponteiro;
    *ponteiro = &a;
    printf("Valor de a: %d", *ponteiro); // imprime 10
```
O acesso ao conteúdo da variável que o ponteiro aponta é feito utilizando `*` , asterisco, antes do nome do ponteiro. Sem o asterisco estamos indicando que queremos o endereço de memória em si. Exemplo:
```c
    char nome = "Alex";
    char *ponteiroDeNome= &nome;

    printf("Nome: %d", ponteiroDeNome); // imprime 10943584 (exemplo de endereço da variável 'nome')
```

## Ponteiros e Funções

Em C, ponteiros podem ser usados como parametro de funções. Nesse caso na chamada da função é passado um endereço de memória, este tipo de passagem é chamada de referência.<br>
**Exemplo:**
```c
    void incremento(int *x){
        *x = *x + 1;
    }

    int main(){
        int a = 5;
        incremento(&a);

        printf("%d", a); // imprime 6
        return 0;
    }
```

## Ponteiros e Vetores
Quando criamos um vetor estamos gerando um endereço de memória para cada elemento. Podemos armazenar o endereço do vetor em um ponteiro e percorrer o vetor através do ponteiro.
```c
    int main(){
        int a[5] = {2, 5, 6, 1, 9};
        int *p = &a[0]; // endereço da primeira posição do vetor
        
        printf("%d", *p); // imprime 2
        printf("%d", *(p+1)); // imprime 5
        printf("%d", *(p+3)); // imprime 1
        printf("%d", (p+3)); // imprime o endereço de a[3];
        return 0;
    }
```
Percebe-se que quando utilizamos `(p+1)` estamos andando para a próxima posição de memória, com `*(p+1)` acessamos seu valor, mas sem o asterico neste caso acima imprimimos o endereço de memória. É possível também decrementar uma posição com `*(p-1)`.<br>
Passando vetor como argumento através de ponteiro:
```c
    int soma(int *vet, int tam){
        for(int i=0; i<tam; i++){
            soma += *(vet+i);
        }
        return soma;
    }

    int main(){
        int a[5] = {1, 2, 3, 4, 5};
        int total =soma(&a, 5);
        printf("%d", total);
        return 0;
    }
```

## Alocação dinamia de memória
Anteriormente aprendemos que um ponteiro só pode armazenar endereços do mesmo tipo que o seu, mas se utilizarmos um ponteiro do tipo `void` podemos guardar endereços qualquer tipo.
```c
    int inteiro = 99;
    void *p;
    p = &inteiro;

    printf("%d", *p); // imprime 25
```

Em C, podemos manipular a memória por meio de funções/procedimentos que alocam determinada quantidade de bytes na memória. Chama-se alocação dinamica e pode ser feita por meio dos métodos `malloc()`, `calloc()`, `realoc()` e `free()`.
<br>
Variáveis e funções geralmente usam a região de memória chamada **stack** (pilha). Já as variáveis alocadas dinamicamente ficarão na **heap**.

### Função malloc()
