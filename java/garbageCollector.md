# Garbage Collector ( O coletor de lixo)
Garbage Collector em Java é um processo pelo qual programas Java executam gerenciamento de memória automático. Programas Java são compilados em byte-code que podem ser rodados em uma JVM. Quando programas rodam na JVM, objetos são criados na heap, que é uma parte de memória dedicada para o programa. Ao pasar do tempo alguns objetos não vão ser mais necessários, então o garbage collector os delete para liberar espaço na memória.
<br>
É um processo automático de olhar a memória heap e identificar quais objetos estão em uso e quais não, e deletar esses objetos não usados. Um objeto em uso, ou referenciado, significa que uma paret do progrma mantém um ponteiro apontando para aquele objeto. Objetos não usados, ou sem referência, não referênciados por nenhuma parte do programa.
<br>

## Tipos de atividade do Garbage Collector


## Referencias
[Coletor de lixo em Java](https://www.freecodecamp.org/portuguese/news/coletor-de-lixo-em-java-o-que-e-a-coleta-de-lixo-e-como-ela-funciona-na-jvm/)
<br>
[Garbage Collector in Java](https://www.geeksforgeeks.org/garbage-collection-java/)