# I/O no java
Ler e escrever em um arquivo requer que o sistema operacional libera recursos para nosso sistema, então é necessário fechar o arquivo.

[Classe File](test/FileTest01.java)<br>
[Classe FileWriter](test/FileWriterTest01.java)<br>
[Classe FileReader](test/FileReaderTest01.java)<br>
O método *read()* lê um caracter de um arquivo e retorna um Integer que representa o caracter lido, ou retorna -1 se estiver no final do arquivo. Retorna a quantidade de caracteres lidos se estiver passando um array de *char* como parametro.

Em termos de desempenho as classes *BufferedWriter* e *BufferedReader* são mais indicadas.<br>
[BufferedWriter](test/BufferedWriterTest01.java)<br>
[BufferedWriter](test/BufferedReaderTest01.java)

[Criando diretorios](test/FileTest02.java)<br>
Para criar diretorios utilizamos a classe *File*, ela tem o método *mkdir()* que retorna um booleano indicando se foi criado ou não. Para criar um arquivo dentro de um diretorio podemos usar o diretorio criado com a classe *File*, ou seja, usamos a referência para o diretorio no construtor do arquivo a ser criado. Exemplo:<br> 
```java
    File diretorio = new File("pasta");
    diretorio.mkdir();
    File arquivo = new File(diretorio, "arquivo.txt");
    arquivo.createNewFile();
```
Para renomear um arquivo ou diretorio usamos o método *renameTo()*, o arquivo a ser renomado chama o método e o parametro é o objeto que tem o novo nome. Exemplo:<br> 
```java
    File arquivo2 = new File("arquivo_renomeado");
    arquivo.renameTo(arquivo2);
```

[Interface Path](test/PathTest02.java)<br>
*Path* foi criada para substituir a classe *File* tendo mais desempenho e mais métodos interessantes para se trabalhar com arquivos. Path representa um caminho que é a hierarquia da sequência composta por diretorios e arquivo separados por um delimitador("\" ou "/"). A classe *Paths* herda dessa interface, ela implementa métodos, como por exemplo obter um path de um diretorio e retornar como string. Há ainda a classe *Files* (que não tem relação com *File*) que consiste de métodos estáticos para operar com arquivos e diretórios.