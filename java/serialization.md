# Serialização
É o processo de conversão de um estado de um objeto em uma sequência de bytes, enquanto *Descerialização* é o 
processo inverso. A serialização é útil quando queremos salvar um objeto no disco ou envia-lo pela rede ou até serializado em uma JVM e descerializado em outra.
<br>
Para realizar uma serialização é necessário implementar a interface `java.io.Serializable` na classe. Para indicar que um atributo não deve ser serializado utiliza-se a palavra-chave `transient`.

## Serialização e Descerialização
As classes *ObjectInputStream* e *ObjectOutputStream* são classes que extendem `java.io.InputStream` and `java.io.OutputStream`, respectivamente.
<br>
O método mais importante de *ObjectOutputStream* é:

``` java
    public final void writeObject(Object o) throws IOException;
```
Este método pega um objeto serializavel e converte em uma sequência de bytes. Similarmente, o método mais importante de *ObjectInputStream* é:

```java
    public final Object readObject() 
        throws IOException, ClassNotFoundException;
```
Este método consegue ler uma sequência de bytes e converter de volta em um objeto Java.
<br>
Exemplo de serialização com a classe *Person*:

```java
    public class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        static String country = "ITALY";
        private int age;
        private String name;
        transient int height;

        // getters and setters
    }
```
O teste permite mostrar como salvar um objeto do tipo *Person* em um arquivo local e lê o mesmo de volta:

```java
    @Test 
public void whenSerializingAndDeserializing_ThenObjectIsTheSame() () 
  throws IOException, ClassNotFoundException { 
        Person person = new Person();
        person.setAge(20);
        person.setName("Joe");
        
        FileOutputStream fileOutputStream
        = new FileOutputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream 
        = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();
        
        FileInputStream fileInputStream
        = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream
        = new ObjectInputStream(fileInputStream);
        Person p2 = (Person) objectInputStream.readObject();
        objectInputStream.close(); 
    
        assertTrue(p2.getAge() == person.getAge());
        assertTrue(p2.getName().equals(person.getName()));
    }
```
Usamos o *ObjectOutputStream* para salvar o estado deste objeto em um arquivo usando *FileOutputStream*. Este arquivo está sendo carregado usando *FileInputStream*. *ObjectInputStream* pega essa sequência e converte em um novo objeto chamado *p2*

## Ressalvas sobre Serializações do Java

### Herança e Composição
Quando uma classe implementa a interface `java.io.Serializable`, todas as suas sub-classes se tornam serializavéis. Quando um objeto faz refência a outro objeto, este objeto deve implementar a interface *Serializable* separadamente, caso contrário será lançada a *NotSerializableException*:

```java
    public class Person implements Serializable {
        private int age;
        private String name;
        private Address country; // must be serializable too
    }
```
Se um dos atributos de uma classe serializavél é um array de objetos, todos esses objetos devem ser serializavéis ou será lançada uma *NotSerializableException*.

### Versão Serial UID
A JVM associa um número de versão (*long*) para cada classe serializavel, chamado SerialVersionUID, no qual é usado durante a *Deserialização* para verificar (pelo receptor e pelo remetente da classe serializada) se objetos salvos e carregados tem os mesmos atributos e portanto são compativeís com a serialização. Se o receptor carregar uma classe para a o objeto com UID diferente do correspondente então vai resultar em uma *InvalidClassException*.

## Referências
[Introdution to Java Serialization](https://www.baeldung.com/java-serialization#serialization-and-deserialization)
<br>