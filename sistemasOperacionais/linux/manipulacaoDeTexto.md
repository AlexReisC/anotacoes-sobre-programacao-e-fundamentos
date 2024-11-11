# Manipulação de texto

## stdout (standard out)
O seguinte trecho faz com que seja escrito "Hello World" dentro do arquivo 'peanuts.txt'. 
```console
$ echo Hello World > peanuts.txt
```

O > é um operador de redireccionamento que nos permite alterar o destino da saída padrão. Permite-nos enviar a saída do echo Hello World para um arquivo em vez de para o ecrã. Se o arquivo ainda não existir, ele irá criá-lo para nós. No entanto, se já existir, irá sobrescrevê-lo (pode adicionar uma flag da shell para evitar isto, dependendo da shell que está a utilizar).

E em vez de escrever por cima do arquivo, este comando irá escrever no final:
```console
$ echo Hello World >> peanuts.txt
```

## stdin (standard in)
```console
$ cat < peanuts.txt > banana.txt
```

Podemos usar o < para redirecionamento da entrada. Normalmente, no comando cat, envia-se um arquivo para ele e esse arquivo torna-se o stdin; neste caso, redireccionámos peanuts.txt para ser o nosso stdin. Então, a saída de cat peanuts.txt, que seria Hello World, é redireccionada para outro arquivo chamado banana.txt.

## stderr (standard error)


## pipe (barra vertical) e tee
