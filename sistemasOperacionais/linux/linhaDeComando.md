# Linha de comando
O shell é basicamente um programa que recebe os comandos do teclado e os envia para o sistema operacional executar.

A maioria das Distribuições usam o seguinte formato de prompt (entrada) no shell:
```console
username@hostname:current_directory
pete@icebox:/home/pete $
```
Diferentes Distribuições tem diferentes prompts, mas neste caso o uso de $ é normal no Bash.

## echo
O comando echo apenas imprime os argumentos de texto no ecrã.
```console
$ echo Hello World
```
## pwd (print working directory)
Este comando significa "imprimir diretório de trabalho" e apenas mostra em qual diretório você está, observe que o caminho deriva do diretório raiz(root).
```
$ pwd
```

## cd (change dirctory)
Escolher o diretório que quer entrar
```
$ cd home/pete/Pictures
```

Atalhos para ajudar:
- `$ cd .` - diretório atual
- `$ cd ..` - diretório pai
- `$ cd ~` - diretório home, o seu diretório padrão como `home/pete/`
- `$ cd -` - diretório anterior

## ls (list directories)
Este comando vai listar todas as pastas e arquivos que estão dentro do diretório atual. Você também pode listar todas pastas dentro de um diretório especifico passando o caminho.
```console
$ ls
$ ls home/pete
```

Arquivos invisiveis podem ser vistos passando a tag `-a`.
```
$ ls -a
```

A tag `-l` lista uma série de informações: permissões de arquivo, númerom de links, nome do proprietário, grupo de proprietários, tamanho, data/hora da última modificação e o nome do arquivo/diretório.
```console
pete@icebox:~$ ls -l

total 80

drwxr-x--- 7 pete penguingroup   4096 Nov 20 16:37 Desktop

drwxr-x--- 2 pete penguingroup   4096 Oct 19 10:46  Documents

drwxr-x--- 4 pete penguingroup   4096 Nov 20 09:30 Downloads

drwxr-x--- 2 pete penguingroup   4096 Oct  7 13:13   Music

drwxr-x--- 2 pete penguingroup   4096 Sep 21 14:02 Pictures

drwxr-x--- 2 pete penguingroup   4096 Jul 27 12:41   Public

drwxr-x--- 2 pete penguingroup   4096 Jul 27 12:41   Templates

drwxr-x--- 2 pete penguingroup   4096 Jul 27 12:41   Videos
```

## touch
Permite criar um novo arquivo vazio.
```console
$ touch superfile
```

## file
Em Linux, os nomes de arquivos não são necessários para representar o conteúdo do arquivo. Você pode criar um arquivo chamado funny.gif que na realidade não é um GIF.

O comando `file` vai mostrar uma descrição do conteúdo do arquivo.
```console
$ file banana.jpg
```

## cat
Abreviatura da palavra concatenate (concatenar), que não só mostra o conteúdo dos ficheiros, como também pode combinar vários ficheiros e mostrar o resultado dos mesmos.
```console
$ cat dogfile birdfile
```

## less
Para vizualizar arquivos de texto muito maiores que um output simples. O texto vai ser páginado e você pode navegar página por página.
```console
$ less /home/pete/Documents/text1
```
Os seguintes comandos podem ser usados durante o less:
* q - sair do modo less
* setas do teclado - navegar pelo texto
* g - se mover até o começo do texto
* G - se mover para o final do texto
* /*search* - procurar por um texto específico dentro do documento.
* h - ajuda sobre o uso do less

## history
Usado para ver o histórico de comandos do shell.
```console
$ history
```

Para usar o comando anterior sem precisar digita-lo: **!!**

Se digitar Crtl+R e começar a digitar partes do comando que deseja, aparecerão correspondências e você pode navegar através delas.

Para limpar o terminal use:
```console
$ clear
```
## cp (copy)
Copiar arquivos
```console
$ cp mycoolfile /home/pete/Documents/cooldocs
```

mycoolfile é o arquivo que você quer copiar e /home/pete/Documents/cooldocs é para onde quer copiar.

Para copiar multiplos arquivos de um tipo
```console
$ cp *.jpg /home/pete/Pictures
```

## mv (move)
Usado para mover arquivos e renomear eles.

Você conegue renomear um arquivo:
```console
$ mv oldfile newfile
```

Ou um diretório:
```console
$ mv directory1 directory2
```

Você consegue mover um arquivo para um diretório diferente:
```console
mv file2 /home/pete/Documents
```

E mover mais de um:
```console
$ mv file_1 file_2 /somedirectory
```

Se você fizer mv de um arquivo ou diretório irá sobrescrever qualquer coisa no mesmo diretório. Por isso, pode utilizar a tag -i para o avisar antes de escrever algo por cima.
```console
$ mv -i file_1 file_2 /somedirectory
```

Digamos que quer fazer mv de um ficheiro para substituir o anterior. Também pode fazer uma cópia de segurança desse ficheiro e ele apenas renomeará a versão antiga com um ~.
```console
$ mv -b file_1 file_2 /somedirectory
```

## mkdir (make directory)
Cria um diretório se ele não existir
```console
$ mkdir books paintings
```

Você pode criar subdiretórios ao mesmo tempo com -p:
```console
$ mkdir -p books/hemmingway/favorites
```

## rm (remove)
Deletar arquivos e diretórios.
```console
$ rm file1
```

