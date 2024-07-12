# Expressões Lambdas
`parametro -> expressão`.
<br>
Para trabalhar com lambdas precisamos obrigatoriamente ter uma *interface* funcional (aquela que contém apenas um *método abstrato*), com qualquer interface desta pode ser utilizada uma lambda. As lambdas são anônimas e não estão atreladas a nenhuma classe, por isso são chamadas de funções. O método da interface funcional diz como a lambda vai se comportar.
<br>
Exemplos: 
<br>
`Predicate<T>`: essa interface funcional recebe um tipo qualquer e retorna um booleano.
<br>
`Consumer<T>`: interface funcional que recebe um tipo qualquer e o retorno do seu método é `void`.
<br>
`Function<T, R>`: recebe um tipo *T* como parametro e retorna um tipo *R*.
<br>
Method reference: sintaxe da lambda que encurta a chamada do método, quando a expressão lambda só chama um método. Ex.: `s -> String::lenght`
<br>
**Tipos de method reference**
<br>
- Referencia para um método estático: `classe::metodoEstatico`
- Referencia para um método não estático com um objeto: `objeto::metodoNaoEstatico`
- Referencia para um método não estático com a classe: `classe::metodoNaoEstatico`
- Referencia para um construtor: `classe::new`
