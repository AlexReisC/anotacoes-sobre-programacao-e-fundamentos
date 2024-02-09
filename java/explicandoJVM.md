# Explicando a JVM (Java Virtual Machine)

## O que é JVM?
A JVM (Java Virtual Machine) é uma máquina virtual que executa o bytecode gerado pelo compilador Java. Ela é responsável por executar o código Java em qualquer plataforma que tenha a JVM instalada.<br>
Quando nos compilamos um arquivo **.java**, arquivos **.class** (que contém o byte-code) com os mesmos nomes das classes presentes em **.java** são gerados pelo compilador Java. A JVM é responsável por executar esses arquivos **.class**. A JVM é uma parte da JRE (Java Runtime Environment).
<br>
<br>
![Arquitetura da JVM](jvm-architecture540.jpg)
<br>
<br>
Componentes da JVM:
- Class Loader (Carregador de Classe)
- Run Time Data Area / JVM Memory (Areas de dados de tempo de execução)
- Execution Engine (Motor de Execução)
- Native Interfaces (Interfaces Nativas)
- Native Libraries (Bibliotecas Nativas)

## Class Loader
As Class Loaders são responsavéis por carregar classes Java dinamicamente para a JVM durante o tempo de execução. Elas também são parte da JRE. Assim, a JVM não precisa saber sobre arquivos underlying ou arquivos do sistema em ordem para executar programas Java, graças ao Class Loader.
<br>
Ela é responsavél por três atividades:
- Loading (Carregamento)
- Linking (Vinculação)
- Initialization (Inicialização)

### Loading
O Class Loader lê o arquivo **.class**, gera o código binário correspodente e salva as seguintes informações na memória da JVM chamada de method area (área de método):
- Nome da classe e seu imediato superclasse
- Se o **.class** é uma classe, interface ou enum
- Modificadores de acesso, métodos e variáveis de instância

Depois de carregar a classe, a JVM cria um objeto (único para cada) do tipo **CLass** para representa-lo na memória heap. É um objeto do tipo **java.lang.Class** portanto é possível usa-lo para acessar os métodos e variáveis da classe. Obetem-se essa referência através do método **getClass()** da classe **Object**.

### Linking
Desempenha três atividades:
- Verificação: Verifica se o arquivo está formatado corretamente e gerado por um compilador válido. Se não, obteremos a execeção de tempo de execução **java.lang.VerifyError**. Essa tarefa é feita pelo **Bytecode Verifier**.
- Preparação: A JVM aloca memória para variáveis estáticas e inicializa memória para valores padrão.
- Resolução (Opccional): Este é o processo de substituir referências simbólicas por referências diretas. Isso é feito procurando dentro da method area para localizar a entidade referenciada.

### Initialization
Nesta fase todas as variavéis estáticas são atribuídas com seus valores definidos no código. Isso é executado de cima pra baixo na classe e de pai para filho na hierarquia de herança.

Há três tipos de Classes Loaders:
- Bootstrap Class Loader: Superclasse de Extension Class Loader. Toda implementação da JVM deve ter uma Bootstrap Class Loader. Ele carrega o arquivo **rt.jar**, no diretório **JAVA_HOME/jre/lib**, que contém toda as classes do Java Standard Edition como o pacote **jav.lang**, **java.net**, **java.util** ...
- Extension Class Loader: Este é o class loader filho do Bootstrap Class Loader e pai do System Class Loader. Ele carrega o arquivo **jar** localizado dentro do diretório **JAVA_HOME/jre/lib/ext**.
- System/Application Class Loader: Filho do Extension Class Loader. Isto carega as classes para o **classpath**. Por padrão, o **classpath** está definido com o diretorio atual, mas você consegue trocar usando "-cp" ou "-classpath".

## Run Time Data Area / JVM Memory

### Method Area
No method area, todas as informações em nivel de classe como nome, nome do pai, métodos e informações de variavéis etc, são armazenadas, incluindo variavéis estáticas. Há apenas um method area por JVM e é um recurso compartilhado.

### Heap
Heap é o local onde todos os objetos são alocados. Há também uma por JVM e é um recurso compartilhado.

### Stack
Para toda thread, a JVM cria uma stack em tempo de execução que é armazenada aqui.
<br> A stack do Java armazena frames. Todo bloco da stack é chamado de stack frame (pilha de quadros) e armazena chamada de métodos. Todas as variavéis locais são armazenadas em seu frame correspondente. 
<br>Quando uma thread termina sua stack em tempo de execução é destruída pela JVM.

### PC Registers
Program Counter (Contador de Programa) guarda o endereço da instrução atual de uma thread que está sendo executada. Cada thread tem seu PC.

### Native Method Stack
Contém todos os métodos nativos usados na aplicação. Para cada thread um native methods é criado.

## Execution Engine
Executa o **.class**. Lê linha por linha do byte-code, usa os dados e informações presentes na memória e executa instruções. Contém:
- Interpreter (Interpretador): Lê o byte-code e executa a instrução. A desvantagem é que toda vez que um método é chamado multiplas vezes ele é requerido.
- Compilador Just-in-Time (JIT): Isto é usado par aumentar a perfomance. O JIT compila partes do byte-code que tem funcionalidade similar ao mesmo tempo. Aqui, o termo "compilador" refere-se a um tradutor de instrução definida por uma JVM para instrução definida por uma CPU. O JIT aumenta a eficiência do interpretador, pois ele provê código nativo para que parte da reinterpretação em multiplas chamadas de método, não seja requirida.
- Garbage Collector (Coletor de lixo): Ele destrói objetos sem referência.
  
## Native Interfaces
Java Native Interface é um framework que provê uma interface para comunicação com outras aplicações escritas em outras linguagens como C e C++. 

## Native Libraries
Coleção de bibliotecas nativas (C, C++) que são requiridas pelo motor de execução (Engine execution).

## Referências
[How JVM Works](https://www.geeksforgeeks.org/jvm-works-jvm-architecture/)
<br>
[JVM Architecture](https://www.javatpoint.com/jvm-java-virtual-machine)
