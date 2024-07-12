# Exceptions / Exceções
As excessões no Java são filhas da classe `Throwable`, os erros (Error) também são filhos de Throwable.

- `Throwable`
  - `Error`
  - `Exception`
    - `RunTimeException`
      - (NullPointerException, NumberFormatException, ClassCastException, IndexOfOutBoundException)
    - (IOException, SQLException, MalformedURLException)

## Erros
Erros representam condições irrecuperavéis que não podem ser tratados em tempo de execução, eles acontecem na JVM. Provavelmente deve se mudar o código e não devemos tentar captura-los.
<br>
Ex.: StackOverflow, biblioteca incompatível.

## Exceções
Exceções são eventos inesperados e indesejados que ocorrem em tempo de execução e atrapalham o fluxo normal do programa, elas podem ser capturadas e manipuladas pelo programa. Quando uma exceção ocorre em um método é criado um objeto. Ele contém informações como o nome e descrição da exceção e o estado do programa quando ocorreu.
Existem exceções Checked (checadas) e Unchecked (não checadas).<br>
**Exceções checadas**: São checadas em tempo de compilação pelo compilador, sem tratamento o código não compila. São filhas da classe `Exception` diretamente.<br>
**Exceções não checadas**: São o oposto das checadas. Exceções lançadas provavelmente por culpa do programador. São subclasse de `RunTimeException`.
<br>
É possível o programador lançar as próprias exceções: `throw new "Exception"(messagem)`
<br>
Exceções do tipo `RunTimeException` não precisam ter declaração na assinatura do método. A declaração serve para indicar que o método pode lançar uma excessão. Exceções do tipo checked precisam obrigatoriamente ser tratadas por quem chamou o método, mas uncheckeds não. Além disso, não é obrigatório tratar a exceção dentro do proprio método.
<br>
Métodos privados tem maior chance de ter que usar o `try catch` já que fora da sua classe ninguém tem acesso a ele.
<br>
É possível capturar multiplas exceções, através de multiplos blocos `catch`. O primeiro catch que corresponde com a exceção lançada é executado, mesmo que hajam outros que possam corresponder. Para boas praticas, um bloco mais generico não deve ficar na frente do outro. Também é possível colocar exceções que não estão na  mesma linha de herança. Como:<br>
`catch(SQLException | FileNotFoundException e)`. Isso não funciona em exceções da mesma linha de herança.
<br>
Essas formas de tratar uma exceção dependem do objetivo do programador.
<br>
**try with resources**: `try(Object object)` se encarrega de fechar a conexão da variavel de referência. Só se pode colocar objetos/variaveis de referência que implementem a interface `Closeable` ou `AutoCloseable`. Desse modo não é necessário que nos preocupemos de fechar o objeto (Por exemplo o `Reader reader`).
<br>
**Exceções Customizadas**: Para isso é necessário criar uma classe que extende ou uma checked ou uma unchecked e então o programador define o tratamento delas.
<br>
Ao sobrescrever um método não é obrigatório declarar as mesmas exceções que o método original declara. Pode se declarar apenas uma ou duas, mas tendo as declarado o programador é obrigado a trata-las onde o método foi chamado, entretanto exceções do tipo `RuntimeException` não te obrigam a fazer o tratamento. 
Também não se pode declarar um tipo mais genérico do que foi declarado no método original.

### Métodos da para tratar Exceções
printStackTrace(): imprime o caminho da pilha de execução do método que lançou a Exception<br>
getMessage(): retorna uma mensagem do que é o Throwable