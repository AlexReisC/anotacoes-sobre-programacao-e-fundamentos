# Generics
Usando generics `<Tipo>` é possível criar classes e métodos que que trabalham com diferentes tipos de dados.
<br>
Ao usar arrays com um tipo definido é possivel passar como parametro as subclasses do tipo, mas com listas `List` o tipo especificado precisa ser exatamente o mesmo do parametro. Mas para tal também podemos usar um recurso chamado wildcard.
<br>
Wildcard: "?". Para passar listas de subclasses da classe da lista definida com parametro usamos `<? extends NomeDaClasse>`. Porém dessa forma não é possível adicionar elementos na lista. Para contornar esse novo problema podemos utilizar `<? super NomeDaClasse>`, desse jeito indicamos que o parametro será a propria classe ou um pai dela e então podemos adicionar subclasses pois tem uma relação de "é um" `lista.add(new SubClasse)`.
<br>
Para tornar uma classe genérica, adicionamos `<T>` ao nome dela, assim podemos passar qualquer classe no generics na instanciação da classe generica. Estamos declarando o tipo diretamente na classe (quantos quisermos).
<br>
Também é possível criar um método genérico. Exemplo: `private static <T> void criarArrayComObjeto(T t)`. Podemos também, por exemplo, passar um tipo `Comparable` nesse caso seria: `<T extends Comparable>`.