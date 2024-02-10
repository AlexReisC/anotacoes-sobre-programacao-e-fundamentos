# Garbage Collector (O coletor de lixo)
Garbage Collector em Java é um processo pelo qual programas Java executam gerenciamento de memória automático. Programas Java são compilados em byte-code que podem ser rodados na JVM. Quando programas rodam na JVM, objetos são criados na heap, que é uma parte de memória dedicada para o programa. Ao passar do tempo alguns objetos não vão ser mais necessários, então o garbage collector os deleta para liberar espaço na memória.
<br>
É um processo automático de olhar a memória heap e identificar quais objetos estão em uso e quais não, e deletar esses objetos não usados. Um objeto em uso (também chamado de vivo), ou referenciado, significa que uma parte do progrma mantém um ponteiro apontando para aquele objeto. Objetos não usados (também chamado de morto), ou sem referência, não são referênciados por nenhuma parte do programa.
<br>

## O que são roots de Garbage Collector?
Colectores de lixo funcionam sobre o conceito de Garbage Collector Roots para identificar objetos usados ou não usados.
Exemplos dessas roots:
- Classes executadas pelo executor de classes do sistema (com exceção dos executores de classes customizadas)
- Threads ativas
- Variáveis locais e parâmetros dos métodos em execução
- Variáveis locais e parâmetros de métodos JNI (Java Native Interface)
- Referências globais de JNI
- Objetos utilizados como monitores para sincronização
- Objetos mantidos da coleta de lixo pela JVM para seus fins

## Etapas da coleta de lixo
O garbage collector percorre o grafo  de objetos da memória, comceçando pelas roots e suas referências posteriores.
O GC visita um objeto e o marca como acessível (usado). Objetos que não podem ser visitados são considerados mortos (não usados).
<br>
Após essa etapa de visita, temos um  espaço de memória ocupado por objetos usados e não usados. Agora a liberação de fragmentos de memória que contêm os objetos não usados.
<br>
Os objetos removidos não necessariamente estavam em posições contíguas da memória. A memória então é compactada para que os objetos remanescentes estejam um após o outro. Isso facilita alocar memória para novos objetos de forma sequencial.

## Coleta de lixo geracional
Os coletores de lixo implementam uma estratégia chamada coleta geracional, que categoriza os objetos por idade. Percorrer toda a uma lista de objetos na memória para marcar e compactar é ineficiente, visto que quanto mais objetos maior a lista, levando a um tempo mais longo de coleta.
<br>
A maioria dos objetos tem uma vida muito curta. Por isso o Java realiza a coleta de lixo por gerações.
por
### Geração Jovem


### Geração Velha


### Geração Permanente


## Referencias
[Coletor de lixo em Java](https://www.freecodecamp.org/portuguese/news/coletor-de-lixo-em-java-o-que-e-a-coleta-de-lixo-e-como-ela-funciona-na-jvm/)
<br>
[Garbage Collector in Java](https://www.geeksforgeeks.org/garbage-collection-java/)