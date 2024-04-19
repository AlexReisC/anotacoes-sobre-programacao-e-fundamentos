# Tabela de Dispersão (Hash Table)
Problema: distribuir um conjunto de *n* chaves em uma tabela *T* com *m* posições.
<br>
As posições da tabela se situam no intervalo de [0, m-1]. Se as chaves tiverem numeração 0, 1, ... , m-1 respectivamente, pode-se utilizar o valor de cada uma como indice na tabela, técnica conhecida como acesso direto.
<br>
Para o caso geral, nem sempre as chaves são valores númericos por exemplo nomes de pessoas. Na realidade, esse questão pode ser resolvida utilizando código ASCII.
<br>
Um impedimento para uso sempre do acesso direto é que a quantidade de espaços na tabela pode ser proibitiva. Imaginando apenas duas chaves 0 e 999.999 a aplicação do acesso direto levarianos a uma tabela com 1.000.000, onde apena dois são ocupados.
<br>
Então usamos funções de dispersão *f*. Uma função que ao receber o valor *s* da chave, retorna um endereço *e* da tabela a ser ocupado: *f(s) = e*. Porém a função pode não garantir injetividade, já que pode retornar o mesmo endereço para dois valores de chaves distintas, ou seja, uma chave a ser inserida num endereço ocupado. Quando isso ocorre chamanos de *colisão*.

## Funções de Dispersão
Uma função de dispersão *h* transforma uma chave *s* em um endereço-base *h(s)* da tabela de dispersão. Objetivos:
- Produzir um numero baixo de colisões
- Ser facilmente computável: O(1)
- Ser uniforme: todas as posições da tabela devem ter a mesma probabilidade 1/m de serem ocupadas

### Método da divisão
A chave *x* é divida pela dimensão da tabela *m* e o resto da divisão é usado como endereço-base.Isto é, *h(x) = x mod m*.
<br>
Nesse caso, alguns valores de *m* são melhores outros. Por exemplo, se m é um número par, *h(x)* será par quando *x* for par e ímpar quando *x* for ímpar, o que certamente não satisfaz. A situação é ainda pior se m for potência de 2, caso em que *h(x)* dependerá apenas de alguns dígitos de *x*.
<br>
Existem alguns critérios que têm sido aplicados com bons resultados práticos, como escolher *m* de modo que seja um número primo não próximo a uma potência de 2. Ou, então, escolher *m* tal que não possua divisores primos menores que 20.

### Método da multiplicação
Este método apresenta algumas variações, sendo a mais conhecida o método do “meio do quadrado”. A chave é multiplicada por ela mesma (ou, uma alternativa, por uma constante), e o resultado é armazenado numa palavra de memória de *b* bits. O número de bits necessário para formar o endereço-base de uma chave é então retirado dos *b* bits, descartando-se os bits excessivos da extrema direita e da extrema esquerda da palavra. Assim, a dimensão possível para uma tabela de dispersão, quando o resultado da multiplicação se encontra em uma palavra de memória da qual se separam 10 bits, será de 1.024 endereços-base.

## Tratamento de colisões
Fator de carga: n/m (numero de elementos/tamanho do vetor).
<br>
- Fator de carga perto de 1: maior núemro de colisões.
- Fator de carga perto de 0: mais memória gasta.

### Encadeamento exterior
Cada endereço-base possui um ponteiro para uma lista encadeada distinta, cada nó tem um campo para a chave e outro para o ponteiro. Os nós correspondentes aos endereços-base serão apenas nós-cabeça para essas listas. As inserções são feitas no final de cada lista. 
<br>
Assim a busca, inserção e remoção de uma chave tem complexidade O(n).

### Encadeamento interior
Neste as listas encadeadas compartilham o mesmo espaço de memória da tabela.
<br>
**Armazenamento heterogêneo**: A tabela é divida em duas partes. Uma de tamanho *p* para os endereços-base e outra de tamanho *s* para os elementos que colidirem. Naturalmente *p + s = m*.
<br>
**Armazenamento homogêneo:** Não há divisão da tabela.
<br>
Note que se *p = 1* e *s = m-1*, então *T* é simplismente uma lista encadeada.

```
    busca(x)
        a:=0; end:=h(x); j:=null
        enquanto a == 0 faça
            se T[end].estado == não ocupado então
                j:=end
            se T[end].chave == x e T[end].estado == ocupado então
                a:=1
            senão
                end:=T[end].pont
                se end == h(x) então
                    a:=2
                    end:=j
```

