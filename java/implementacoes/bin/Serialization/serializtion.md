# Serialização
É o processo de conversão de um estado de um objeto em uma sequência de bytes, enquanto *Descerialização* é o 
processo inverso. A serialização é útil quando queremos salvar um objeto no disco ou envia-lo pela rede ou até serializado em uma JVM e descerializado em outra.
<br>
Para realizar uma serialização é necessário implementar a interface `java.io.Serializable` na classe. Para indicar que um atributo não deve ser serializado utiliza-se a palavra-chave `transient`.

## Serialização e Descerialização
A classe 