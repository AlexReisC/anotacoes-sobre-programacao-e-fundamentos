# SOLID
SOLID é uma junção de principíos e boas práticas que visam melhorar a arquitetura e o design de um projeto, isso inclui facilitar a manutenção e a compreensão.

O acrônimo significa:
* S - Single Responsability Principle
* O - Open/Closed Principle
* L - Liskov Substitution Principle
* I - Interface Segregation Principle
* D - Dependency Inversion Principle

## Single Responsability Principle
O principio da responsabilidade única diz que uma classe deve ter **um único** objetivo, ou seja, ela deve possuir apenas uma função ou funções similares.

### Exemplo
**Errado**: A classe `User` é responsável tanto pelos dados do usuário quanto pela persistência no banco de dados.
```java
class User {
    private String name;
    private String email;

    public void save() {
        // código para salvar usuário no banco de dados
    }

    // getters e setters
}
```
**Correto**: Separação da lógica de persistência em uma classe diferente (`UserRepository`).
```java
class User {
    private String name;
    private String email;

    // getters e setters
}

class UserRepository {
    public void save(User user) {
        // código para salvar usuário no banco de dados
    }
}

class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }
}
```

## Open/Closed Principle
O principio aberto/fechado traz a ideia de que uma classe deve ser **aberta para extensões e fechada para modificações**. Ou seja, outras classes podem acessar o que aquela classe possuí, mas não podem altera-la.

Não é que não se possa adicionar uma nova função à classe, mas não se pode alterar o que já existe.

### Exemplo
**Errado**: A classe `PaymentProcessor` é modificada para suportar novos métodos de pagamento.
```java
class PaymentProcessor {
    public void payWithCreditCard() {
        System.out.println("Pagamento com cartão de crédito realizado.");
    }

    public void payWithPayPal() {
        System.out.println("Pagamento com PayPal realizado.");
    }

    // Adicionar novo método sempre que surgir um novo tipo de pagamento
}
```
**Correto**: A classe `PaymentProcessor` usa uma abstração `Payment`, permitindo a extensão de novos métodos de pagamento sem modificar a classe.
```java
abstract class Payment {
    public abstract void pay();
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Pagamento com cartão de crédito realizado.");
    }
}

class PayPalPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Pagamento com PayPal realizado.");
    }
}

class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.pay();
    }
}
```

## Liskov Substitution Principle
O principio da substituição de Liskov veio de Barbara Liskov, que foi uma cientista americana que trouxe a ideia de que
> “As classes derivadas devem ser substituíveis pelas suas classes bases”.

**Esse princípio traz a ideia de herança**. Temos uma classe pai que possui atributos genericos e temos uma classe filha que herda esses atributos e pode ter outros atributos especifícos para si mesma.

### Exemplo
**Errado**: A substituição de Square por Rectangle pode quebrar a lógica do programa.
```java
class Rectangle {
    private int width;
    private int height;

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getArea() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
```
**Correto**: Criar uma hierarquia de classes que respeita as expectativas de substituição.
```java
abstract class Shape {
    public abstract int getArea();
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public int getArea() { return width * height; }
}

class Square extends Shape {
    private int side;

    public int getSide() { return side; }
    public void setSide(int side) { this.side = side; }

    @Override
    public int getArea() { return side * side; }
}
```

## Interface Segregation Principle
Principio da segregação de interfaces
> “Classes não devem ser forçadas a depender de métodos que não usam.”

Quando você aplica o principio da herança, uma classe herda de outra, então a classe filha é obrigada a implementar os métodos da classe pai, mas isso vai contra os principios do SOLID.

Com o princípio de segregação de interface, é possível implementar somente o que importa para as nossas classes. 

### Exemplo
**Errado**: Uma única interface para impressora e scanner força a implementação de métodos não necessários.
```java
interface MultiFunctionDevice {
    void print();
    void scan();
}

class OldPrinter implements MultiFunctionDevice {
    @Override
    public void print() {
        System.out.println("Imprimindo documento...");
    }

    @Override
    public void scan() {
        // Não implementado
    }
}
```
**Correto**: Segregar interfaces para diferentes funcionalidades.
```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class MultiFunctionPrinter implements Printer, Scanner {
    @Override
    public void print() {
        System.out.println("Imprimindo documento...");
    }

    @Override
    public void scan() {
        System.out.println("Digitalizando documento...");
    }
}

class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Imprimindo documento...");
    }
}
```

## Dependency Inversion Principle
O principio da inversão de dependência traz a ideia de que
> “Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender da abstração.”

> “Abstrações não devem depender de detalhes. Os detalhes devem depender das abstrações.”

Em outras palavras, os módulos que são classes de alto nível devem depender de conceitos, também chamadas de abstrações

### Exemplo
**Errado**: O módulo de alto nível depende diretamente do módulo de baixo nível.
```java
class EmailService {
    public void sendEmail(String message) {
        System.out.println("Email enviado: " + message);
    }
}

class Notification {
    private EmailService emailService = new EmailService();

    public void notifyUser(String message) {
        emailService.sendEmail(message);
    }
}
```
**Correto**: Ambos os módulos de alto nível e baixo nível dependem de uma abstração.
```java
interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email enviado: " + message);
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS enviado: " + message);
    }
}

class Notification {
    private MessageService messageService;

    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String message) {
        messageService.sendMessage(message);
    }
}
```

# Referência
[SOLID: guia completo dos 5 principios](https://blog.betrybe.com/linguagem-de-programacao/solid-cinco-principios-poo/)