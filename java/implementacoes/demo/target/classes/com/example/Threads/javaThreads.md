# Threads
Toda aplicação Java possuí pelo menos uma thread, esta criada pela JVM quando iniciamos a aplicação e sua função  é executar o método **main()**. Ela executará sequencialmente os códigos contidos neste método até que temrine.

Duas maneiras de criar threads:
- Estender a classe **Thread (java.lang.Thread)**
- Implementar a interface **Runnable (java.lang.Runnable)**

É possível manipular as threads utilizando alguns método:
- O método estático **Thread.sleep()**, por exemplo, faz com que a thread em execução espere por um período de tempo sem consumir muito (ou possivelmente nenhum) tempo de CPU;
- O método **join()** congela a execução da thread corrente e aguarda a conclusão da thread na qual esse método foi invocado;
- Já o método **wait()** faz a thread aguardar até que outra invoque o método **notify()** ou **notifyAll()**; e
- O método **interrupt()** acorda uma thread que está dormindo devido a uma operação de **sleep()** ou **wait()**, ou foi bloqueada por causa de um processamento longo de I/O.

## Concorrência de dados
A concorrência de dados é um dos principais problemas a se enfrentar quando empregamos multithreading em uma aplicação. Ela é capaz de gerar desde inconsistência nos dados compartilhados até erros em tempo de execução.

Uma boa forma de evitar problemas de concorrência é sincronizar as threads que compartilham dados entre si. O sincronismo previne que duas ou mais threads acessem o mesmo recurso simultaneamente.<br>
[Thread assincrona](test/ThreadAssincronaTest01.java)<br>
[Thread assincrona](test/ThreadAssincronaTest02.java)

## Sincronização de Threads
Todo objeto Java possui um lock associado, que pode ser disputado por qualquer trecho de código sincronizado e em qualquer thread.<br>
[Sincronização: bloco sincronizado](test/BlocoSincronizadoTest01.java)<br>
Um bloco sincronizado previne que mais de uma thread consiga executá-lo simultaneamente. Para isso, a thread que for utilizar esse bloco adquire o lock associado ao objeto sincronizado e as demais que tentarem acessá-lo entrarão em estado de BLOCKED, até que o objeto seja liberado.

Os possiveís estados que uma thread pode assumir:
- **New**: A thread dica neste estado após criar sua instância e antes de invocar o método start();
- **Runnable**: Indica que ela está executando na máquina virtual Java;
- **Blocked**: Ainda está ativa, mas está à espera por algum recurso que está em uso por outra thread;
- **Waiting**: Quando neste estado, ela está à espera por tempo indeterminado pelo fato de outra thread ter executado uma determinada ação. Isto ocorre quando se invoca o método wait() ou join(), por exemplo;
- **Timed_Waiting**: Neste estado a thread está à espera de uma operação por um tempo pré-determinado. Por exemplo, esta situação ocorre ao invocar métodos como Thread.sleep(sleeptime), wait(timeout) ou join(timeout); e
- **Terminated**: Este estado sinaliza que o método run() finalizou.

Outra forma de acessar um dado compartilhado entre threads é criando um método sincronizado. Essa técnica é muito parecida com a anterior, mas ao invés de sincronizar o mesmo bloco de código em cada thread, ele é transferido para um método que contém a notação **synchronized** na assinatura. Assim, as threads terão que invocá-lo para realizar a operação sobre o dado concorrente.

> Nota: Ao sincronizar operações, prefira sempre o uso de métodos sincronizados no lugar de blocos desse tipo. Isso porque os bytecodes gerados para um método sincronizado são relativamente menores do que os gerados para um bloco sincronizado.

[Sincronização: método sincronizado](test/MetodoSincronizadoTest01.java)

> Nota: O ato de adquirir bloqueios para sincronizar threads consome tempo, mesmo quando nenhuma precisa aguardar a liberação do objeto sincronizado. Esse processo é uma faca de dois gumes: se por um lado ele resolve problemas de concorrência, por outro serializa o processamento das threads sobre esse bloco; ou seja, as threads nunca estarão processando esse código simultaneamente, o que pode degradar o desempenho. Portanto, esse recurso deve ser usado com moderação e somente onde for necessário.

## Variavéis atômicas
Quando é preciso utilizar tipos primitivos de forma concorrente uma boa opção é adotar seu respectivo tipo atômico, presente no pacote **java.util.concurrent.atomic**. Este tipo de objeto disponibiliza operações como incremento através de métodos próprios e são executadas em baixo nível de hardware, de forma que a thread não será interrompida durante o processo. Deste modo não é necessário sincronizar o objeto, gerando um algoritmo sem bloqueios e muito mais rápido.

```java
private static AtomicInteger varCompartilhada = new AtomicInteger(0);
```

Neste caso, ao invés de utilizar um Integer para armazenar o valor, foi instanciado um AtomicInteger. Com isso, pode-se trocar o varCompartilhada++ pela chamada **varCompartilhada.incrementAndGet()**, que realizará uma função semelhante de forma atômica, o que garantirá que a thread não seja interrompida no meio do processo de incremento da variável.

## Interface Callable
E se precisássemos executar uma tarefa em paralelo e ao final obter um resultado como retorno? A interface **Callable** oferece um método **call()**, que pode retornar um objeto qualquer, além da grande vantagem de poder capturar uma exceção gerada pela tarefa da thread.

Para tirar proveito dos benefícios de um objeto Callable, é altamente recomendável não utilizar um objeto Thread para executá-lo, e sim alguma outra API, como:
- **ExecutorService**: É uma API de alto nível para trabalhar diretamente com threads. Permite criar um pool de threads, reutilizá-las e gerenciá-las; e
- **ExecutorCompletionService**: É uma implementação da interface CompletionService que, associada a um ExecutorService, permite, através do método take(), receber o resultado de cada tarefa conforme elas vão finalizando, independente da ordem em que as tarefas foram criadas.

