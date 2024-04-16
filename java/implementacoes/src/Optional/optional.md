# Optional
Uma classe com o intuito de tentar evitar o **NullPointerException**. Não é indicado utilizar como parametro ou variavel de classe. `Optional<T>`. Essa classe tem um conjunto de métodos:
- `of()`: retorna um `Opcional` do valor se não for nulo ou vazio se for.
- `ofNullable`: o mesmo que o método `of` mas para valores que podem ser nulos.
- `empty()`: retorna um `Optional` vazio.
- `ifPresent()`: se o valor está presente executa uma ação
- `orElse()`: se não estiver presente executa outra ação
- `orElseThrow()`: se não estiver presente lança uma exceção