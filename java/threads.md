# O básico de Threads no Java
Este artigo aborda tópicos sobre Concorrência e Paralelismo, primeiro de tudo vamos entender o que é uma **thread**.

## O que é uma Tthread?
Processos de um computador são os programas em execução. Sendo assim, uma thread seria como um subprograma dentro de um processo. É uma linha de execução ou caminho que o processador pode seguir para realizar tarefas. Cada processo pode ter várias threads, permitindo que multiplas tarefas sejam realizadas concorrentemente.

## O que é uma thread no Java?
Geralmente, todos os programas tem pelo menos uma thread, conhecida como thread principal, que é provida pela JVM no começo da execução do programa. Neste ponto, quando a thread principal é dada, o método _main()_ é invocado pela thread principal.

No Java existe uma classe _java.lang.Thread_ usada para criar threads. A JVM permite que uma aplicação tenha multiplas threads rodando concorrentemente. Cada uma tem uma prioridade. Threads com prioridade alta são executadas em precedência as de baixa.

## Criando uma thread no Java
Uma thread pode ser criada de duas formas:
- Extendendo a classe _java.lang.Thread_
Neste caso, a thread é criada pela nova classe que extende a classe _Thread_, criand uma instância desta. O método _run()_ incluí a funcionalidade que supon-se ser implementada pela Thread.
Exemplo:

```java
public class MyThread extends Thread {
    public void run(){
        System.out.println("thread is running...");
    }
    public static void main(String args[]){
        MyThread obj = new MyThread();
        obj.start();
    }
}
```
_start()_ é usado para criar uma nova thread e torna-la executavel.

- Implementando a interface _Runnable_
Este método é mais fácil para criar uma thread. Neste caso, a classe é criada para implementar a interface _Runnable_ e depois o método _run()_.
O código para exeutar a thread deve sempre ser escrito dentro do método _run()_.

```java
public class MyThread implements Runnable {
    public void run(){
        System.out.println("thread is running...");
    }
    public static void main(String args[]){
        Thread t = new Thread(new MyThread());
        t.start();
    }
}
```
O método _start()_ chama o método _run()_. Quando o método start() é chamado, uma nova pilha é dada para a thread, e o método run() é invocado para a nova thread no programa.

## Prioridades das threads
O número de serviços atribuídos a uma thread é designado pela prioridade. A qualquer thread gerada na JVM é dada uma prioridade. A prioridade escala de 1 a 10.
- 1 é conhecido como prioridade mais baixa.
- 5 é conhecido como prioridade padrão.
- 10 representa a prioridade mais alta.

A prioridade da thread principal é 5 por padrão, e cada thread filha vai ter a mesma prioridade da thread pai. Nós podemos ajustar a prioridade de qualquer thread, é recomendado usar as constantes da classe _Thread_:
_Thread.MIN_PRIORITY_;
_Thread.NORM_PRIORITY_;
_Thread.MAX_PRIORITY_;

```java
public class ThreadPriority extends Thread {
    public void run(){
        System.out.println("thread is running..." + 
        Thread.currenThread().getPriority());
    }
    public static void main(String args[]){
        ThreadPriority m1 = new ThreadPriority();
        ThreadPriority m2 = new ThreadPriority();
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        m2.start();
    }
}
```