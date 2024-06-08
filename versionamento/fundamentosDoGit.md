# Fundamentos de Git

## Obtendo um repositorio Git
Podemos fazer isso de duas formas. Inicializando um repositório em um diretorio local ou clonando um repositório Git existente de outro lugar.

### Inicializando um repositorio

Navegue até o diretorio desejado
```
$ cd c/Users/.../seu_repositorio
```

depois digite:
```
$ git init
```

Se você quer começar a controlar o versionamento dos arquivos existentes, você deve começar a monitorar os arquivos e fazer um commit inicial. O comando `git add` especifica quais arquivos você quer monitorar e `git commit` que realiza o commit.
```
$ git add *.c
$ git add LICENSE
$ git commit -m 'initial project version'
```

### Clonando um repositório
Para obter a cópia de um repositório Git existente, o comando é `git clone`. O Git recebe uma cópia completa de praticamente todos os dados que o servidor possui. Você clona um repositório com:
```
$ git clone [url]
```

É possível especificar o diretorio de destino que o repositório será copiado:
```
$ git clone [url] [nome_do_diretorio]
```



## Referência
[Progit: Capitulo 2]()