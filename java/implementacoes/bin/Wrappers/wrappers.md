# Wrapper Class
É uma classe cujo o objeto envolve (wrapper) ou contém um tipo de dado primitivo. Quando criamos um objeto para uma classe wrapper, ele contém um campo que podemos armazenar tipos de dados primitivos. Deste modo conseguimos converter tipos primitivos em objetos.

## Necessidades de usar uma Wrapper class
1. As classes do pacote *java.util* manipulam apenas objetos
2. Estruturas de dados do framework *Collection*, como *ArrayList*, armazenam apenas objetos (tipos referência) e não tipos primitivos.
3. É necessário um objeto para suportar a sincronização no  multithreading.

## Vantagens das Wrapper Class
1. Com um objeto podemos chamar muitos métodos: *compareTo()*, *equals()*, *toString()*...
2. Objetos permitem valores null
3. Serialização permite apenas dados de objetos

## Tipos primitivos e sua Wrapper class correspondente
| Tipo de dados primitivo | Wrapper class |
|:-----------------------:|:-------------:|
| char | Character |
| byte | Byte |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
| boolean | Boolean |

## Autoboxing e Unboxing
1. **Autoboxing**<br>
   A conversão automática do tipo primitivo para o objeto da sua Wrapper class correspondente.<br>
   Exemplo:
   ```java
    import java.util.ArrayList;
    class Autoboxing {
        public static void main(String[] args)
        {
            char ch = 'a';
            Character a = ch;

            ArrayList<Integer> arrayList
                = new ArrayList<Integer>();

            arrayList.add(25);

            System.out.println(arrayList.get(0));
        }
    }
   ```

2. **Unboxing**<br>
   É apenas o processo reverso do autoboxing.<br>
   Exemplo:
   ```java
    import java.util.ArrayList;

    class Unboxing {
        public static void main(String[] args)
        {
            Character ch = 'a';
            char a = ch;

            ArrayList<Integer> arrayList
                = new ArrayList<Integer>();
            arrayList.add(24);
            int num = arrayList.get(0);

            System.out.println(num);
        }
    }
   ```
